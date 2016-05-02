package com.aiss.omnidrive.client.views.drive;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aiss.omnidrive.client.controllers.DriveController;
import com.aiss.omnidrive.client.rpc.DriveService;
import com.aiss.omnidrive.client.rpc.DriveServiceAsync;
import com.aiss.omnidrive.client.rpc.OAuthService;
import com.aiss.omnidrive.client.rpc.OAuthServiceAsync;
import com.aiss.omnidrive.shared.OAuthToken;
import com.aiss.omnidrive.shared.drive.files.DriveFile;
import com.aiss.omnidrive.shared.drive.files.DriveFilesList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;

public class DriveFilesListView extends Composite {

	private final OAuthServiceAsync oauthService = GWT.create(OAuthService.class);
	private final DriveServiceAsync driveService = GWT.create(DriveService.class);
	
	public DriveFilesListView(){
		new DriveFilesListView(new HashMap<String, String>());
	}
	
	public DriveFilesListView(final Map<String, String> params){
		final Panel content, infoBar;
		final String parent;
		if (DriveController.isConnect()) {
			content = new FlowPanel();
			if (!DriveController.hasToken()) {
				oauthService.refreshToken("drive", Cookies.getCookie("driveToken"), new AsyncCallback<OAuthToken>() {
					@Override
					public void onSuccess(OAuthToken token) {
						// TODO Auto-generated method stub
						if (token.isCorrect()){
							Date tokenAccessExpireIn = new Date(new Date().getTime() + (token.getExpiresIn() * 1000));
							Cookies.setCookie("driveAccessToken", token.getAccessToken(), tokenAccessExpireIn);
						} else {
							Cookies.removeCookie("driveToken");
							Window.Location.replace(GWT.getHostPageBaseURL());
						}
					}
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
			}
			if (params.containsKey("parent")) {
				parent = params.get("parent");
			} else {
				parent = "root";
			}
			infoBar = new FlowPanel();
			infoBar.addStyleName("infobar");
			infoBar.add(new HTML(params.get("directorioAnterior")));
			content.add(infoBar);
			driveService.getFiles(Cookies.getCookie("driveAccessToken"), parent, new AsyncCallback<DriveFilesList>() {
				
				@Override
				public void onSuccess(DriveFilesList files) {
					// TODO Auto-generated method stub
					for(DriveFile file : files.getFiles()){
						content.add(new DriveFileView(params, file));
					}
				}
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
			content.addStyleName("paddingContent");
			initWidget(content);
		} else {
			Window.Location.replace(GWT.getHostPageBaseURL());
		}
	}
}
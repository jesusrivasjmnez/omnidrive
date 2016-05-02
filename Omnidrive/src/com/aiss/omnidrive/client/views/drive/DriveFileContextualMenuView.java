package com.aiss.omnidrive.client.views.drive;

import com.aiss.omnidrive.client.rpc.DriveService;
import com.aiss.omnidrive.client.rpc.DriveServiceAsync;
import com.aiss.omnidrive.client.rpc.OAuthService;
import com.aiss.omnidrive.client.rpc.OAuthServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;

public class DriveFileContextualMenuView extends Composite {

	private final OAuthServiceAsync oauthService = GWT.create(OAuthService.class);
	private final DriveServiceAsync driveService = GWT.create(DriveService.class);
	
	
	public DriveFileContextualMenuView(ContextMenuEvent event){
		int positionX, positionY;
		PopupPanel menuContextual = new PopupPanel(true);
		FlowPanel opcionesMenu = new FlowPanel();
		
		positionX = event.getNativeEvent().getClientX();
		positionY = event.getNativeEvent().getClientY();
		menuContextual.addStyleName("menuContextual");
		menuContextual.setPopupPosition(positionX, positionY);
		menuContextual.show();
	}
	
}
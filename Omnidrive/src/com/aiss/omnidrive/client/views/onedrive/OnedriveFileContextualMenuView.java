package com.aiss.omnidrive.client.views.onedrive;

import java.util.HashMap;
import java.util.Map;

import com.aiss.omnidrive.client.controllers.MainController;
import com.aiss.omnidrive.client.rpc.OAuthService;
import com.aiss.omnidrive.client.rpc.OAuthServiceAsync;
import com.aiss.omnidrive.client.rpc.OnedriveService;
import com.aiss.omnidrive.client.rpc.OnedriveServiceAsync;
import com.aiss.omnidrive.shared.onedrive.files.OnedriveFile;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

public class OnedriveFileContextualMenuView extends Composite {

	private final OAuthServiceAsync oauthService = GWT.create(OAuthService.class);
	private final OnedriveServiceAsync onedriveService = GWT.create(OnedriveService.class);
	
	
	public OnedriveFileContextualMenuView(final OnedriveFile file, ContextMenuEvent event){
		int menuHeight = 200;
		int menuWidth = 150;
		int positionX, positionY;
		final PopupPanel menuContextual = new PopupPanel(true);
		FlowPanel opcionesMenu = new FlowPanel();
		HTML opcionVerDetalles, divider1;
		
		positionX = event.getNativeEvent().getClientX() + 15;
		positionY = event.getNativeEvent().getClientY() + 5;
		if ((positionX + menuWidth) >= Window.getClientWidth()) {
			positionX -= menuWidth;
		}
		if ((positionY + menuHeight) >= Window.getClientHeight()) {
			positionY -= menuHeight;
		}
		menuContextual.addStyleName("menuContextual");
		menuContextual.setPopupPosition(positionX, positionY);
		opcionVerDetalles = new HTML("Informacion");
		opcionVerDetalles.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Map<String, String> newParams = new HashMap<String, String>();
				newParams.put("option", "showFileDetails");
				newParams.put("idFile",file.getId());
				MainController.go("onedrive", newParams);
				menuContextual.hide();
			}
		});
		opcionVerDetalles.addStyleName("opcionMenuContextual");
		opcionesMenu.add(opcionVerDetalles);
		
		divider1 = new HTML();
		divider1.addStyleName("dividerMenuContextual");
		opcionesMenu.add(divider1);
		menuContextual.add(opcionesMenu);
		menuContextual.show();
	}
	
}
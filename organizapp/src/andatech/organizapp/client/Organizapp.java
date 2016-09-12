package andatech.organizapp.client;

import java.util.Collection;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import andatech.organizapp.client.gui.FlowController;
import andatech.organizapp.client.rpc.DriveRPC;
import andatech.organizapp.client.rpc.DriveRPCAsync;
import andatech.organizapp.client.rpc.TrelloRPC;
import andatech.organizapp.client.rpc.TrelloRPCAsync;
import andatech.organizapp.shared.domain.drive.File;
import andatech.organizapp.shared.domain.trello.Boards;

public class Organizapp implements EntryPoint {
	
	 private VerticalPanel mainPanel = new VerticalPanel();

	public void onModuleLoad() {

		// final TrelloRPCAsync contactService = GWT.create(TrelloRPC.class);
		// contactService.getAllBoards("ec97bdea7116da6064cbddc09718ea77c5ed292f8f4384f2d9bccffe07dab704",
		// new AsyncCallback<List<Boards>>() {
		//
		// public void onFailure(Throwable e) {
		// Window.alert("Error loading contacts: " + e.getMessage());
		//
		// }
		//
		// public void onSuccess(List<Boards> b) {
		// Window.alert("Manu no es nada gay");
		// }
		// });

		Button bt = new Button("Clica!");
		bt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Autenticacion.authorize();
			}
		});
		Button bt2 = new Button("Fueraaaa!");
		bt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Autenticacion.desAuthorize();
			}
		});
		Button bt1 = new Button("Clica!");
		Element elem = bt1.getElement();
		elem.setAttribute("onclick", "trelloAuth();");

		Button bt3 = new Button("Clica Trello!");
		bt3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final TrelloRPCAsync contactService = GWT.create(TrelloRPC.class);
				contactService.getAllBoards("ec97bdea7116da6064cbddc09718ea77c5ed292f8f4384f2d9bccffe07dab704",
						new AsyncCallback<List<Boards>>() {
							public void onFailure(Throwable e) {
								Window.alert("Error loading contacts: " + e.getMessage());

							}

							public void onSuccess(List<Boards> b) {
								Window.alert(b.get(0).getName());

							}
						});
			}
		});
		
		Button bt4 = new Button("Clica drive!");
		bt4.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final DriveRPCAsync contactService = GWT.create(DriveRPC.class);
				contactService.getAllFiles("ya29.AHES6ZQEnuWPfNEH5A7TGwDqijvFLQXBlJcUKnPwHUpwPtbuX4EoMw",new AsyncCallback<List<File>>() {
					
							public void onFailure(Throwable e) {
								Window.alert("Error loading contacts: " + e.getMessage());

							}

							public void onSuccess(List<File> f) {
								Window.alert(f.get(0).getName());

							}
						});
			}
		});
		
//		Button bt5 = new Button("GUI");
//		bt5.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				FlowController.go("MainView", null);
//			}
//		});
		
		FlexTable tareas = new FlexTable();
		tareas.setBorderWidth(2);
		tareas.setText(0, 0,"TAREAS PENDIENTES");
		tareas.setText(0, 1,"TAREAS EN CURSO");
		tareas.setText(0, 2,"TAREAS FINALIZADAS");
		tareas.setWidth("510px");
		
		tareas.setText(1, 0,"Mercadona");
		tareas.setText(2, 0,"Pizza hut");
		
		tareas.setText(1, 1,"Coche");
		tareas.setText(2, 1,"Borracho");
		
		tareas.setText(1, 2,"Gas");
		tareas.setText(2, 2,"Incienso");
		
		mainPanel.setSize("1350px", "760px");
		mainPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		mainPanel.setVerticalAlignment(VerticalPanel.ALIGN_TOP);
		mainPanel.add(tareas);
		
		
		RootPanel.get().add(mainPanel);

//		RootPanel.get().add(bt);
//		RootPanel.get().add(bt1);
//		RootPanel.get().add(bt2);
//		RootPanel.get().add(bt3);
//		RootPanel.get().add(bt4);
//		RootPanel.get().add(bt5);
	}
}

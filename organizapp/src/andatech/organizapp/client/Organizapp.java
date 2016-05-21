package andatech.organizapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Organizapp implements EntryPoint {

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
		final Label lb = new Label();

		Button bt = new Button("Clica!");
		bt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Autenticacion.authorize();
			}
		});
		Button bt2 = new Button("Fueraaaa!");
		bt2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Autenticacion.desAuthorize();
				lb.setText(Autenticacion.trelloToken());
			}
		});
		Button bt1 = new Button("Clica!");
		Element elem = bt1.getElement();
		elem.setAttribute("onclick", "trelloAuth();");

		/*Button bt3 = new Button("Clica Trello!");
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
		});*/

		RootPanel.get().add(bt);
		RootPanel.get().add(bt1);
		RootPanel.get().add(bt2);
		RootPanel.get().add(lb);
		//RootPanel.get().add(bt3);
	}
}

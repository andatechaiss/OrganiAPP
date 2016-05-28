package andatech.organizapp.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import andatech.organizapp.client.resources.Proyecto;
import andatech.organizapp.client.resources.utils.UtilsConfig;
import andatech.organizapp.shared.domain.trello.Boards;

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

		final Proyecto p = new Proyecto();
		
		Button bt = new Button("Clica!");
		bt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Autenticacion.authorize();
				Window.alert(p.toString());
			}
		});
		Button bt2 = new Button("Fueraaaa!");
		bt2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Autenticacion.desAuthorize();
				/*lb.setText(Autenticacion.trelloToken());
				final TrelloRPCAsync trello = GWT.create(TrelloRPC.class);
				trello.getAllCards(Autenticacion.trelloToken(),
				new AsyncCallback<List<Card>>() {
					public void onFailure(Throwable e) {}
					public void onSuccess(List<Card> b) {
						for(Card board : b)
						{
							final Label lb = new Label(board.getId());
							RootPanel.get().add(lb);
							Window.alert("si");
						}
						Window.alert("ya");
					}
				});*/
				/*final TrelloRPCAsync trello = GWT.create(TrelloRPC.class);
				Boards b = new Boards();
				b.setName("Prueba1");
				trello.deleteMember("574076014622f7ef79a1c492", "federicogarcia22", Autenticacion.trelloToken(),
				new AsyncCallback<Void>() {
					public void onFailure(Throwable e) {}
					public void onSuccess(Void result) {
						Window.alert("yaaa");
					}
				});*/
				
				p.setNombre("BORRAR");
				//p.setTrelloIdBoard("57445c301290fa15552b5962");
				//p.deleteAllLists();
				p.setConfig();
				//p.sincronizar();
				//Proyecto.crearProyectoExistente(p);
				Proyecto.crearProyectoNuevo(p);
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

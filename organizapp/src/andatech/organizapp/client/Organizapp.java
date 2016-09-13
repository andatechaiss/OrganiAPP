package andatech.organizapp.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import andatech.organizapp.client.rpc.OrganizappRPC;
import andatech.organizapp.client.rpc.OrganizappRPCAsync;
import andatech.organizapp.client.rpc.TrelloRPC;
import andatech.organizapp.client.rpc.TrelloRPCAsync;
import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.resources.ListaTarjetasResource;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.TareaResource;


/**
 * 
 * Hacer listas
 * Testear
 * Miembros
 * Sincronizacion de ids
 * Ubicaciones (maps)
 * Eventos (calendar)
 * Archivos (drive)
 * Empezar optimizacion
 * Testear optimizacion
 * GUI
 * 
 * @author Marcos
 *
 */





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

		final ProyectoResource p = new ProyectoResource();
		
		final OrganizappRPCAsync rpc = GWT.create(OrganizappRPC.class);
		final TrelloRPCAsync trello = GWT.create(TrelloRPC.class);
		Button bt = new Button("Autentificar");
		bt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Autenticacion.authorizeTrello();
				Autenticacion.authorizeGoogle();
				rpc.getProject(Autenticacion.trelloToken(), "57445c301290fa15552b5962", new AsyncCallback<ProyectoResource>(){
					public void onFailure(Throwable caught) {
					}
					public void onSuccess(ProyectoResource result) {
						p.setId(result.getId());
						Window.alert("yaa");
					}
				});
			}
		});
		
		Button btt1 = new Button("getAll");
		btt1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rpc.getFinishedTaskCard(Autenticacion.trelloToken(), p, new AsyncCallback<List<TareaResource>>(){
					public void onFailure(Throwable caught) {
					}
					public void onSuccess(List<TareaResource> result) {
						for(TareaResource r : result)
							Window.alert(r.getNombre());
					}
				});
			}
		});
		
		Button btt2 = new Button("TASK");
		btt2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				TareaResource t = new TareaResource();
				t.setNombre("tarea 1");
				t.setDescripcion("Esto es una tarea");
				t.setEstado("unassigned");
				rpc.insertTaskCard(Autenticacion.trelloToken(), p, t, new AsyncCallback<TareaResource>(){
					public void onFailure(Throwable caught) {
					}
					public void onSuccess(TareaResource result) {
							//Window.alert(result.toString());
					}
				});
			}
		});
		
		Button btt3 = new Button("insert new");
		btt3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				Email m = new Email();
//				m.setEmail("marcos.kafok@gmail.com");
//				rpc.insertMemberProject(Autenticacion.trelloToken(), p.getId(), m, new AsyncCallback<Void>(){
//					public void onFailure(Throwable caught) {
//						Window.alert(caught.getLocalizedMessage());
//					}
//					public void onSuccess(Void result) {
//						Window.alert("Mira");
//					}
//				});
//				rpc.deleteMemberProject(Autenticacion.trelloToken(), p.getId(), "5553c7bcc4bd859b1f7c6e6f", new AsyncCallback<Void>(){
//					public void onFailure(Throwable caught) {
//						Window.alert(caught.getLocalizedMessage());
//					}
//					public void onSuccess(Void result) {
//						Window.alert("Mira");
//					}
//				});
//				rpc.getMemberProject(Autenticacion.trelloToken(), p.getId(), new AsyncCallback<List<Member>>(){
//					public void onFailure(Throwable caught) {
//						Window.alert(caught.getLocalizedMessage());
//					}
//					public void onSuccess(List<Member> result) {
//						for(Member m : result)
//							Window.alert(m.toString());
//					}
//				});
//				ListaTarjetasResource list = new ListaTarjetasResource();
//				list.setNombre("mi lista");
//				list.setTipo("task");
//				list.setCondicion("finished");
//				rpc.insertListCard(Autenticacion.trelloToken(), p, list, new AsyncCallback<String>(){
//					public void onFailure(Throwable caught) {}
//					public void onSuccess(String result) {
//						Window.alert("mira");
//					}
//					
//				});
				rpc.getAllListCard(Autenticacion.trelloToken(), p, new AsyncCallback<List<ListaTarjetasResource>>(){
					public void onFailure(Throwable caught) {}
					public void onSuccess(List<ListaTarjetasResource> result) {
						for(ListaTarjetasResource l : result)
							Window.alert(l.toString());
					}
					
				});
			}
		});
		
		Button btt4 = new Button("insert old");
		btt4.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rpc.createProject(Autenticacion.googleToken(), Autenticacion.trelloToken(), "57445c301290fa15552b5962", "Antiguo", "Este es un proyecto de prueba", new AsyncCallback<ProyectoResource>(){
					public void onFailure(Throwable caught) {
					}
					public void onSuccess(ProyectoResource result) {
						Window.alert(result.toString());
					}
				});
			}
		});
		
		Button btt5 = new Button("update");
		btt5.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rpc.updateProject(Autenticacion.trelloToken(), "57445c301290fa15552b5962", "quitar", "ttttttttt", new AsyncCallback<Void>(){
					public void onFailure(Throwable caught) {
					}
					public void onSuccess(Void result) {
					}
				});
			}
		});
		
		Button btt6 = new Button("delete");
		btt6.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				rpc.deleteProject(Autenticacion.trelloToken(), "57445c301290fa15552b5962", new AsyncCallback<Void>(){
					public void onFailure(Throwable caught) {
					}
					public void onSuccess(Void result) {
					}
				});
			}
		});
		
		Button btt7 = new Button("Autentificar");
		btt7.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Autenticacion.authorizeTrello();
			}
		});
		
		Button btt = new Button("Hacer");
		btt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final TrelloRPCAsync trello = GWT.create(TrelloRPC.class);
				trello.getAllBoards(Autenticacion.trelloToken(),
				new AsyncCallback<List<Boards>>() {
					public void onFailure(Throwable e) {Window.alert("NOOO!!");}
					public void onSuccess(List<Boards> result) {
						Window.alert("yaaa");
					}
				});
				
				
				rpc.getAllProject(Autenticacion.trelloToken(), new AsyncCallback<List<ProyectoResource>>(){
					public void onFailure(Throwable caught) {
					}
					public void onSuccess(List<ProyectoResource> result) {
						for(ProyectoResource r : result)
							Window.alert(r.toString());
					}
				});
			}
		});
		
//		Button bt2 = new Button("Fueraaaa!");
//		bt2.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				//Autenticacion.desAuthorize();
//				/*lb.setText(Autenticacion.trelloToken());
//				final TrelloRPCAsync trello = GWT.create(TrelloRPC.class);
//				trello.getAllCards(Autenticacion.trelloToken(),
//				new AsyncCallback<List<Card>>() {
//					public void onFailure(Throwable e) {}
//					public void onSuccess(List<Card> b) {
//						for(Card board : b)
//						{
//							final Label lb = new Label(board.getId());
//							RootPanel.get().add(lb);
//							Window.alert("si");
//						}
//						Window.alert("ya");
//					}
//				});*/
//				/*final TrelloRPCAsync trello = GWT.create(TrelloRPC.class);
//				Boards b = new Boards();
//				b.setName("Prueba1");
//				trello.deleteMember("574076014622f7ef79a1c492", "federicogarcia22", Autenticacion.trelloToken(),
//				new AsyncCallback<Void>() {
//					public void onFailure(Throwable e) {}
//					public void onSuccess(Void result) {
//						Window.alert("yaaa");
//					}
//				});*/
//				
//				p.setNombre("BORRAR");
//				//p.setTrelloIdBoard("57445c301290fa15552b5962");
//				//p.deleteAllLists();
//				p.setConfig();
//				//p.sincronizar();
//				//Proyecto.crearProyectoExistente(p);
//				Proyecto.crearProyectoNuevo(p);
//			}
//		});
//		Button bt1 = new Button("Clica!");
//		Element elem = bt1.getElement();
//		elem.setAttribute("onclick", "trelloAuth();");
//
//		/*Button bt3 = new Button("Clica Trello!");
//		bt3.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				final TrelloRPCAsync contactService = GWT.create(TrelloRPC.class);
//				contactService.getAllBoards("ec97bdea7116da6064cbddc09718ea77c5ed292f8f4384f2d9bccffe07dab704",
//						new AsyncCallback<List<Boards>>() {
//							public void onFailure(Throwable e) {
//								Window.alert("Error loading contacts: " + e.getMessage());
//
//							}
//
//							public void onSuccess(List<Boards> b) {
//								Window.alert(b.get(0).getName());
//
//							}
//						});
//			}
//		});*/

		RootPanel.get().add(bt);
		RootPanel.get().add(btt);
		RootPanel.get().add(btt1);
		RootPanel.get().add(btt2);
		RootPanel.get().add(btt3);
		RootPanel.get().add(btt4);
		RootPanel.get().add(btt5);
		RootPanel.get().add(btt6);
		RootPanel.get().add(btt7);
//		RootPanel.get().add(bt1);
//		RootPanel.get().add(bt2);
		RootPanel.get().add(lb);
		//RootPanel.get().add(bt3);
	}
}

package andatech.organizapp.client.resources;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.client.Autenticacion;
import andatech.organizapp.client.CallerRPC;
import andatech.organizapp.client.rpc.CallbackVoid;
import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.domain.trello.Prefs;

public class Proyecto 
{
	private String nombre;
	private String descripcion;
	
	private String trelloIdBoard;
	private String trelloIdConfig;
	
	protected List<Lista> listas;
	//private termina o no
	//private lista de eventos (teminen o no)
	
	//private presentacion: fondo, colores...
	
	
	
	public Proyecto() 
	{
		nombre = "";
		descripcion = "";
		trelloIdBoard = "";
		trelloIdConfig = "";
		listas = new LinkedList<Lista>();
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTrelloIdBoard() {
		return trelloIdBoard;
	}

	public void setTrelloIdBoard(String trello_id_board) {
		this.trelloIdBoard = trello_id_board;
	}

	
	//listas
	public void crearLista(final Lista lista)
	{
		final Proyecto proy = this;
		lista.setProyecto(this);
		
		if(lista.getIdListTrello().equals(""))
		{
			CallerRPC.trello.getAllList(getTrelloIdBoard(), Autenticacion.trelloToken(), new AsyncCallback<List<Lists>>() {
				public void onFailure(Throwable e) {}
				public void onSuccess(List<Lists> result) 
				{
					//vemos si existe una lista o si podemos aprobechar alguna archivada
					Lists res = null;
					for(Lists l : result)
					{
						if(l.getClosed())
							res = l;
						
						if(l.getName().equals("Configuracion"))
						{
							res = l;
							break;
						}
					}
					
					//si la lista existia
					if(res != null)
					{
						lista.setIdListTrello(res.getId());
						
						//actualizar
						res.setClosed(false);
						res.setName(lista.getNombre());
						
						CallerRPC.trello.updateList(res, Autenticacion.trelloToken(), new AsyncCallback<Void>()
						{
							public void onFailure(Throwable caught) {}
							public void onSuccess(Void result) {
								lista.setConfig();
							}
						});
					}
					else
					{
						//insertar
						res = new Lists();
						res.setIdBoard(getTrelloIdBoard());
						res.setClosed(false);
						res.setName("Configuracion");
						
						CallerRPC.trello.insertList(res, Autenticacion.trelloToken(), new AsyncCallback<Void>()
						{
							public void onFailure(Throwable caught) {}
							public void onSuccess(Void result) {
								CallerRPC.trello.getAllList(proy.getTrelloIdBoard(), Autenticacion.trelloToken(), new AsyncCallback<List<Lists>>()
								{
									public void onFailure(Throwable caught) {}
									public void onSuccess(List<Lists> result) {
										String id = null;
										for(Lists l : result)
											if(l.getName().equals(lista.getNombre()) && !l.getClosed())
												id = l.getId();
												
										lista.setIdListTrello(id);
										lista.setConfig();
									}
								});
							}
						});
					}
				}
			});
		}
		
	}
	
	
	
	//Poyecto
	public static void crearProyectoNuevo(final Proyecto p)
	{
		Prefs prefs = new Prefs();
		prefs.setVoting("members");
		
		List<String> powerups = new ArrayList<String>();
		powerups.add("voting");
		
		final Boards board = new Boards();
		board.setName(p.getNombre());
		board.setDesc(p.getDescripcion());
		board.setPrefs(prefs);
		board.setPowerUps(powerups);
		
		CallerRPC.trello.insertBoard(board, Autenticacion.trelloToken(), new AsyncCallback<Void>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(Void result) {
				CallerRPC.trello.getAllBoards(Autenticacion.trelloToken(), new AsyncCallback<List<Boards>>()
				{
					public void onFailure(Throwable caught) {}
					public void onSuccess(List<Boards> result) {
						for(Boards b : result)
							if(b.getName().equals(board.getName()) && b.getDateLastActivity() == null)
								p.setTrelloIdBoard(b.getId());
						
						p.setConfig();
					}
				});
			}
		});
	}
	
	public static void crearProyectoExistente(final Proyecto p)
	{
		Prefs prefs = new Prefs();
		prefs.setVoting("members");
		
		List<String> powerups = new ArrayList<String>();
		powerups.add("voting");
		
		final Boards board = new Boards();
		board.setName(p.getNombre());
		board.setDesc(p.getDescripcion());
		board.setPrefs(prefs);
		board.setPowerUps(powerups);
		board.setId(p.getTrelloIdBoard());
		
		CallerRPC.trello.updateBoard(board, Autenticacion.trelloToken(), new AsyncCallback<Void>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(Void result) {
				p.setConfig();
			}
		});
	}
	
	public static void eliminarProyecto(Proyecto p)
	{
		//TODO
	}
	
	
	
	public void sincronizar()
	{
		final Proyecto proy = this;
		CallerRPC.trello.getBoard(trelloIdBoard, Autenticacion.trelloToken(), new AsyncCallback<Boards>() {
			public void onFailure(Throwable e) {}
			public void onSuccess(Boards result) 
			{
				proy.setDescripcion(result.getDesc());
				proy.setNombre(result.getName());
			}
		});
	}
	
	
	//borrar todas las listas
	public void deleteAllLists()
	{
		CallerRPC.trello.getAllList(getTrelloIdBoard(), Autenticacion.trelloToken(), new AsyncCallback<List<Lists>>() {
			public void onFailure(Throwable e) {}
			public void onSuccess(List<Lists> result) 
			{
				for(Lists l : result)
					deleteAllCards(l);
			}
		});
	}
	
	private void deleteAllCards(Lists list)//TODO darle una lista de las nuestras no la de trello
	{
		list.setClosed(true);
		CallerRPC.trello.updateList(list , Autenticacion.trelloToken(), new CallbackVoid());
		CallerRPC.trello.getAllCard(list.getId(), Autenticacion.trelloToken(), new AsyncCallback<List<Card>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<Card> result) {
				for(Card c : result)
					CallerRPC.trello.deleteCard(c.getId(), Autenticacion.trelloToken(), new CallbackVoid());
			}
		});
	}
	
	
	//configuracion extra 
	public void setConfig()
	{
		final Proyecto proy = this;
		
		//si no tenemos el id de la lista de configuracion
		if(trelloIdConfig.equals(""))
		{
			CallerRPC.trello.getAllList(getTrelloIdBoard(), Autenticacion.trelloToken(), new AsyncCallback<List<Lists>>() {
				public void onFailure(Throwable e) {}
				public void onSuccess(List<Lists> result) 
				{
					//vemos si existe una lista o si podemos aprobechar alguna archivada
					Lists res = null;
					for(Lists l : result)
					{
						if(l.getClosed())
							res = l;
						
						if(l.getName().equals("Configuracion"))
						{
							res = l;
							break;
						}
					}
					
					//si la lista existia
					if(res != null)
					{
						proy.trelloIdConfig = res.getId();
						
						//actualizar
						res.setClosed(false);
						res.setName("Configuracion");
						
						CallerRPC.trello.updateList(res, Autenticacion.trelloToken(), new AsyncCallback<Void>()
						{
							public void onFailure(Throwable caught) {}
							public void onSuccess(Void result) {
								setCardsConfig();
							}
						});
					}
					else
					{
						//insertar
						res = new Lists();
						res.setIdBoard(getTrelloIdBoard());
						res.setClosed(false);
						res.setName("Configuracion");
						
						CallerRPC.trello.insertList(res, Autenticacion.trelloToken(), new AsyncCallback<Void>()
						{
							public void onFailure(Throwable caught) {}
							public void onSuccess(Void result) {
								CallerRPC.trello.getAllList(proy.getTrelloIdBoard(), Autenticacion.trelloToken(), new AsyncCallback<List<Lists>>()
								{
									public void onFailure(Throwable caught) {}
									public void onSuccess(List<Lists> result) {
										String id = null;
										for(Lists l : result)
											if(l.getName().equals("Configuracion") && !l.getClosed())
												id = l.getId();
												
										proy.trelloIdConfig = id;
										proy.setCardsConfig();
									}
								});
							}
						});
					}
				}
			});
		}
		else
			proy.setCardsConfig();
		
		
		
	}
	
	private void setCardsConfig()
	{
		final Proyecto proy = this;
		
		CallerRPC.trello.getAllCard(trelloIdConfig, Autenticacion.trelloToken(), new AsyncCallback<List<Card>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<Card> result) {
				Card res = null;
				for(Card c : result)
					if(c.getName().equals("Proyecto"))
						res = c;
						
				Map<String, String> config = UtilsConfig.getConfigProyecto(proy);
				if(res != null)
				{
					res.setDesc(UtilsConfig.setConfig(config));
					CallerRPC.trello.updateCard(res, Autenticacion.trelloToken(), new CallbackVoid());
				}
				else
				{
					Card c = new Card();
					c.setName("Proyecto");
					c.setIdList(trelloIdConfig);
					c.setDesc(UtilsConfig.setConfig(config));
					
					CallerRPC.trello.insertCard(c, Autenticacion.trelloToken(), new CallbackVoid());
				}
			}
		});
	}

}

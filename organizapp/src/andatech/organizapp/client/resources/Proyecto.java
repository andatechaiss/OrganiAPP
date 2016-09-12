package andatech.organizapp.client.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.client.Autenticacion;
import andatech.organizapp.client.CallerRPC;
import andatech.organizapp.client.resources.utils.CallbackObject;
import andatech.organizapp.client.resources.utils.CallbackVoid;
import andatech.organizapp.client.resources.utils.UtilsConfig;
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
	private String trelloIdConfigProject;
	
	protected List<Lista> listas;
	private List<Evento> eventos;
	
	private boolean validOrganizapp;
	
	//private presentacion: fondo, colores...
	
	

	private static CallbackObject cobj = new CallbackObject(){
		public void run(Object obj) {}
	};
	
	
	
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
	
	public String getTrelloIdConfig() {
		return trelloIdConfig;
	}
	
	public void setTrelloIdConfig(String trelloIdConfig) {
		this.trelloIdConfig = trelloIdConfig;
	}
	
	public String getTrelloIdConfigProject() {
		return trelloIdConfigProject;
	}

	public void setTrelloIdConfigProject(String trelloIdConfigProject) {
		this.trelloIdConfigProject = trelloIdConfigProject;
	}
	
	public boolean isValidOrganizapp() {
		return validOrganizapp;
	}
	
	public boolean isTermina() {
		for(Evento e : eventos)
			if(e.isTerminacion())
				return true;
		
		return false;
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
						
						CallerRPC.trello.insertList(res, Autenticacion.trelloToken(), new AsyncCallback<String>()
						{
							public void onFailure(Throwable caught) {}
							public void onSuccess(String result) {
								lista.setIdListTrello(result);
								lista.setConfig();
							}
						});
					}
				}
			});
		}
		
	}
	
	
	
	//Poyecto
	public static void crearProyectoNuevo(final Proyecto p, final CallbackObject cobj)
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
		
		CallerRPC.trello.insertBoard(board, Autenticacion.trelloToken(), new AsyncCallback<String>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(String result) {
				p.setTrelloIdBoard(result);
				p.setConfig(cobj); 	//callback se manda a config
			}
		});
	}
	
	public static void crearProyectoNuevo(final Proyecto p)
	{
		crearProyectoNuevo(p, cobj);
	}
	
	
	public static void crearProyectoExistente(final Proyecto p, final CallbackObject cobj)
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
				p.setConfig(cobj); 	//callback se manda a config
			}
		});
	}
	
	public static void crearProyectoExistente(final Proyecto p)
	{
		crearProyectoExistente(p, cobj);
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
	public void setConfig(final CallbackObject cobj)
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
								setCardsConfig(cobj);
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
						
						CallerRPC.trello.insertList(res, Autenticacion.trelloToken(), new AsyncCallback<String>()
						{
							public void onFailure(Throwable caught) {}
							public void onSuccess(String result) {
								proy.trelloIdConfig = result;
								proy.setCardsConfig(cobj);
							}
						});
					}
				}
			});
		}
		else
			proy.setCardsConfig(cobj);
		
	}
	
	public void setConfig()
	{
		setConfig(cobj);
	}
	
	
	private void setCardsConfig(final CallbackObject cobj)
	{
		final Proyecto proy = this;
		
		//si no tenemos la carta de proyecto la obtenemos
		if(this.getTrelloIdConfigProject().equals(""))
		{
			CallerRPC.trello.getAllCard(trelloIdConfig, Autenticacion.trelloToken(), new AsyncCallback<List<Card>>()
			{
				public void onFailure(Throwable caught) {}
				public void onSuccess(List<Card> result) {
					Card res = null;
					for(Card c : result)
						if(c.getName().equals("Proyecto"))
							res = c;
							
					Map<String, String> config = null;//UtilsConfig.getConfigProyecto(proy); //TODO pa q no de error
					if(res != null)	//si la carta existia
					{
						res.setDesc(UtilsConfig.setConfig(config));
						CallerRPC.trello.updateCard(res, Autenticacion.trelloToken(), new CallbackVoid(cobj, null));	//termina la funcion
					}
					else	//sino existia
					{
						Card c = new Card();
						c.setName("Proyecto");
						c.setIdList(trelloIdConfig);
						c.setDesc(UtilsConfig.setConfig(config));
						
						CallerRPC.trello.insertCard(c, Autenticacion.trelloToken(), new AsyncCallback<String>()
						{
							public void onFailure(Throwable caught) {}
							public void onSuccess(String result) {
								proy.setTrelloIdConfigProject(result);
								cobj.run(null);	//termina la funcion
							}
						});
					}
				}
			});
		}
		else
		{
			Map<String, String> config = null;//UtilsConfig.getConfigProyecto(proy);  //TODO pa q no de error
			
			Card res = new Card();
			res.setDesc(UtilsConfig.setConfig(config));
			res.setId(getTrelloIdConfigProject());
			
			CallerRPC.trello.updateCard(res, Autenticacion.trelloToken(), new CallbackVoid(cobj, null));	//termina la funcion
		}
	}
	
	
//	public void getConfig()
//	{
//		final Proyecto proy = this;
//		final Map<String, String> map = new HashMap<String, String>();
//		
//		//si no tenemos la carta de proyecto la obtenemos
//		if(this.getTrelloIdConfigProject().equals(""))
//		{
//			CallerRPC.trello.getAllCard(trelloIdConfig, Autenticacion.trelloToken(), new AsyncCallback<List<Card>>()
//			{
//				public void onFailure(Throwable caught) {}
//				public void onSuccess(List<Card> result) {
//					Card res = null;
//					for(Card c : result)
//						if(c.getName().equals("Proyecto"))
//							res = c;
//					
//					Map<String, String> config = UtilsConfig.getConfigProyecto(proy);
//					
//					if(res != null)	//si la carta existe
//					{
//						UtilsConfig.setConfigProyecto(proy)
//						for(Map.Entry<String, String> em : UtilsConfig.getConfig(res.getDesc()).entrySet())
//							map.put(em.getKey(), em.getValue());
//						
//						//termina la funcion
//					}
//				}
//			});
//		}
//		else
//		{
//			CallerRPC.trello.getCard(this.getTrelloIdConfigProject(), Autenticacion.trelloToken(), new AsyncCallback<Card>()	//obtenemos carta con su ID
//			{
//				public void onFailure(Throwable caught) {}
//				public void onSuccess(Card result) {
//					for(Map.Entry<String, String> em : UtilsConfig.getConfig(result.getDesc()).entrySet())
//						map.put(em.getKey(), em.getValue());
//					
//					//termina la funcion
//				}
//			});
//		}
//	}

}

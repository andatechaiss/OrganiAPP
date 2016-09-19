package andatech.organizapp.client;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.client.gui.MapPanel;
import andatech.organizapp.client.gui.ProyectoView;
import andatech.organizapp.client.gui.ProyectosView;
import andatech.organizapp.client.resources.utils.CallbackVoid;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.resources.EventoResource;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.TareaResource;
import andatech.organizapp.shared.resources.UbicacionResource;

public class Client 
{
	private static Client instance;
	
	private ProyectoResource proyecto;
	
	private List<TareaResource> listaTareasSinAsignar;
	private List<TareaResource> listaTareasEmpezadas;
	private List<TareaResource> listaTareasTerminadas;
	private List<UbicacionResource> listaUbicaciones;
	private List<EventoResource> listaEventos;
	
	
	private Client()
	{
		proyecto = new ProyectoResource();
		
		listaTareasSinAsignar = new LinkedList<TareaResource>();
		listaTareasEmpezadas = new LinkedList<TareaResource>();
		listaTareasTerminadas = new LinkedList<TareaResource>();
		listaUbicaciones = new LinkedList<UbicacionResource>();
		listaEventos = new LinkedList<EventoResource>();
	}
	
	
	public static Client get()
	{
		if(instance == null)
			instance = new Client();
		
		return instance;
	}
	
	public void sincronizar(final CallbackVoid call)
	{
		//obtenemos idList
		CallerRPC.trello.getAllList(proyecto.getId(), Autenticacion.trelloToken(), new AsyncCallback<List<Lists>>(){
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<Lists> result) 
			{
				for(Lists l : result)
				{
					switch(l.getName())
					{
						case "Configuracion":
							proyecto.getIdList().setListConfig(l.getId());
							CallerRPC.trello.getAllCard(l.getId(), Autenticacion.trelloToken(), new AsyncCallback<List<Card>>()
							{
								public void onFailure(Throwable caught) {}
								public void onSuccess(List<Card> result) 
								{
									for(Card c : result)
									{
										if(c.getName().equals("Proyecto"))
										{
											proyecto.getIdList().setCardConfig(c.getId());
											break;
										}
									}
									call.onSuccess(null);
								}
							});
							break;
							
						case "task":
							proyecto.getIdList().setListTask(l.getId());
							call.onSuccess(null);
							break;
							
						case "location":
							proyecto.getIdList().setListLocation(l.getId());
							call.onSuccess(null);
							break;
							
						case "date":
							proyecto.getIdList().setListDate(l.getId());
							call.onSuccess(null);
							break;
					}
				}
			}
		});
		
		
		//Rellenar cliente
		final Client _this = this;
		CallerRPC.oa.getAllTaskCard(Autenticacion.trelloToken(), proyecto, new AsyncCallback<List<TareaResource>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<TareaResource> result) 
			{
				for(TareaResource t : result)
				{
					switch(t.getEstado())
					{
						case "unssigned":
							_this.listaTareasSinAsignar.add(t);
							break;
							
						case "started":
							_this.listaTareasEmpezadas.add(t);
							break;
							
						case "finished":
							_this.listaTareasTerminadas.add(t);
							break;
					}
				}
			}
		});
		
		CallerRPC.oa.getAllLocationCard(Autenticacion.trelloToken(), proyecto, new AsyncCallback<List<UbicacionResource>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<UbicacionResource> result) 
			{
				for(UbicacionResource t : result)
				{
					_this.listaUbicaciones.add(t);
				}
			}
		});
		
		CallerRPC.oa.getAllEvents(Autenticacion.googleToken(), Autenticacion.trelloToken(), proyecto, new AsyncCallback<List<EventoResource>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<EventoResource> result) 
			{
				for(EventoResource t : result)
				{
					_this.listaEventos.add(t);
				}
			}
		});
	}
	
	
	public void onLoadProyectoView(final CallbackVoid call)
	{
		CallerRPC.oa.getAllProject(Autenticacion.trelloToken(), new AsyncCallback<List<ProyectoResource>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<ProyectoResource> result) 
			{
				for(ProyectoResource p : result)
					ProyectosView.aniadeProyectoResource(p.getId(), p.getNombre(), p.getDescripcion());
				
				call.onSuccess(null);
			}
		});
	}
	
	public void onLoadProject(final CallbackVoid call)
	{
		CallerRPC.oa.getAllTaskCard(Autenticacion.trelloToken(), proyecto.getId(), new AsyncCallback<List<TareaResource>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<TareaResource> result) 
			{
				for(TareaResource p : result)
				{
					
					switch(p.getEstado())
					{
						case "unassigned":
							listaTareasSinAsignar.add(p);
							ProyectoView.tareasU.add(p);
							break;
							
						case "started":
							listaTareasEmpezadas.add(p);
							ProyectoView.tareasS.add(p);
							break;
							
						case "finished":
							listaTareasTerminadas.add(p);
							ProyectoView.tareasF.add(p);
							break;
					}
				}
				
				call.onSuccess(null);
			}
		});
		
		CallerRPC.oa.getAllLocationCard(Autenticacion.trelloToken(), proyecto, new AsyncCallback<List<UbicacionResource>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<UbicacionResource> result) 
			{
				for(UbicacionResource u : result)
				{
					ProyectoView.mapa.getMarcas().add(MapPanel.crearMarca(u.getLatitud(), u.getLongitud(), u.getNombre(), u.getDescripcion()));
				}
				
				call.onSuccess(null);
			}
		});
		
		CallerRPC.oa.getAllEvents(Autenticacion.googleToken(), Autenticacion.trelloToken(), proyecto, new AsyncCallback<List<EventoResource>>()
		{
			public void onFailure(Throwable caught) {}
			public void onSuccess(List<EventoResource> result) 
			{
				for(EventoResource u : result)
				{
					ProyectoView.eventos.add(u);
				}
				
				call.onSuccess(null);
			}
		});
	}


	public ProyectoResource getProyecto() {
		return proyecto;
	}


	public void setProyecto(ProyectoResource proyecto) {
		this.proyecto = proyecto;
	}


	public List<TareaResource> getListaTareasSinAsignar() {
		return listaTareasSinAsignar;
	}


	public void setListaTareasSinAsignar(List<TareaResource> listaTareasSinAsignar) {
		this.listaTareasSinAsignar = listaTareasSinAsignar;
	}


	public List<TareaResource> getListaTareasEmpezadas() {
		return listaTareasEmpezadas;
	}


	public void setListaTareasEmpezadas(List<TareaResource> listaTareasEmpezadas) {
		this.listaTareasEmpezadas = listaTareasEmpezadas;
	}


	public List<TareaResource> getListaTareasTerminadas() {
		return listaTareasTerminadas;
	}


	public void setListaTareasTerminadas(List<TareaResource> listaTareasTerminadas) {
		this.listaTareasTerminadas = listaTareasTerminadas;
	}


	public List<UbicacionResource> getListaUbicaciones() {
		return listaUbicaciones;
	}


	public void setListaUbicaciones(List<UbicacionResource> listaUbicaciones) {
		this.listaUbicaciones = listaUbicaciones;
	}


	public List<EventoResource> getListaEventos() {
		return listaEventos;
	}


	public void setListaEventos(List<EventoResource> listaEventos) {
		this.listaEventos = listaEventos;
	}
	
}

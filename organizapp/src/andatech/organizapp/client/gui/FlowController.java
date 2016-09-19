package andatech.organizapp.client.gui;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.RootPanel;

public class FlowController 
{
	private static Map<String, View> vistas;
	private static String activa = "";
	
	
	public static void go(String view, Map<String, String> param)
	{
		View vista = vistas.get(view);
		if(vista == null)
			throw new IllegalArgumentException("Vista " + view + " no existe!");
		
		RootPanel.get().clear();
		vista.show(param);
		activa = view;
	}
	
	
	public static void update(String view, Map<String, String> param)
	{
		View vista = vistas.get(view);
		if(vista == null)
			throw new IllegalArgumentException("Vista " + view + " no existe!");
		
		vista.show(param);
		activa = view;
	}
	
	public static View get(String id)
	{
		return vistas.get(id);
	}
	
	public static String getActiva()
	{
		return activa;
	}
	
	
	public static void init()
	{
		vistas = new HashMap<String, View>();
		vistas.put("Proyectos", new ProyectosView());
		vistas.put("NuevoProyecto", new NuevoProyectoView());
		vistas.put("NuevaTarjeta", new NuevaTarjetaView());
		vistas.put("Proyecto", new ProyectoView());
	}
}

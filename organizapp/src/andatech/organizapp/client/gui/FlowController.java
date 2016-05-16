package andatech.organizapp.client.gui;

import java.util.Map;

import com.google.gwt.dev.util.collect.HashMap;
import com.google.gwt.user.client.ui.RootPanel;

public class FlowController 
{
	private static Map<String, View> vistas;
	
	
	public static void go(String view, Map<String, String> param)
	{
		View vista = vistas.get(view);
		if(vista == null)
			throw new IllegalArgumentException("Vista " + view + " no existe!");
		
		RootPanel.get().clear();
		vista.show(param);
	}
	
	
	public static void update(String view, Map<String, String> param)
	{
		View vista = vistas.get(view);
		if(vista == null)
			throw new IllegalArgumentException("Vista " + view + " no existe!");
		
		vista.show(param);
	}
	
	
	public static void init()
	{
		vistas = new HashMap<String, View>();
		
		//vistas.put("nombre_de_la_vista", new VistaCustom());
	}
}

package andatech.organizapp.client.resources.utils;

import java.util.HashMap;
import java.util.Map;

import andatech.organizapp.client.resources.Proyecto;

public class UtilsConfig 
{
	//parser config
	public static Map<String, String> getConfig(String config)
	{
		Map<String, String> res = new HashMap<String, String>();
		String[] lineas = config.split("\n");
		
		for(String s : lineas)
		{
			String[] opc = s.split(":");
			if(opc.length == 2)
				res.put(opc[0].trim(), opc[1].trim());
		}
		
		return res;
	}
	
	public static String setConfig(Map<String, String> config)
	{
		String res = "";
		for(Map.Entry<String, String> s : config.entrySet())
			res += s.getKey() + ": " + s.getValue() + "\n";
		
		return res;
	}
	
	
	//config proyecto
	public static Map<String, String> setConfigProyecto(Proyecto p)
	{
		Map<String, String> res = new HashMap<String, String>();
		res.put("Proyecto", "organizapp");
		
		return res;
	}
	
	public static boolean getConfigProyecto(Proyecto p, String config)
	{
		Map<String, String> c = getConfig(config);
		
		String res = c.get("Proyecto");
		if(res == null || !res.equals("organizapp"))
			return false;
		
		/*String res = c.get("prueba");
		if(res != null)
			p.setPrueba(new Object(res));*/
		
		return true;
	}
}

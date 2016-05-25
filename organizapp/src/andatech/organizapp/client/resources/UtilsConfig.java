package andatech.organizapp.client.resources;

import java.util.HashMap;
import java.util.Map;

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
	public static Map<String, String> getConfigProyecto(Proyecto p)
	{
		Map<String, String> res = new HashMap<String, String>();
		res.put("hola", "si");
		res.put("adios", "false");
		res.put("puta", "pene");
		res.put("maite", "escaqueada");
		
		return res;
	}
}

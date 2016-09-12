package andatech.organizapp.server.utils;

import java.util.HashMap;
import java.util.Map;

public class UtilsConfig 
{
	public static Map<String, String> mapConfig(String config)
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
	
	public static String parserConfig(Map<String, String> config)
	{
		String res = "";
		for(Map.Entry<String, String> s : config.entrySet())
			res += s.getKey() + ": " + s.getValue() + "\n";
		
		return res;
	}
	
	public static Map<String, String> mapConfigCard(String config)
	{
		Map<String, String> res = new HashMap<String, String>();
		int inicio = config.indexOf("-->{");
		if(inicio < 0)
			return res;
		
		int fin = config.indexOf("}<--");
		if(fin < 0)
			return res;
		
		String _c = config.substring(inicio, fin-1);
		
		return mapConfig(_c);
	}
	
	public static String getDescCard(String config)
	{
		int inicio = config.indexOf("-->{");
		if(inicio < 0)
			return config;
		
		int fin = config.indexOf("}<--");
		if(fin < 0)
			return config;
		
		return config.substring(fin-1, config.length());
	}
}

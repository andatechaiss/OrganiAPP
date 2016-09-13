package andatech.organizapp.server;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import andatech.organizapp.server.resources.trello.TrelloCardsResource;
import andatech.organizapp.server.utils.TrelloUtils;
import andatech.organizapp.server.utils.UtilsConfig;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.UbicacionResource;

public class LocationCard 
{
	//GETs
	public static List<UbicacionResource> getAllLocationCard(String trelloToken, ProyectoResource p)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, p, "location");
		
		List<UbicacionResource> res = new LinkedList<UbicacionResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
			res.add(TrelloUtils.getUbicacionFromCard(c));
		
		return res;
	}
	
	public static List<UbicacionResource> getNearLocationCard(String trelloToken, ProyectoResource p, double lat, double lon, double dist)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, p, "location");
		
		List<UbicacionResource> res = new LinkedList<UbicacionResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
		{
			UbicacionResource u = TrelloUtils.getUbicacionFromCard(c);
			double _lon = lon - u.getLongitud();
			double _lat = lat - u.getLatitud();
			if(_lon*_lon + _lat*_lat <= dist*dist)
				res.add(TrelloUtils.getUbicacionFromCard(c));
		}
		
		return res;
	}
	
	
	//POSTs
	public static String insertLocationCard(String trelloToken, ProyectoResource p, UbicacionResource u)
	{
		Card c = new Card();
		c.setIdBoard(p.getId());
		c.setIdList(TrelloUtils.getIdListsFromName(trelloToken, p, "location"));
		c.setName(u.getNombre());
		
		Map<String, String> config = new HashMap<String, String>();
		config.put("longitud", new Double(u.getLongitud()).toString());
		config.put("latitud", new Double(u.getLatitud()).toString());
		
		c.setDesc("-->{\n" + UtilsConfig.parserConfig(config) + "}<--\n" + u.getDescripcion());
		
		return TrelloCardsResource.insertCard(c, trelloToken);
	}
	
	
	//PUTs
	public static void updateLocationCard(String trelloToken, ProyectoResource p, UbicacionResource u)
	{
		Card c = new Card();
		c.setIdBoard(p.getId());
		c.setIdList(TrelloUtils.getIdListsFromName(trelloToken, p, "location"));
		c.setName(u.getNombre());
		c.setId(u.getId());
		
		Map<String, String> config = new HashMap<String, String>();
		config.put("longitud", new Double(u.getLongitud()).toString());
		config.put("latitud", new Double(u.getLatitud()).toString());
		
		c.setDesc("-->{\n" + UtilsConfig.parserConfig(config) + "}<--\n" + u.getDescripcion());
		
		TrelloCardsResource.updateCard(c, trelloToken);
	}
	
	
	//DELETEs
	public static void deleteLocationCard(String trelloToken, String locate)
	{
		TrelloCardsResource.deleteCard(trelloToken, locate);
	}
}

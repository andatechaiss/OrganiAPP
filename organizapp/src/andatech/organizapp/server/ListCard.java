package andatech.organizapp.server;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import andatech.organizapp.server.resources.trello.TrelloCardsResource;
import andatech.organizapp.server.utils.TrelloUtils;
import andatech.organizapp.server.utils.UtilsConfig;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.resources.ListaTarjetasResource;
import andatech.organizapp.shared.resources.ProyectoResource;

public class ListCard
{
	public static final String cardsList = "listcard";
	
	
	//GETs
	public static List<ListaTarjetasResource> getAllListCard(String googleToken, String trelloToken, ProyectoResource p)
	{
		String idList = TrelloUtils.getListsFromName(trelloToken, p, Project.listConfigs).getId();
		
		List<ListaTarjetasResource> res = new LinkedList<ListaTarjetasResource>();
		for(Card c : TrelloUtils.getAllCardsFromName(trelloToken, idList, cardsList))
			res.add(TrelloUtils.getListaTarjetasResource(googleToken, trelloToken, p, c));
		
		return res;
	}
	
	
	//POSTs
	public static String insertListCard(String trelloToken, ProyectoResource p, ListaTarjetasResource l)
	{
		String idList = TrelloUtils.getListsFromName(trelloToken, p, Project.listConfigs).getId();
		
		Map<String, String> conf = new HashMap<String, String>();
		conf.put("nombre", l.getNombre());
		conf.put("tipo", l.getTipo());
		conf.put("condicion", l.getCondicion());
		
		Card c = new Card();
		c.setIdBoard(p.getId());
		c.setIdList(idList);
		c.setName(cardsList);
		c.setDesc(UtilsConfig.parserConfig(conf));
		return TrelloCardsResource.insertCard(c, trelloToken);
	}
	
	
	
	//PUTs
	public static void updateListCard(String trelloToken, ProyectoResource p, ListaTarjetasResource l)
	{
		String idList = TrelloUtils.getListsFromName(trelloToken, p, Project.listConfigs).getId();
		
		Map<String, String> conf = new HashMap<String, String>();
		conf.put("nombre", l.getNombre());
		conf.put("tipo", l.getTipo());
		conf.put("condicion", l.getCondicion());
		
		Card c = new Card();
		c.setIdBoard(p.getId());
		c.setIdList(idList);
		c.setName(cardsList);
		c.setDesc(UtilsConfig.parserConfig(conf));
		c.setId(l.getId());
		TrelloCardsResource.updateCard(c, trelloToken);
	}
	
	
	
	//DELETEs
	public static void deleteListCard(String trelloToken, String id)
	{
		TrelloCardsResource.deleteCard(id, trelloToken);
	}
}

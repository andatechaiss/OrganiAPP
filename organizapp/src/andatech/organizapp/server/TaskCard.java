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
import andatech.organizapp.shared.domain.trello.Member;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.TareaResource;

public class TaskCard 
{
	//GETs
	public static List<TareaResource> getAllTaskCard(String trelloToken, String board)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, board, "task");
		
		List<TareaResource> res = new LinkedList<TareaResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
			res.add(TrelloUtils.getTareaFromCard(c));
		
		return res;
	}
	
	public static List<TareaResource> getAllTaskCard(String trelloToken, ProyectoResource p)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, p, "task");
		
		List<TareaResource> res = new LinkedList<TareaResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
			res.add(TrelloUtils.getTareaFromCard(c));
		
		return res;
	}
	
	public static List<TareaResource> getUnassignedTaskCard(String trelloToken, String board)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, board, "task");
		
		List<TareaResource> res = new LinkedList<TareaResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
		{
			String state = UtilsConfig.mapConfigCard(c.getDesc()).get("estado");
			if(state != null && state.equals("unassigned"))
				res.add(TrelloUtils.getTareaFromCard(c));
		}
		
		return res;
	}
	
	public static List<TareaResource> getUnassignedTaskCard(String trelloToken, ProyectoResource p)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, p, "task");
		
		List<TareaResource> res = new LinkedList<TareaResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
		{
			String state = UtilsConfig.mapConfigCard(c.getDesc()).get("estado");
			if(state != null && state.equals("unassigned"))
				res.add(TrelloUtils.getTareaFromCard(c));
		}
		
		return res;
	}
	
	public static List<TareaResource> getStartedTaskCard(String trelloToken, String board)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, board, "task");
		
		List<TareaResource> res = new LinkedList<TareaResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
		{
			String state = UtilsConfig.mapConfigCard(c.getDesc()).get("estado");
			if(state != null && state.equals("started"))
				res.add(TrelloUtils.getTareaFromCard(c));
		}
		
		return res;
	}
	
	public static List<TareaResource> getStartedTaskCard(String trelloToken, ProyectoResource p)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, p, "task");
		
		List<TareaResource> res = new LinkedList<TareaResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
		{
			String state = UtilsConfig.mapConfigCard(c.getDesc()).get("estado");
			if(state != null && state.equals("started"))
				res.add(TrelloUtils.getTareaFromCard(c));
		}
		
		return res;
	}
	
	public static List<TareaResource> getFinishedTaskCard(String trelloToken, String board)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, board, "task");
		
		List<TareaResource> res = new LinkedList<TareaResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
		{
			String state = UtilsConfig.mapConfigCard(c.getDesc()).get("estado");
			if(state != null && state.equals("finished"))
				res.add(TrelloUtils.getTareaFromCard(c));
		}
		
		return res;
	}
	
	public static List<TareaResource> getFinishedTaskCard(String trelloToken, ProyectoResource p)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, p, "task");
		
		List<TareaResource> res = new LinkedList<TareaResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
		{
			String state = UtilsConfig.mapConfigCard(c.getDesc()).get("estado");
			if(state != null && state.equals("finished"))
				res.add(TrelloUtils.getTareaFromCard(c));
		}
		
		return res;
	}
	
	public static List<Member> getMemberTaskCard(String trelloToken, String card)
	{
		return TrelloCardsResource.getMembersCards(card, trelloToken);
	}
	
	
	//POSTs
	public static TareaResource insertTaskCard(String trelloToken, ProyectoResource p, TareaResource task)
	{
		Card c = new Card();
		c.setIdBoard(p.getId());
		c.setIdList(TrelloUtils.getIdListsFromName(trelloToken, p, "task"));
		c.setName(task.getNombre());
		
		Map<String, String> config = new HashMap<String, String>();
		config.put("estado", task.getEstado());
		
		c.setDesc("-->{\n" + UtilsConfig.parserConfig(config) + "}<--\n" + task.getDescripcion());
		
		task.setId(TrelloCardsResource.insertCard(c, trelloToken));
		return task;
	}
	
	
	//PUTs
	public static void updateTaskCard(String trelloToken, ProyectoResource p, TareaResource task)
	{
		Card c = new Card();
		c.setIdBoard(p.getId());
		c.setIdList(TrelloUtils.getIdListsFromName(trelloToken, p, "task"));
		c.setName(task.getNombre());
		c.setDesc(task.getDescripcion());
		
		Map<String, String> config = new HashMap<String, String>();
		config.put("estado", task.getEstado());
		
		c.setDesc("-->{\n" + UtilsConfig.parserConfig(config) + "}<--\n" + task.getDescripcion());
		
		c.setId(task.getId());
		
		TrelloCardsResource.updateCard(c, trelloToken);
	}
	
	public static void insertMemberTaskCard(String trelloToken, String member, String task)
	{
		TrelloCardsResource.asignarMiembro(task, member, trelloToken);
	}
	
	
	//DELETE
	public static void deleteTaskCard(String trelloToken, String task)
	{
		TrelloCardsResource.deleteCard(task, trelloToken);
	}
	
	public static void deleteMemberTaskCard(String trelloToken, String member, String task)
	{
		TrelloCardsResource.desasignaMiembro(task, member, trelloToken);
	}
}

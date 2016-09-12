package andatech.organizapp.server.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import andatech.organizapp.server.Project;
import andatech.organizapp.server.TaskCard;
import andatech.organizapp.server.resources.trello.TrelloBoardsResource;
import andatech.organizapp.server.resources.trello.TrelloCardsResource;
import andatech.organizapp.server.resources.trello.TrelloListsResource;
import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.resources.ListaTarjetasResource;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.TareaResource;
import andatech.organizapp.shared.resources.TarjetasResource;

public class TrelloUtils 
{
	//constantes
	public static final String prefixBoard = "OA-";
	
	
	
	//tableros
	public static List<Boards> getBoardsPoyectos(String token)
	{
		List<Boards> res = new LinkedList<Boards>();
		for(Boards b : TrelloBoardsResource.getAllBoards(token))
			if(b.getName().startsWith(prefixBoard))
				res.add(b);
		
		return res;
	}
	
	public static List<Boards> getClosedPoyectos(String token)
	{
		List<Boards> res = new LinkedList<Boards>();
		for(Boards b : TrelloBoardsResource.getAllBoards(token))
			if(b.getClosed())
				res.add(b);
		
		return res;
	}
	
	public static void clearProyecto(String token, String board)
	{
		for(Lists l : TrelloListsResource.getAllList(board, token))
		{
			l.setClosed(true);
			for(Card c : TrelloCardsResource.getAllCard(l.getId(), token))
				TrelloCardsResource.deleteCard(c.getId(), token);
			TrelloListsResource.updateList(l, token);
		}
	}
	
	
	//Proyectos
	public static ProyectoResource getProyectoFromBoard(Boards b)
	{
		ProyectoResource res = new ProyectoResource();
		res.setId(b.getId());
		res.setNombre(b.getName().replace(prefixBoard, ""));
		res.setDescripcion(b.getDesc());
		return res;
	}
	
	public static Map<String, String> getConfig(ProyectoResource p)
	{
		Map<String, String> res = new HashMap<String, String>();
		res.put("quitar", p.getQuitar());
		
		return res;
	}
	
	public static void setConfigWithCard(String token, String id, Map<String, String> config)
	{
		TrelloCardsResource.updateCard("desc", UtilsConfig.parserConfig(config), id, token);
	}
	
	public static void setConfigWithBoard(String token, String id, Map<String, String> config)
	{
		Lists l = getListsFromName(token, id, Project.listConfigs);
		if(l != null)
		{
			for(Card c : TrelloCardsResource.getAllCard(l.getId(), token))
			{
				if(c.getName().equals(Project.cardConfigs))
				{
					setConfigWithCard(token, c.getId(), config);
					break;
				}
			}
		}
	}
	
	public static void setConfigWithProject(String token, ProyectoResource p)
	{
		Map<String, String> config = getConfig(p);
		if(p.getIdList().getCardConfig() != null)
			setConfigWithCard(token, p.getIdList().getCardConfig(), config);
		else
			setConfigWithBoard(token, p.getId(), config);
	}
	
	
	
	//Listas
	public static String insertList(String token, String board, String name)
	{
		Lists l = null;
		for(Lists _l : TrelloListsResource.getAllList(board, token))
		{
			if(_l.getClosed())
			{
				l = _l;
				break;
			}
		}
		
		if(l == null)
		{
			l = new Lists();
			l.setIdBoard(board);
			l.setName(name);
			return TrelloListsResource.insertList(l, token);
		}
		else
		{
			l.setClosed(false);
			l.setIdBoard(board);
			l.setName(name);
			TrelloListsResource.updateList(l, token);
			
			return l.getId();
		}
	}
	
	public static Lists getListsFromName(String token, ProyectoResource p, String name)
	{
		switch(name)
		{
			case Project.listConfigs:
				if(p.getIdList().getListConfig() != null)
					return TrelloListsResource.getList(p.getIdList().getListConfig(), token);
				
				break;
				
			case "task":
				if(p.getIdList().getListTask() != null)
					return TrelloListsResource.getList(p.getIdList().getListTask(), token);
				
				break;
				
			case "location":
				if(p.getIdList().getListLocation() != null)
					return TrelloListsResource.getList(p.getIdList().getListLocation(), token);
				
				break;
		}
		
		for(Lists _l : TrelloListsResource.getAllList(p.getId(), token))
			if(_l.getName().equals(name))
				return _l;
		
		return null;
	}
	
	public static Lists getListsFromName(String token, String board, String name)
	{
		for(Lists _l : TrelloListsResource.getAllList(board, token))
			if(_l.getName().equals(name))
				return _l;
		
		return null;
	}
	
	public static String getIdListsFromName(String token, ProyectoResource p, String name)
	{
		switch(name)
		{
			case Project.listConfigs:
				if(p.getIdList().getListConfig() != null)
					return p.getIdList().getListConfig();
				
				break;
				
			case "task":
				if(p.getIdList().getListTask() != null)
					return p.getIdList().getListTask();
				
				break;
				
			case "location":
				if(p.getIdList().getListLocation() != null)
					return p.getIdList().getListLocation();
				
				break;
		}
		
		for(Lists _l : TrelloListsResource.getAllList(p.getId(), token))
			if(_l.getName().equals(name))
				return _l.getId();
		
		return null;
	}
	
	
	
	//listas virtuales
	public static ListaTarjetasResource getListaTarjetasResource(String token, ProyectoResource p, Card c)
	{
		Map<String, String> config = UtilsConfig.mapConfig(c.getDesc());
		
		ListaTarjetasResource res = new ListaTarjetasResource();
		res.setId(c.getId());
		res.setNombre(config.get("nombre"));
		res.setTipo(config.get("tipo"));
		res.setCondicion(config.get("condicion"));
		
		if(res.getTipo() == null)
			return null;
		else
		{
			switch(res.getTipo())
			{
				case "task":
					switch(res.getCondicion())
					{
						case "unassigned":
							List<TarjetasResource> temp = new LinkedList<TarjetasResource>();
							for(TareaResource t : TaskCard.getUnassignedTaskCard(token, p))
								temp.add(t);
							res.setTarjetas(temp);
							break;
							
						case "started":
							List<TarjetasResource> temp1 = new LinkedList<TarjetasResource>();
							for(TareaResource t : TaskCard.getStartedTaskCard(token, p))
								temp1.add(t);
							res.setTarjetas(temp1);
							break;

						case "finished":
							List<TarjetasResource> temp2 = new LinkedList<TarjetasResource>();
							for(TareaResource t : TaskCard.getFinishedTaskCard(token, p))
								temp2.add(t);
							res.setTarjetas(temp2);
							break;
					}
					break;
					
				case "location":
					break;//TODO
			}
			
			return res;
		}
	}
	
	
	
	//==================TARJETAS======================
	public static Card getCardsFromName(String token, String idList, String name)
	{
		for(Card _l : TrelloCardsResource.getAllCard(idList, token))
			if(_l.getName().equals(name))
				return _l;
		
		return null;
	}
	
	public static List<Card> getAllCardsFromName(String token, String idList, String name)
	{
		List<Card> res = new LinkedList<Card>();
		for(Card _l : TrelloCardsResource.getAllCard(idList, token))
			if(_l.getName().equals(name))
				res.add(_l);
		
		return res;
	}
	
	
	//tareas
	public static TareaResource getTareaFromCard(Card c)
	{
		TareaResource res = new TareaResource();
		res.setNombre(c.getName());
		res.setDescripcion(UtilsConfig.getDescCard(c.getDesc()));
		
		Map<String, String> conf = UtilsConfig.mapConfigCard(c.getDesc());
		String state = conf.get("estado");
		if(state != null)
			res.setEstado(state);
		else
			res.setEstado("unassigned");
		
		return res;
	}
}

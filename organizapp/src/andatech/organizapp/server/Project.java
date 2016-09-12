package andatech.organizapp.server;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import andatech.organizapp.server.resources.trello.TrelloBoardsResource;
import andatech.organizapp.server.resources.trello.TrelloCardsResource;
import andatech.organizapp.server.utils.TrelloUtils;
import andatech.organizapp.server.utils.UtilsConfig;
import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Email;
import andatech.organizapp.shared.domain.trello.Member;
import andatech.organizapp.shared.domain.trello.Prefs;
import andatech.organizapp.shared.resources.ProyectoResource;

public class Project 
{
	//constantes
	public static final String listConfigs = "Configuracion";
	public static final String cardConfigs = "Proyecto";
	
	
	
	//GETs
	public static List<ProyectoResource> getAllProject(String trelloToken)
	{
		List<ProyectoResource> res = new LinkedList<ProyectoResource>();
		for(Boards b : TrelloUtils.getBoardsPoyectos(trelloToken))
			res.add(TrelloUtils.getProyectoFromBoard(b));
		
		return res;
	}
	
	public static ProyectoResource getProject(String trelloToken, String id)
	{
		return TrelloUtils.getProyectoFromBoard(TrelloBoardsResource.getBoard(id, trelloToken));
	}
	
	public static List<Member> getMemberProject(String trelloToken, String id)
	{
		return TrelloBoardsResource.getMembersBoars(id, trelloToken);
	}
	
	
	
	//POSTs
	public static ProyectoResource createProject(String trelloToken, String name, String desc)	//proyecto nuevo
	{
		return createProject(trelloToken, null, name, desc);
	}
	
	public static ProyectoResource createProject(String trelloToken, String id, String name, String desc)	//proyecto existente
	{
		//board
		Prefs prefs = new Prefs();
		prefs.setVoting("members");
		
		List<String> powerups = new ArrayList<String>();
		powerups.add("voting");
		
		Boards board = new Boards();
		board.setName(TrelloUtils.prefixBoard + name);
		board.setDesc(desc);
		board.setPrefs(prefs);
		board.setPowerUps(powerups);
		board.setId(id);
		board.setClosed(false);
		
		if(id != null)
		{
			//limpiamos el proyecto anterior
			TrelloUtils.clearProyecto(trelloToken, id);
			
			//actualizamos el viejo 
			TrelloBoardsResource.updateBoard(board, trelloToken);
		}
		else
		{
			board.setId(TrelloBoardsResource.insertBoard(board, trelloToken));	// o creamos el nuevo
			
			//limpiamos el proyecto que crea
			TrelloUtils.clearProyecto(trelloToken, board.getId());
		}
		
		
		//añadimos la configuracion extra de trello
		ProyectoResource p = TrelloUtils.getProyectoFromBoard(board);
		
		String idList = TrelloUtils.insertList(trelloToken, board.getId(), listConfigs);
		
		Card c = new Card();
		c.setName(cardConfigs);
		c.setDesc(UtilsConfig.parserConfig(TrelloUtils.getConfig(p)));
		c.setIdBoard(board.getId());
		c.setIdList(idList);
		TrelloCardsResource.insertCard(c, trelloToken);
		
		
		//preparamos para las tarjetas
		p.getIdList().setListTask(TrelloUtils.insertList(trelloToken, board.getId(), "task"));
		p.getIdList().setListLocation(TrelloUtils.insertList(trelloToken, board.getId(), "location"));
		
		return p;
	}
	
	public static void insertMemberProject(String trelloToken, String project, Email m)
	{
		TrelloBoardsResource.insertMember(project, m, trelloToken);
	}
	
	public static void insertMemberProject(String trelloToken, String project, List<Email> lm)
	{
		for(Email m : lm)
			TrelloBoardsResource.insertMember(project, m, trelloToken);
	}
	
	
	
	//PUTs
	public static void updateProject(String trelloToken, ProyectoResource p)
	{
		Prefs prefs = new Prefs();
		prefs.setVoting("members");
		
		List<String> powerups = new ArrayList<String>();
		powerups.add("voting");
		
		Boards board = new Boards();
		board.setName(TrelloUtils.prefixBoard + p.getNombre());
		board.setDesc(p.getDescripcion());
		board.setPrefs(prefs);
		board.setPowerUps(powerups);
		board.setId(p.getId());
		
		TrelloBoardsResource.updateBoard(board, trelloToken);
		TrelloUtils.setConfigWithProject(trelloToken, p);
	}
	
	public static void updateProject(String trelloToken, String id, String field, String value)
	{
		ArrayList<String> cont = new ArrayList<String>();
		cont.ensureCapacity(3);
		cont.add("nombre"); cont.add("descripcion"); cont.add("listaTarjetas");
		
		int index = cont.indexOf(field);
		if(index >= 0)
		{
			switch(index)
			{
				case 0:
					TrelloBoardsResource.updateBoard("name", TrelloUtils.prefixBoard + value, id, trelloToken);
					break;
				case 1:
					TrelloBoardsResource.updateBoard("desc", value, id, trelloToken);
					break;
				default:
					break;
			}
		}
		else
		{
			ProyectoResource p = new ProyectoResource();
			p.setId(id);
			
			Map<String, String> config = TrelloUtils.getConfig(p);
			config.put(field, value);
			
			TrelloUtils.setConfigWithBoard(trelloToken, id, config);
		}
	}
	
	public static void updateProject(String trelloToken, ProyectoResource p, String field, String value)
	{
		ArrayList<String> cont = new ArrayList<String>();
		cont.ensureCapacity(3);
		cont.add("nombre"); cont.add("descripcion"); cont.add("listaTarjetas");
		
		int index = cont.indexOf(field);
		if(index >= 0)
		{
			switch(index)
			{
				case 0:
					TrelloBoardsResource.updateBoard("name", TrelloUtils.prefixBoard + value, p.getId(), trelloToken);
					break;
				case 1:
					TrelloBoardsResource.updateBoard("desc", value, p.getId(), trelloToken);
					break;
				default:
					break;
			}
		}
		else
		{
			Map<String, String> config = TrelloUtils.getConfig(p);
			config.put(field, value);
			
			TrelloUtils.setConfigWithProject(trelloToken, p);
		}
	}
	
	
	
	//DELETE
	public static void deleteProject(String trelloToken, ProyectoResource p)
	{
		deleteProject(trelloToken, p.getId());
	}
	
	public static void deleteProject(String trelloToken, String id)
	{
		TrelloUtils.clearProyecto(trelloToken, id);
		TrelloBoardsResource.updateBoard("closed", true, id, trelloToken);
	}
	
	public static void deleteMemberProject(String trelloToken, String project, String memberId)
	{
		TrelloBoardsResource.deleteMember(project, memberId, trelloToken);
	}
	
}

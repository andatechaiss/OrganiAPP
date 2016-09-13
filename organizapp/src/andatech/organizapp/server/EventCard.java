package andatech.organizapp.server;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import andatech.organizapp.server.resources.calendar.EventResource;
import andatech.organizapp.server.resources.trello.TrelloCardsResource;
import andatech.organizapp.server.utils.TrelloUtils;
import andatech.organizapp.server.utils.UtilsConfig;
import andatech.organizapp.shared.domain.calendar.CalendarEvent;
import andatech.organizapp.shared.domain.calendar.End;
import andatech.organizapp.shared.domain.calendar.Start;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.resources.EventoResource;
import andatech.organizapp.shared.resources.ProyectoResource;

public class EventCard 
{
	//GETs
	public static List<EventoResource> getAllEvents(String googleToken, String trelloToken, ProyectoResource p)
	{
		Lists l = TrelloUtils.getListsFromName(trelloToken, p, "date");
		
		List<EventoResource> res = new LinkedList<EventoResource>();
		for(Card c : TrelloCardsResource.getAllCard(l.getId(), trelloToken))
			res.add(TrelloUtils.getEventoFromCard(googleToken, c, p.getCalendario()));
		
		return res;
	}
	
	public static EventoResource getEvent(String googleToken, String trelloToken, String idEvent, ProyectoResource p)
	{
		return TrelloUtils.getEventoFromCard(googleToken, TrelloCardsResource.getCard(idEvent, trelloToken), p.getCalendario());
	}
	
	
	//POSTs
	public static String insertEvent(String googleToken, String trelloToken, ProyectoResource p, EventoResource e)
	{
		Card c = new Card();
		c.setIdBoard(p.getId());
		c.setIdList(TrelloUtils.getIdListsFromName(trelloToken, p, "date"));
		c.setName(e.getNombre());
		
		//creamos el evento en el calendario
		CalendarEvent event = new CalendarEvent();
		Start start = new Start();
		start.setDate(e.getStartAnio() + "-" + e.getStartMes() + "-" + e.getStartDia());
		event.setStart(start);
		End end = new End();
		end.setDate(e.getEndAnio() + "-" + e.getEndMes() + "-" + e.getEndDia());
		event.setStart(start);
		event.setEnd(end);
		String idEvent = EventResource.addCalendarEvent(googleToken, p.getCalendario(), event);
		
		
		Map<String, String> config = new HashMap<String, String>();
		config.put("idCalendar", idEvent);
		
		c.setDesc("-->{\n" + UtilsConfig.parserConfig(config) + "}<--\n" + e.getDescripcion());
		
		return TrelloCardsResource.insertCard(c, trelloToken);
	}
	
	
	//PUTs
	public static void updateEvent(String googleToken, String trelloToken, ProyectoResource p, EventoResource e)
	{
		Card c = new Card();
		c.setIdBoard(p.getId());
		c.setIdList(TrelloUtils.getIdListsFromName(trelloToken, p, "location"));
		c.setName(e.getNombre());
		c.setId(e.getId());
		
		//creamos el evento en el calendario
		//NO SE PUEDE MODIFICAR EVENTO EN CALENDAR
		
		
		Map<String, String> config = new HashMap<String, String>();
		config.put("idCalendar", e.getIdCalendar());
		
		c.setDesc("-->{\n" + UtilsConfig.parserConfig(config) + "}<--\n" + e.getDescripcion());
		
		TrelloCardsResource.updateCard(c, trelloToken);
	}
	
	
	//DELETEs
	public static void deleteEventCard(String googleToken, String trelloToken, String idCalendar, EventoResource e)
	{
		TrelloCardsResource.deleteCard(e.getId(), trelloToken);
		EventResource.deleteCalendarEvent(googleToken, idCalendar, e.getIdCalendar());
	}
}

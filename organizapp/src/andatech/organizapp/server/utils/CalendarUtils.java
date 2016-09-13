package andatech.organizapp.server.utils;

import andatech.organizapp.server.resources.calendar.CalendarsResource;
import andatech.organizapp.shared.domain.calendar.Calendars;

public class CalendarUtils 
{
	public static String crearCalendario(String token, String idBoard, String idCalendar)
	{
		Calendars c = null;
		if(idCalendar != null)
			c = CalendarsResource.getCalendar(token, idCalendar);
		
		if(c == null)
		{
			c = new Calendars();
			c.setSummary(TrelloUtils.prefixBoard.toLowerCase() + idBoard);
			return CalendarsResource.addCalendar(token, c);
		}
		
		return c.getId();
	}
}

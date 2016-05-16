package andatech.organizapp.client.rpc;

import java.util.Collection;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import andatech.organizapp.shared.domain.calendar.Acl;
import andatech.organizapp.shared.domain.calendar.CalendarEvent;
import andatech.organizapp.shared.domain.calendar.Calendars;

@RemoteServiceRelativePath("client")
public interface CalendarRPC extends RemoteService{
	
	Acl getAcl(String calendarID, String ruleID);
	boolean addAcl(String calendarID, Acl acl);
	boolean updateAcl(String calendarID, Acl acl);
	boolean deleteAcl(String calendarID, String ruleID);
	
	Calendars getCalendar(String calendarID);
	boolean addCalendar(Calendars calendar);
	boolean updateCalendar(Calendars calendar);
	boolean deleteCalendar(String calendarID);
	
	CalendarEvent getEvent(String calendarID, String eventID);
	Collection<CalendarEvent> getAll(String calendarID);
	boolean addCalendarEvent(String calendarID, CalendarEvent event);
	boolean updateCalendarEvent(String calendarID, CalendarEvent event);
	boolean deleteCalendarEvent(String calendarID, String eventID);
}

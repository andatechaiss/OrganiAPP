package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import andatech.organizapp.shared.domain.calendar.Acl;
import andatech.organizapp.shared.domain.calendar.CalendarEvent;
import andatech.organizapp.shared.domain.calendar.Calendars;

@RemoteServiceRelativePath("calendar")
public interface CalendarRPC extends RemoteService{
	
	Acl getAcl(String token, String calendarID, String ruleID);
	String addAcl(String token, String calendarID, Acl acl);
	boolean updateAcl(String token, String calendarID, Acl acl);
	boolean deleteAcl(String token, String calendarID, String ruleID);
	
	Calendars getCalendar(String token, String calendarID);
	List<Calendars> getAll(String token);
	String addCalendar(String token, Calendars calendar);
	boolean updateCalendar(String token, Calendars calendar);
	boolean deleteCalendar(String token, String calendarID);
	
	CalendarEvent getEvent(String token, String calendarID, String eventID);
	List<CalendarEvent> getAll(String token, String calendarID);
	String addCalendarEvent(String token, String calendarID, CalendarEvent event);
	boolean updateCalendarEvent(String token, String calendarID, CalendarEvent event);
	boolean deleteCalendarEvent(String token, String calendarID, String eventID);
}

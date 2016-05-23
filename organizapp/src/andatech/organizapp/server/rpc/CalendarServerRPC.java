package andatech.organizapp.server.rpc;

import java.util.Collection;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import andatech.organizapp.client.rpc.CalendarRPC;
import andatech.organizapp.server.resources.calendar.AclResource;
import andatech.organizapp.server.resources.calendar.CalendarsResource;
import andatech.organizapp.server.resources.calendar.EventResource;
import andatech.organizapp.shared.domain.calendar.Acl;
import andatech.organizapp.shared.domain.calendar.CalendarEvent;
import andatech.organizapp.shared.domain.calendar.Calendars;

@SuppressWarnings("serial")
public class CalendarServerRPC extends RemoteServiceServlet implements CalendarRPC{

	@Override
	public Acl getAcl(String token, String calendarID, String ruleID) {
		
		return AclResource.getAcl(token, calendarID, ruleID);
	}

	@Override
	public boolean addAcl(String token, String calendarID, Acl acl) {
		
		return AclResource.addAcl(token, calendarID, acl);
	}

	@Override
	public boolean updateAcl(String token, String calendarID, Acl acl) {
		
		return AclResource.updateAcl(token, calendarID, acl);
	}

	@Override
	public boolean deleteAcl(String token, String calendarID, String ruleID) {
		
		return AclResource.deleteAcl(token, calendarID, ruleID);
	}

	@Override
	public Calendars getCalendar(String token, String calendarID) {
		
		return CalendarsResource.getCalendar(token, calendarID);
	}

	@Override
	public boolean addCalendar(String token, Calendars calendar) {
		
		return CalendarsResource.addCalendar(token, calendar);
	}

	@Override
	public boolean updateCalendar(String token, Calendars calendar) {
		
		return CalendarsResource.updateCalendar(token, calendar);
	}

	@Override
	public boolean deleteCalendar(String token, String calendarID) {
		
		return CalendarsResource.deleteCalendar(token, calendarID);
	}

	@Override
	public CalendarEvent getEvent(String token, String calendarID, String eventID) {
		
		return EventResource.getEvent(token, calendarID, eventID);
	}

	@Override
	public Collection<CalendarEvent> getAll(String token, String calendarID) {
		
		return EventResource.getAll(token, calendarID);
	}

	@Override
	public boolean addCalendarEvent(String token, String calendarID, CalendarEvent event) {
		
		return EventResource.addCalendarEvent(token, calendarID, event);
	}

	@Override
	public boolean updateCalendarEvent(String token, String calendarID, CalendarEvent event) {
		
		return EventResource.updateCalendarEvent(token, calendarID, event);
	}

	@Override
	public boolean deleteCalendarEvent(String token, String calendarID, String eventID) {
		
		return EventResource.deleteCalendarEvent(token, calendarID, eventID);
	}

	

}

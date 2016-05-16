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
	public Acl getAcl(String calendarID, String ruleID) {
		
		return AclResource.getAcl(calendarID, ruleID);
	}

	@Override
	public boolean addAcl(String calendarID, Acl acl) {
		
		return AclResource.addAcl(calendarID, acl);
	}

	@Override
	public boolean updateAcl(String calendarID, Acl acl) {
		
		return AclResource.updateAcl(calendarID, acl);
	}

	@Override
	public boolean deleteAcl(String calendarID, String ruleID) {
		
		return AclResource.deleteAcl(calendarID, ruleID);
	}

	@Override
	public Calendars getCalendar(String calendarID) {
		
		return CalendarsResource.getCalendar(calendarID);
	}

	@Override
	public boolean addCalendar(Calendars calendar) {
		
		return CalendarsResource.addCalendar(calendar);
	}

	@Override
	public boolean updateCalendar(Calendars calendar) {
		
		return CalendarsResource.updateCalendar(calendar);
	}

	@Override
	public boolean deleteCalendar(String calendarID) {
		
		return CalendarsResource.deleteCalendar(calendarID);
	}

	@Override
	public CalendarEvent getEvent(String calendarID, String eventID) {
		
		return EventResource.getEvent(calendarID, eventID);
	}

	@Override
	public Collection<CalendarEvent> getAll(String calendarID) {
		
		return EventResource.getAll(calendarID);
	}

	@Override
	public boolean addCalendarEvent(String calendarID, CalendarEvent event) {
		
		return EventResource.addCalendarEvent(calendarID, event);
	}

	@Override
	public boolean updateCalendarEvent(String calendarID, CalendarEvent event) {
		
		return EventResource.updateCalendarEvent(calendarID, event);
	}

	@Override
	public boolean deleteCalendarEvent(String calendarID, String eventID) {
		
		return EventResource.deleteCalendarEvent(calendarID, eventID);
	}

	

}

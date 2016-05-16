package andatech.organizapp.client.rpc;

import java.util.Collection;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.shared.domain.calendar.Acl;
import andatech.organizapp.shared.domain.calendar.CalendarEvent;
import andatech.organizapp.shared.domain.calendar.Calendars;

public interface CalendarRPCAsync {

	void getAcl(String calendarID, String ruleID, AsyncCallback<Acl> callback);

	void addAcl(String calendarID, Acl acl, AsyncCallback<Boolean> callback);

	void updateAcl(String calendarID, Acl acl, AsyncCallback<Boolean> callback);

	void deleteAcl(String calendarID, String ruleID, AsyncCallback<Boolean> callback);

	void getCalendar(String calendarID, AsyncCallback<Calendars> callback);

	void addCalendar(Calendars calendar, AsyncCallback<Boolean> callback);

	void updateCalendar(Calendars calendar, AsyncCallback<Boolean> callback);

	void deleteCalendar(String calendarID, AsyncCallback<Boolean> callback);

	void getEvent(String calendarID, String eventID, AsyncCallback<CalendarEvent> callback);

	void getAll(String calendarID, AsyncCallback<Collection<CalendarEvent>> callback);

	void addCalendarEvent(String calendarID, CalendarEvent event, AsyncCallback<Boolean> callback);

	void updateCalendarEvent(String calendarID, CalendarEvent event, AsyncCallback<Boolean> callback);

	void deleteCalendarEvent(String calendarID, String eventID, AsyncCallback<Boolean> callback);

}

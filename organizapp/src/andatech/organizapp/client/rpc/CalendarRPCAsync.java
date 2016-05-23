package andatech.organizapp.client.rpc;

import java.util.Collection;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.shared.domain.calendar.Acl;
import andatech.organizapp.shared.domain.calendar.CalendarEvent;
import andatech.organizapp.shared.domain.calendar.Calendars;

public interface CalendarRPCAsync {

	void getAcl(String token, String calendarID, String ruleID, AsyncCallback<Acl> callback);

	void addAcl(String token, String calendarID, Acl acl, AsyncCallback<Boolean> callback);

	void updateAcl(String token, String calendarID, Acl acl, AsyncCallback<Boolean> callback);

	void deleteAcl(String token, String calendarID, String ruleID, AsyncCallback<Boolean> callback);

	void getCalendar(String token, String calendarID, AsyncCallback<Calendars> callback);

	void addCalendar(String token, Calendars calendar, AsyncCallback<Boolean> callback);

	void updateCalendar(String token, Calendars calendar, AsyncCallback<Boolean> callback);

	void deleteCalendar(String token, String calendarID, AsyncCallback<Boolean> callback);

	void getEvent(String token, String calendarID, String eventID, AsyncCallback<CalendarEvent> callback);

	void getAll(String token, String calendarID, AsyncCallback<Collection<CalendarEvent>> callback);

	void addCalendarEvent(String token, String calendarID, CalendarEvent event, AsyncCallback<Boolean> callback);

	void updateCalendarEvent(String token, String calendarID, CalendarEvent event, AsyncCallback<Boolean> callback);

	void deleteCalendarEvent(String token, String calendarID, String eventID, AsyncCallback<Boolean> callback);

}

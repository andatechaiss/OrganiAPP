package andatech.organizapp.server.resources.calendar;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.domain.calendar.CalendarEvent;

public class EventResource {
	
	private static String uri = "https://www.googleapis.com/calendar/v3/calendars";

	//Devuelve un evento
	public static CalendarEvent getEvent(String calendarID, String eventID){
		
		ClientResource cr = null;
		CalendarEvent evento = null;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/events/" + eventID);
			evento = cr.get(CalendarEvent.class);
		}
		catch (ResourceException re){
			System.err.println("Error al obtener el evento " + eventID + ": " 
					+ cr.getResponse().getStatus());
		}
		
		return evento;
	}
	
	//Devuelve todos los eventos
	public static Collection<CalendarEvent> getAll(String calendarID){
		
		ClientResource cr = null;
		CalendarEvent[] eventos = null;
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/events");
			eventos = cr.get(CalendarEvent[].class);
		}
		catch (ResourceException re){
			System.err.println("Error al obtener los eventos: " 
					+ cr.getResponse().getStatus());
		}
		
		return Arrays.asList(eventos);
	}
	
	//Crea un evento
	public static boolean addCalendarEvent(String calendarID, CalendarEvent event){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/events");
			cr.setEntityBuffering(true);
			cr.post(event);
		} catch (ResourceException re) {
			System.err.println("Error al añadir el evento " + event.getId()
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	//Actualiza un evento
	public static boolean updateCalendarEvent(String calendarID, CalendarEvent event){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/events/" + event.getId());
			cr.setEntityBuffering(true);
			cr.put(event);
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el evento " + event.getId() + ": "
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	//Elimina un evento
	public static boolean deleteCalendarEvent(String calendarID, String eventID){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/events/" + eventID);
			cr.setEntityBuffering(true);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar el evento " + eventID + ": "
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
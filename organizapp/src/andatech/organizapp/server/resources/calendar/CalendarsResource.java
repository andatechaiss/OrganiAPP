package andatech.organizapp.server.resources.calendar;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.domain.calendar.Calendars;

public class CalendarsResource {
	
	private static String uri = "https://www.googleapis.com/calendar/v3/calendars";
	
	//Devuelve un calendario
	public static Calendars getCalendar(String calendarID){
		
		ClientResource cr = null;
		Calendars calendar = null;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID);
			calendar = cr.get(Calendars.class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener el calendario " + calendarID + ": " 
					+ cr.getResponse().getStatus());
		}
		
		return calendar;
	}
	
	//Crea un calendario secundario
	public static boolean addCalendar(Calendars calendar){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.post(calendar);
			
		} catch (ResourceException re) {
			System.err.println("Error al añadir el calendario " + calendar.getId() + ": " 
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	//Actualiza un calendario
	public static boolean updateCalendar(Calendars calendar){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendar.getId());
			cr.setEntityBuffering(true);
			cr.put(calendar);
			
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el calendario " + calendar.getId() + ": " 
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	//Eliminar un calendario secundario
	public static boolean deleteCalendar(String calendarID){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID);
			cr.setEntityBuffering(true);
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error al eliminar el calendario " + calendarID + ": " 
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
}

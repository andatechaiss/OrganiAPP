package andatech.organizapp.server.resources.calendar;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.GoogleCommon;
import andatech.organizapp.shared.domain.calendar.Calendars;

public class CalendarsResource {
	
	private static String uri = "https://www.googleapis.com/calendar/v3/calendars";
	private static String fin = "/?key=" + GoogleCommon.CLIENT_ID + "&access_token=";
	
	//Devuelve un calendario
	public static Calendars getCalendar(String token, String calendarID){
		
		ClientResource cr = null;
		Calendars calendar = null;
		System.err.println(token);
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + fin + token);
			calendar = cr.get(Calendars.class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener el calendario " + calendarID + ": " 
					+ cr.getResponse().getStatus());
		}
		
		return calendar;
	}
	
	//Crea un calendario secundario
	public static boolean addCalendar(String token, Calendars calendar){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + fin + token);
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
	public static boolean updateCalendar(String token, Calendars calendar){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendar.getId() + fin + token);
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
	public static boolean deleteCalendar(String token, String calendarID){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + fin + token);
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

package andatech.organizapp.server.resources.calendar;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.GoogleCommon;
import andatech.organizapp.shared.MapperID;
import andatech.organizapp.shared.domain.calendar.Calendars;

public class CalendarsResource {
	
	private static String uri = "https://www.googleapis.com/calendar/v3";
	private static String fin = "/?key=" + GoogleCommon.CLIENT_ID + "&access_token=";
	//https://www.googleapis.com/calendar/v3/users/me/calendarList

	
	//Devuelve un calendario
	public static Calendars getCalendar(String token, String calendarID){
		
		ClientResource cr = null;
		Calendars calendar = null;
		System.err.println(token);
		
		try{
			cr = new ClientResource(uri + "/calendars/" + calendarID + fin + token);
			calendar = cr.get(Calendars.class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener el calendario " + calendarID + ": " 
					+ cr.getResponse().getStatus());
		}
		
		return calendar;
	}
	
	//Devuelve todos los calendarios
//	public static List<Calendars> getAll(String token){
//		ClientResource cr = null;
//		CalendarList calendarios = null;
//		try{
//			cr = new ClientResource(uri + "/users/me/calendarList" + fin + token);
//			calendarios = cr.get(CalendarList.class);
//		}
//		catch (ResourceException re){
//			System.err.println("Error al obtener los calendarios: " 
//					+ cr.getResponse().getStatus());
//		}
//		
//		System.out.println("kind: " + calendarios.getKind());
//		System.out.println("etag: " + calendarios.getEtag());
//		
//		return calendarios.getItems();
//	}
	
	//Crea un calendario secundario
	public static String addCalendar(String token, Calendars calendar){
		
		return MapperID.getID(uri + "/calendars/" + fin + token, calendar);
	}
	
	//Actualiza un calendario
	public static boolean updateCalendar(String token, Calendars calendar){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/calendars/" + calendar.getId() + fin + token);
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
			cr = new ClientResource(uri + "/calendars/" + calendarID + fin + token);
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

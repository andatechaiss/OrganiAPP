package andatech.organizapp.server.resources.calendar;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.GoogleCommon;
import andatech.organizapp.shared.MapperID;
import andatech.organizapp.shared.domain.calendar.Acl;

public class AclResource {
	
	private static String uri = "https://www.googleapis.com/calendar/v3";
	private static String fin = "/?key=" + GoogleCommon.CLIENT_ID + "&access_token=";
	
	//Obtiene un Acl
	public static Acl getAcl(String token, String calendarID, String ruleID){
		
		ClientResource cr = null;
		Acl acl = null;
		
		try{
			cr = new ClientResource(uri + "/calendars/" + calendarID + "/acl/" + ruleID
					+ fin + token);
			acl = cr.get(Acl.class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener el acl " + ruleID + ": " 
					+ cr.getResponse().getStatus());
		}
		
		return acl;
	}
	
	//Añade un acl
	public static String addAcl(String token, String calendarID, Acl acl){
		
		return MapperID.getID(uri + "/calendars/" + calendarID + "/acl" + fin + token, acl);
	}
	
	//Actualiza un acl
	public static boolean updateAcl(String token, String calendarID, Acl acl){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/calendars/" + calendarID + "/acl/" + acl.getId()
					+ fin + token);
			cr.setEntityBuffering(true);
			cr.put(acl);
			
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el acl " + acl.getId() + ": " 
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;	
	}
	
	//Elimina un acl
	public static boolean deleteAcl(String token, String calendarID, String ruleID){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/calendars/" + calendarID + "/acl/" + ruleID
					+ fin + token);
			cr.setEntityBuffering(true);
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error al eliminar el acl " + ruleID + ": " 
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;	
	}


}

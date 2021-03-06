package andatech.organizapp.server.resources.calendar;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.domain.calendar.Acl;

public class AclResource {
	
	private static String uri = "https://www.googleapis.com/calendar/v3/calendars";
	
	//Obtiene un Acl
	public static Acl getAcl(String calendarID, String ruleID){
		
		ClientResource cr = null;
		Acl acl = null;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/acl/" + ruleID);
			acl = cr.get(Acl.class);
			
		} catch (ResourceException re) {
			System.err.println("Error al obtener el acl " + ruleID + ": " 
					+ cr.getResponse().getStatus());
		}
		
		return acl;
	}
	
	//A�ade un acl
	public static boolean addAcl(String calendarID, Acl acl){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/acl");
			cr.setEntityBuffering(true);
			cr.post(acl);
			
		} catch (ResourceException re) {
			System.err.println("Error al a�adir el acl " + acl.getId() + ": " 
					+ cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	//Actualiza un acl
	public static boolean updateAcl(String calendarID, Acl acl){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/acl/" + acl.getId());
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
	public static boolean deleteAcl(String calendarID, String ruleID){
		
		ClientResource cr = null;
		boolean success = true;
		
		try{
			cr = new ClientResource(uri + "/" + calendarID + "/acl/" + ruleID);
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

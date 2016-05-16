package andatech.organizapp.server.resources.trello;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Organizations;

public class TrelloOrganizationsResource {
	private static String uri = "https://api.trello.com/1/organizations/";

	private static String fin = "?key=[" + Trello.aplicationkey + "]";

	public static Organizations getOrganization(String id) {

		ClientResource cr = null;
		Organizations organizations = null;

		try {
			cr = new ClientResource(uri + id + fin);
			organizations = cr.get(Organizations.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener la Organizacion");
		}
		return organizations;
	}

	public static void updateOrganization(Organizations b, String id) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin);
			cr.put(b);
		} catch (ResourceException re) {
			System.err.println("Error al actualizar la Organizacion");
		}

	}

	public static void InsertOrganization(Organizations b) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + fin);
			cr.post(b);
		} catch (ResourceException re) {
			System.err.println("Error al insertar la Organizacion");
		}

	}

	public static void DeleteOrganization(Organizations b, String id) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar el tablero");
		}

	}

}

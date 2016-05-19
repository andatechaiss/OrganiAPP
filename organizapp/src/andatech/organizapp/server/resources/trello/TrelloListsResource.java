package andatech.organizapp.server.resources.trello;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Lists;

public class TrelloListsResource {

	private static String uri = "https://api.trello.com/1/lists/me/";

	private static String fin = "?key=" + Trello.aplicationkey + "&token=";

	public static Lists getList(String id, String token) {

		ClientResource cr = null;
		Lists list = null;

		try {
			cr = new ClientResource(uri + id + fin + token);
			list = cr.get(Lists.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener la lista");
		}
		return list;
	}

	public static void updateList(Lists l, String id, String token) {

		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin + token);
			cr.put(l);
		} catch (ResourceException re) {
			System.err.println("Error al modificar la lista");
		}
	}

	public static void insertList(Lists l, String token) {

		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + fin + token);
			cr.post(l);
		} catch (ResourceException re) {
			System.err.println("Error al modificar la lista");
		}
	}

}

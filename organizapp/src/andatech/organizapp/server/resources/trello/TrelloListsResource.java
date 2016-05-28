package andatech.organizapp.server.resources.trello;

import java.util.Arrays;
import java.util.List;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.MapperID;
import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Lists;

public class TrelloListsResource {

	private static String uri = "https://api.trello.com/1/lists/";
	private static String uri_board = "https://api.trello.com/1/boards/";
	private static String fin = "?key=" + Trello.aplicationkey + "&token=";
	
	
	public static List<Lists> getAllList(String board, String token) {

		ClientResource cr = null;
		Lists[] list = null;

		try {
			cr = new ClientResource(uri_board + board + "/lists/all" + fin + token);
			list = cr.get(Lists[].class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener la lista");
		}
		return list != null ? Arrays.asList(list) : null;
	}
	
	
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

	public static void updateList(Lists l, String token) {

		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + l.getId() + fin + token);
			cr.put(null);
		} catch (ResourceException re) {
			System.err.println("Error al modificar la lista");
		}
	}

	public static String insertList(Lists l, String token) {
		return MapperID.getID(uri + fin + token, l);
	}

}

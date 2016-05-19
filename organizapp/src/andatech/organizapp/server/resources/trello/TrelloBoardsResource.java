package andatech.organizapp.server.resources.trello;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Boards;

public class TrelloBoardsResource {

	private static String uri = "https://api.trello.com/1/boards/me/";
	private static String uriAll = Trello.member + "boards";
	private static String fin = "?key=" + Trello.aplicationkey + "&token=";

	public static List<Boards> getAllBoards(String token) {

		ClientResource cr = null;
		Boards[] boards = null;

		try {
			cr = new ClientResource(uriAll + fin + token);
			boards = cr.get(Boards[].class);
		} catch (ResourceException re) {
			System.out.println(token);
			System.err.println("Error al obtener los tableros "+re.getStatus());
		}
		if (boards != null) {
			return Arrays.asList(boards);
		} else {
			return null;
		}
	}

	public static Boards getBoard(String id, String token) {

		ClientResource cr = null;
		Boards boards = null;

		try {
			cr = new ClientResource(uri + id + fin + token);
			boards = cr.get(Boards.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener el tablero");
		}
		return boards;
	}

	public static void updateBoard(Boards b, String id, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin + token);
			cr.put(b);
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el tablero");
		}

	}

	public static void InsertBoard(Boards b, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + fin + token);
			cr.post(b);
		} catch (ResourceException re) {
			System.err.println("Error al insertar el tablero");
		}

	}

	public static void DeleteBoard(Boards b, String id, String username, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + username + fin + token);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar el tablero");
		}

	}
}

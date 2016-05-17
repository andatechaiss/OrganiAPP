package andatech.organizapp.server.resources.trello;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Boards;

public class TrelloBoardsResource {

	private static String uri = "https://api.trello.com/1/boards/";

	private static String uriAll = Trello.member + "boards";
	private static String fin = "?key=[" + Trello.aplicationkey + "]";

	public static Collection<Boards> getAllBoards() {

		ClientResource cr = null;
		Boards[] boards = null;

		try {
			cr = new ClientResource(uriAll + fin);
			boards = cr.get(Boards[].class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener los tableros");
		}
		return Arrays.asList(boards);
	}

	public static Boards getBoard(String id) {

		ClientResource cr = null;
		Boards boards = null;

		try {
			cr = new ClientResource(uri + id + fin);
			boards = cr.get(Boards.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener el tablero");
		}
		return boards;
	}

	public static void updateBoard(Boards b, String id) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin);
			cr.put(b);
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el tablero");
		}

	}

	public static void InsertBoard(Boards b) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + fin);
			cr.post(b);
		} catch (ResourceException re) {
			System.err.println("Error al insertar el tablero");
		}

	}

	public static void DeleteBoard(Boards b, String id, String username) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + username + fin);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar el tablero");
		}

	}
}

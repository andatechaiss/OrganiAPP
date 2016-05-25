package andatech.organizapp.server.resources.trello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Label;
import andatech.organizapp.shared.domain.trello.LabelColor;
import andatech.organizapp.shared.domain.trello.TypeMember;
import andatech.organizapp.shared.domain.trello.ValueBoolean;
import andatech.organizapp.shared.domain.trello.ValueString;

public class TrelloBoardsResource {

	private static String uri = "https://api.trello.com/1/boards/";
	private static String uriAll = Trello.member + "boards";
	private static String fin = "?key=" + Trello.aplicationkey + "&token=";

	public static List<Boards> getAllBoards(String token) {

		ClientResource cr = null;
		Boards[] boards = null;

		try {
			cr = new ClientResource(uriAll + fin + token);
			boards = cr.get(Boards[].class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener los tableros: " + re.getStatus());
		}
		if (boards != null) {
			List<Boards> res = new ArrayList<Boards>();
			for(Boards b : Arrays.asList(boards))
				if(!b.getClosed())
					res.add(b);
			
			return res;
		} else {
			return null;
		}
	}

	public static Boards getBoard(String id, String token) {

		ClientResource cr = null;
		Boards boards = null;

		try {
			cr = new ClientResource(uri + id + "/" + fin + token);
			boards = cr.get(Boards.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener el tablero: " + re.getStatus());
		}
		return boards;
	}
	
	public static void updateBoard(Boards b, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + b.getId() + "/" + fin + token);
			cr.put(b);
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el tablero: " + re.getStatus());
		}

	}

	public static void updateBoard(String prop, String value, String id, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + "/" + prop + "/" + fin + token);
			cr.put(new ValueString(value));
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el tablero: " + re.getStatus());
		}

	}
	
	public static void updateBoard(String prop, Boolean value, String id, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + "/" + prop + "/" + fin + token);
			cr.put(new ValueBoolean(value));
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el tablero: " + re.getStatus());
		}

	}

	public static void insertBoard(Boards b, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + fin + token);
			cr.post(b);
		} catch (ResourceException re) {
			System.err.println("Error al insertar el tablero: " + re.getStatus());
		}
	}
	
	public static void insertPowerUps(String board, String power, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + board + "/powerUps/" + fin + token);
			cr.post(new ValueString(power));
		} catch (ResourceException re) {
			System.err.println("Error al insertar el powerUps: " + re.getStatus());
		}
	}
	
	public static void insertLabel(String board, String nombre, LabelColor color, String token) {
		ClientResource cr = null;
		
		Label res = new Label();
		res.setName(nombre);
		res.setColor(color.toString().toLowerCase());

		try {
			cr = new ClientResource(uri + board + "/labels/" + fin + token);
			cr.post(res);
		} catch (ResourceException re) {
			System.err.println("Error al insertar el eqtiqueta: " + re.getStatus());
		}
	}
	
	public static void insertMember(String board, String miembro, TypeMember type, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + board + "/members/" + miembro + "/" + fin + token);
			cr.put(type);
		} catch (ResourceException re) {
			System.err.println("Error al insertar el eqtiqueta: " + re.getStatus());
		}
	}

	public static void deleteMember(String board, String miembro, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + board + "/members/" + miembro + "/" + fin + token);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al insertar el eqtiqueta: " + re.getStatus());
		}
	}
}

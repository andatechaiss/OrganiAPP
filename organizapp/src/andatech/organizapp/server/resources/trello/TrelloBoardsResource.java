package andatech.organizapp.server.resources.trello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.MapperID;
import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Email;
import andatech.organizapp.shared.domain.trello.Label;
import andatech.organizapp.shared.domain.trello.LabelColor;
import andatech.organizapp.shared.domain.trello.Member;
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

	public static List<Label> getAllLabels(String id, String token) {

		ClientResource cr = null;
		Label labels = null;

		try {
			cr = new ClientResource(uri + "labels/" + fin + token);
			labels = cr.get(Label.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener las etiquetas: " + re.getStatus());
		}
		
		if (labels != null) {
			List<Label> res = new ArrayList<Label>();
			for(Label l : Arrays.asList(labels))
					res.add(l);
			
			return res;
		} else {
			return null;
		}
	}
	
	public static List<Member> getMembersBoars(String id, String token) {

		ClientResource cr = null;
		Member[] m = null;

		try {
			cr = new ClientResource(uri + id + "/members/" + fin + token);
			m = cr.get(Member[].class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener las etiquetas: " + re.getStatus());
		}
		
		if (m != null) {
			List<Member> res = new ArrayList<Member>();
			for(Member l : Arrays.asList(m))
					res.add(l);
			
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

	public static String insertBoard(Boards b, String token) {
		return MapperID.getID(uri + fin + token, b);
	}
	
	public static String insertPowerUps(String board, String power, String token) {
		return MapperID.getID(uri + board + "/powerUps/" + fin + token, new ValueString(power));
	}
	
	public static String insertLabel(String board, String nombre, LabelColor color, String token) {
		Label res = new Label();
		res.setName(nombre);
		res.setColor(color.toString().toLowerCase());
		
		return MapperID.getID(uri + board + "/labels/" + fin + token, res);
	}
	
	public static void insertMember(String board, Email miembro, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + board + "/members/" + fin + token);
			cr.put(miembro);
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

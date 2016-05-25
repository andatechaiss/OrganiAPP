package andatech.organizapp.server.resources.trello;

import java.util.Arrays;
import java.util.List;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.ValueBoolean;
import andatech.organizapp.shared.domain.trello.ValueString;

public class TrelloCardsResource {
	private static String uri = "https://api.trello.com/1/cards/";
	private static String uri_list = "https://api.trello.com/1/lists/";
	private static String fin = "?key=" + Trello.aplicationkey + "&token=";
	
	
	public static List<Card> getAllCard(String list, String token) {

		ClientResource cr = null;
		Card[] card = null;

		try {
			cr = new ClientResource(uri_list + list + "/cards/" + fin + token);
			card = cr.get(Card[].class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener la tarjetas: " + re.getStatus());
		}
		return card != null ? Arrays.asList(card) : null;
	}

	public static Card getCard(String id, String token) {

		ClientResource cr = null;
		Card card = null;

		try {
			cr = new ClientResource(uri + id + "/" + fin + token);
			card = cr.get(Card.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener la tarjeta: " + re.getStatus());
		}
		return card;
	}

	public static void updateCard(Card b, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + b.getId() + "/" + fin + token);
			cr.put(b);
		} catch (ResourceException re) {
			System.err.println("Error al actualizar la tarjeta: " + re.getStatus());
		}

	}
	
	public static void updateCard(String prop, String value, String id, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + "/" + prop + "/" + fin + token);
			cr.put(new ValueString(value));
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el tarjeta: " + re.getStatus());
		}

	}
	
	public static void updateCard(String prop, Boolean value, String id, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + "/" + prop + "/" + fin + token);
			cr.put(new ValueBoolean(value));
		} catch (ResourceException re) {
			System.err.println("Error al actualizar el tarjeta: " + re.getStatus());
		}
	}
	

	public static void insertCard(Card b, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + fin + token);
			cr.post(b);
		} catch (ResourceException re) {
			System.err.println("Error al insertar la tarjeta: " + re.getStatus());
			System.err.println(uri + fin + token);
		}
	}
	
	public static void insertEtiqueta(String card, String label, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + card + "/idLabels/" + fin + token);
			cr.post(new ValueString(label));
		} catch (ResourceException re) {
			System.err.println("Error al insertar la tarjeta: " + re.getStatus());
		}
	}
	
	public static void asignarMiembro(String card, String member, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + card + "/idMembers/"  + fin + token);
			cr.post(new ValueString(member));
		} catch (ResourceException re) {
			System.err.println("Error al insertar la tarjeta: " + re.getStatus());
		}
	}
	
	public static void votar(String card, String member, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + card + "/membersVoted/" + fin + token);
			cr.post(new ValueString(member));
		} catch (ResourceException re) {
			System.err.println("Error al insertar la tarjeta: " + re.getStatus());
		}
	}

	public static void deleteCard(String id, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + "/"  + fin + token);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar la tarjeta: " + re.getStatus());
		}
	}
	
	public static void quitarEtiqueta(String card, String label, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + card + "/idLabels/" + label + "/" + fin + token);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar la tarjeta: " + re.getStatus());
		}
	}
	
	public static void desasignaMiembro(String card, String member, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + card + "/idMembers/" + member + "/" + fin + token);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar la tarjeta: " + re.getStatus());
		}
	}
	
	public static void quitarVoto(String card, String member, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + card + "/membersVoted/" + member + "/" + fin + token);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar la tarjeta: " + re.getStatus());
		}
	}

}

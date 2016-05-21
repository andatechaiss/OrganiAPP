package andatech.organizapp.server.resources.trello;

import java.util.Arrays;
import java.util.List;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Card;

public class TrelloCardsResource {
	private static String uri = "https://api.trello.com/1/cards/me/";

	private static String uriAll = Trello.member + "cards";
	private static String fin = "?key=" + Trello.aplicationkey + "&token=";

	public static List<Card> getAllCards(String token) {

		ClientResource cr = null;
		Card[] cards = null;

		try {
			cr = new ClientResource(uriAll + fin + token);
			cards = cr.get(Card[].class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener las tarjetas");
		}
		if (cards != null) {
			return Arrays.asList(cards);
		} else {
			return null;
		}
	}

	public static Card getCard(String id, String token) {

		ClientResource cr = null;
		Card card = null;

		try {
			cr = new ClientResource(uri + id + fin + token);
			card = cr.get(Card.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener la tarjeta");
		}
		return card;
	}

	public static void updateCard(Card b, String id, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin + token);
			cr.put(b);
		} catch (ResourceException re) {
			System.err.println("Error al actualizar la tarjeta");
		}

	}

	public static void InsertCard(Card b, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + fin + token);
			cr.post(b);
		} catch (ResourceException re) {
			System.err.println("Error al insertar la tarjeta");
		}

	}

	public static void DeleteCard(Card b, String id, String token) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin + token);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar la tarjeta");
		}

	}

}

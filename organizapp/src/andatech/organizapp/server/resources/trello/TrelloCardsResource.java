package andatech.organizapp.server.resources.trello;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import andatech.organizapp.shared.Trello;
import andatech.organizapp.shared.domain.trello.Card;

public class TrelloCardsResource {
	private static String uri = "https://api.trello.com/1/cards/";

	private static String uriAll = Trello.member + "cards";
	private static String fin = "?key=[" + Trello.aplicationkey + "]";

	public static Collection<Card> getAllCards() {

		ClientResource cr = null;
		Card[] cards = null;

		try {
			cr = new ClientResource(uriAll + fin);
			cards = cr.get(Card[].class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener las tarjetas");
		}
		return Arrays.asList(cards);
	}

	public static Card getCard(String id) {

		ClientResource cr = null;
		Card card = null;

		try {
			cr = new ClientResource(uri + id + fin);
			card = cr.get(Card.class);
		} catch (ResourceException re) {
			System.err.println("Error al obtener la tarjeta");
		}
		return card;
	}

	public static void updateCard(Card b, String id) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin);
			cr.put(b);
		} catch (ResourceException re) {
			System.err.println("Error al actualizar la tarjeta");
		}

	}

	public static void InsertCard(Card b) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + fin);
			cr.post(b);
		} catch (ResourceException re) {
			System.err.println("Error al insertar la tarjeta");
		}

	}

	public static void DeleteCard(Card b, String id) {
		ClientResource cr = null;

		try {
			cr = new ClientResource(uri + id + fin);
			cr.delete();
		} catch (ResourceException re) {
			System.err.println("Error al eliminar la tarjeta");
		}

	}

}

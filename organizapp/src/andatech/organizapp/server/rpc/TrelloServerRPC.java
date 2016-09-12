package andatech.organizapp.server.rpc;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import andatech.organizapp.client.rpc.TrelloRPC;
import andatech.organizapp.server.resources.trello.TrelloBoardsResource;
import andatech.organizapp.server.resources.trello.TrelloCardsResource;
import andatech.organizapp.server.resources.trello.TrelloListsResource;
import andatech.organizapp.server.resources.trello.TrelloOrganizationsResource;
import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Email;
import andatech.organizapp.shared.domain.trello.LabelColor;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.domain.trello.Organizations;

@SuppressWarnings("serial")
public class TrelloServerRPC extends RemoteServiceServlet implements TrelloRPC {

	@Override
	public List<Boards> getAllBoards(String token) {
		return TrelloBoardsResource.getAllBoards(token);
	}

	@Override
	public Boards getBoard(String id, String token) {
		return TrelloBoardsResource.getBoard(id, token);
	}

	@Override
	public void updateBoard(Boards b, String token) {
		TrelloBoardsResource.updateBoard(b, token);

	}

	@Override
	public void updateBoard(String prop, String value, String id, String token) {
		TrelloBoardsResource.updateBoard(prop, value, id, token);
	}

	@Override
	public void updateBoard(String prop, Boolean value, String id, String token) {
		TrelloBoardsResource.updateBoard(prop, value, id, token);
	}

	@Override
	public String insertBoard(Boards b, String token) {
		return TrelloBoardsResource.insertBoard(b, token);
	}
	

	@Override
	public String insertPowerUps(String board, String power, String token) {
		return TrelloBoardsResource.insertPowerUps(board, power, token);
	}
	
	@Override
	public String insertLabel(String board, String nombre, LabelColor color, String token){
		return TrelloBoardsResource.insertLabel(board, nombre, color, token);
	}
	
	@Override
	public void insertMember(String board, Email miembro, String token){
		TrelloBoardsResource.insertMember(board, miembro, token);
	}

	@Override
	public void deleteMember(String board, String miembro, String token) {
		TrelloBoardsResource.deleteMember(board, miembro, token);
	}
	
	@Override
	public List<Card> getAllCard(String list, String token) {
		return TrelloCardsResource.getAllCard(list, token);
	}

	@Override
	public Card getCard(String id, String token) {
		return TrelloCardsResource.getCard(id, token);
	}

	@Override
	public void updateCard(Card b, String token) {
		TrelloCardsResource.updateCard(b, token);
	}

	@Override
	public void updateCard(String prop, String value, String id, String token) {
		TrelloCardsResource.updateCard(prop, value, id, token);
	}

	@Override
	public void updateCard(String prop, Boolean value, String id, String token) {
		TrelloCardsResource.updateCard(prop, value, id, token);
	}

	@Override
	public String insertCard(Card b, String token) {
		return TrelloCardsResource.insertCard(b, token);
	}

	@Override
	public void asignarMiembro(String card, String member, String token) {
		TrelloCardsResource.asignarMiembro(card, member, token);
	}

	@Override
	public void votar(String card, String member, String token) {
		TrelloCardsResource.votar(card, member, token);
	}

	@Override
	public void insertEtiqueta(String card, String label, String token) {
		TrelloCardsResource.insertEtiqueta(card, label, token);
	}

	@Override
	public void deleteCard(String id, String token) {
		TrelloCardsResource.deleteCard(id, token);
	}

	@Override
	public void quitarEtiqueta(String card, String label, String token) {
		TrelloCardsResource.quitarEtiqueta(card, label, token);
	}

	@Override
	public void desasignaMiembro(String card, String member, String token) {
		TrelloCardsResource.desasignaMiembro(card, member, token);
	}

	@Override
	public void quitarVoto(String card, String member, String token) {
		TrelloCardsResource.quitarVoto(card, member, token);
	}
	
	@Override
	public List<Lists> getAllList(String board, String token) {
		return TrelloListsResource.getAllList(board, token);
	}
	
	@Override
	public Lists getList(String id, String token) {
		return TrelloListsResource.getList(id, token);
	}

	@Override
	public void updateList(Lists l, String token) {
		TrelloListsResource.updateList(l, token);
	}

	@Override
	public String insertList(Lists l, String token) {
		return TrelloListsResource.insertList(l, token);
	}

	@Override
	public Organizations getOrganization(String id, String token) {
		return TrelloOrganizationsResource.getOrganization(id, token);
	}

	@Override
	public void updateOrganization(Organizations b, String id, String token) {
		TrelloOrganizationsResource.updateOrganization(b, id, token);
	}

	@Override
	public void InsertOrganization(Organizations b, String token) {
		TrelloOrganizationsResource.InsertOrganization(b, token);
	}

	@Override
	public void DeleteOrganization(Organizations b, String id, String token) {
		TrelloOrganizationsResource.DeleteOrganization(b, id, token);

	}

}

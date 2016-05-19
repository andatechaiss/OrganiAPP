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
		// TODO Auto-generated method stub
		return TrelloBoardsResource.getBoard(id, token);
	}

	@Override
	public void updateBoard(Boards b, String id, String token) {
		// TODO Auto-generated method stub
		TrelloBoardsResource.updateBoard(b, id, token);

	}

	@Override
	public void InsertBoard(Boards b, String token) {
		// TODO Auto-generated method stub
		TrelloBoardsResource.InsertBoard(b, token);

	}

	@Override
	public void DeleteBoard(Boards b, String id, String username, String token) {
		// TODO Auto-generated method stub
		TrelloBoardsResource.DeleteBoard(b, id, username, token);
	}

	@Override
	public List<Card> getAllCards(String token) {
		// TODO Auto-generated method stub
		return TrelloCardsResource.getAllCards(token);
	}

	@Override
	public Card getCard(String id, String token) {
		// TODO Auto-generated method stub
		return TrelloCardsResource.getCard(id, token);
	}

	@Override
	public void updateCard(Card b, String id, String token) {
		// TODO Auto-generated method stub
		TrelloCardsResource.updateCard(b, id, token);
	}

	@Override
	public void InsertCard(Card b, String token) {
		// TODO Auto-generated method stub
		TrelloCardsResource.InsertCard(b, token);
	}

	@Override
	public void DeleteCard(Card b, String id, String token) {
		// TODO Auto-generated method stub
		TrelloCardsResource.DeleteCard(b, id, token);
	}

	@Override
	public Lists getList(String id, String token) {
		// TODO Auto-generated method stub
		return TrelloListsResource.getList(id, token);
	}

	@Override
	public void updateList(Lists l, String id, String token) {
		// TODO Auto-generated method stub
		TrelloListsResource.updateList(l, id, token);
	}

	@Override
	public void insertList(Lists l, String token) {
		// TODO Auto-generated method stub
		TrelloListsResource.insertList(l, token);
	}

	@Override
	public Organizations getOrganization(String id, String token) {
		// TODO Auto-generated method stub
		return TrelloOrganizationsResource.getOrganization(id, token);
	}

	@Override
	public void updateOrganization(Organizations b, String id, String token) {
		// TODO Auto-generated method stub
		TrelloOrganizationsResource.updateOrganization(b, id, token);
	}

	@Override
	public void InsertOrganization(Organizations b, String token) {
		// TODO Auto-generated method stub
		TrelloOrganizationsResource.InsertOrganization(b, token);
	}

	@Override
	public void DeleteOrganization(Organizations b, String id, String token) {
		// TODO Auto-generated method stub
		TrelloOrganizationsResource.DeleteOrganization(b, id, token);

	}

}

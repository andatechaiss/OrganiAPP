package andatech.organizapp.server.rpc;

import java.util.Collection;

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
	public Collection<Boards> getAllBoards() {
		return TrelloBoardsResource.getAllBoards();
	}

	@Override
	public Boards getBoard(String id) {
		// TODO Auto-generated method stub
		return TrelloBoardsResource.getBoard(id);
	}

	@Override
	public void updateBoard(Boards b, String id) {
		// TODO Auto-generated method stub
		TrelloBoardsResource.updateBoard(b, id);

	}

	@Override
	public void InsertBoard(Boards b) {
		// TODO Auto-generated method stub
		TrelloBoardsResource.InsertBoard(b);

	}

	@Override
	public void DeleteBoard(Boards b, String id, String username) {
		// TODO Auto-generated method stub
		TrelloBoardsResource.DeleteBoard(b, id, username);
	}

	@Override
	public Collection<Card> getAllCards() {
		// TODO Auto-generated method stub
		return TrelloCardsResource.getAllCards();
	}

	@Override
	public Card getCard(String id) {
		// TODO Auto-generated method stub
		return TrelloCardsResource.getCard(id);
	}

	@Override
	public void updateCard(Card b, String id) {
		// TODO Auto-generated method stub
		TrelloCardsResource.updateCard(b, id);
	}

	@Override
	public void InsertCard(Card b) {
		// TODO Auto-generated method stub
		TrelloCardsResource.InsertCard(b);
	}

	@Override
	public void DeleteCard(Card b, String id) {
		// TODO Auto-generated method stub
		TrelloCardsResource.DeleteCard(b, id);
	}

	@Override
	public Lists getList(String id) {
		// TODO Auto-generated method stub
		return TrelloListsResource.getList(id);
	}

	@Override
	public void updateList(Lists l, String id) {
		// TODO Auto-generated method stub
		TrelloListsResource.updateList(l, id);
	}

	@Override
	public void insertList(Lists l) {
		// TODO Auto-generated method stub
		TrelloListsResource.insertList(l);
	}

	@Override
	public Organizations getOrganization(String id) {
		// TODO Auto-generated method stub
		return TrelloOrganizationsResource.getOrganization(id);
	}

	@Override
	public void updateOrganization(Organizations b, String id) {
		// TODO Auto-generated method stub
		TrelloOrganizationsResource.updateOrganization(b, id);
	}

	@Override
	public void InsertOrganization(Organizations b) {
		// TODO Auto-generated method stub
		TrelloOrganizationsResource.InsertOrganization(b);
	}

	@Override
	public void DeleteOrganization(Organizations b, String id) {
		// TODO Auto-generated method stub
		TrelloOrganizationsResource.DeleteOrganization(b, id);

	}

}

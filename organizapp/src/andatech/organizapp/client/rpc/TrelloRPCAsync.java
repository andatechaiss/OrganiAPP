package andatech.organizapp.client.rpc;

import java.util.Collection;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.domain.trello.Organizations;

public interface TrelloRPCAsync {

	void getAllBoards(AsyncCallback<Collection<Boards>> callback);

	void getBoard(String id, AsyncCallback<Boards> callback);

	void updateBoard(Boards b, String id, AsyncCallback<Void> callback);

	void InsertBoard(Boards b, AsyncCallback<Void> callback);

	void DeleteBoard(Boards b, String id, String username, AsyncCallback<Void> callback);

	void getAllCards(AsyncCallback<Collection<Card>> callback);

	void getCard(String id, AsyncCallback<Card> callback);

	void updateCard(Card b, String id, AsyncCallback<Void> callback);

	void InsertCard(Card b, AsyncCallback<Void> callback);

	void DeleteCard(Card b, String id, AsyncCallback<Void> callback);

	void getList(String id, AsyncCallback<Lists> callback);

	void updateList(Lists l, String id, AsyncCallback<Void> callback);

	void insertList(Lists l, AsyncCallback<Void> callback);

	void getOrganization(String id, AsyncCallback<Organizations> callback);

	void updateOrganization(Organizations b, String id, AsyncCallback<Void> callback);

	void InsertOrganization(Organizations b, AsyncCallback<Void> callback);

	void DeleteOrganization(Organizations b, String id, AsyncCallback<Void> callback);

}

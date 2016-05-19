package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.domain.trello.Organizations;

public interface TrelloRPCAsync {

	void getAllBoards(String token, AsyncCallback<List<Boards>> callback);

	void getBoard(String id, String token, AsyncCallback<Boards> callback);

	void updateBoard(Boards b, String id, String token, AsyncCallback<Void> callback);

	void InsertBoard(Boards b, String token, AsyncCallback<Void> callback);

	void DeleteBoard(Boards b, String id, String username, String token, AsyncCallback<Void> callback);

	void getAllCards(String token, AsyncCallback<List<Card>> callback);

	void getCard(String id, String token, AsyncCallback<Card> callback);

	void updateCard(Card b, String id, String token, AsyncCallback<Void> callback);

	void InsertCard(Card b, String token, AsyncCallback<Void> callback);

	void DeleteCard(Card b, String id, String token, AsyncCallback<Void> callback);

	void getList(String id, String token, AsyncCallback<Lists> callback);

	void updateList(Lists l, String id, String token, AsyncCallback<Void> callback);

	void insertList(Lists l, String token, AsyncCallback<Void> callback);

	void getOrganization(String id, String token, AsyncCallback<Organizations> callback);

	void updateOrganization(Organizations b, String id, String token, AsyncCallback<Void> callback);

	void InsertOrganization(Organizations b, String token, AsyncCallback<Void> callback);

	void DeleteOrganization(Organizations b, String id, String token, AsyncCallback<Void> callback);

}

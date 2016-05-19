package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.domain.trello.Organizations;

@RemoteServiceRelativePath("trello")
public interface TrelloRPC extends RemoteService {

	List<Boards> getAllBoards(String token);

	Boards getBoard(String id, String token);

	void updateBoard(Boards b, String id, String token);

	void InsertBoard(Boards b, String token);

	void DeleteBoard(Boards b, String id, String username, String token);

	List<Card> getAllCards(String token);

	Card getCard(String id, String token);

	void updateCard(Card b, String id, String token);

	void InsertCard(Card b, String token);

	void DeleteCard(Card b, String id, String token);

	Lists getList(String id, String token);

	void updateList(Lists l, String id, String token);

	void insertList(Lists l, String token);

	Organizations getOrganization(String id, String token);

	void updateOrganization(Organizations b, String id, String token);

	void InsertOrganization(Organizations b, String token);

	void DeleteOrganization(Organizations b, String id, String token);

}

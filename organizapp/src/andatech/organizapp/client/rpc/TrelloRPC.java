package andatech.organizapp.client.rpc;

import java.util.Collection;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.domain.trello.Organizations;


@RemoteServiceRelativePath("trello")
public interface TrelloRPC extends RemoteService {
	
	Collection<Boards> getAllBoards();
	Boards getBoard(String id);
	void updateBoard(Boards b, String id);
	void InsertBoard(Boards b);
	void DeleteBoard(Boards b, String id, String username);
	
	Collection<Card> getAllCards();
	Card getCard(String id);
	void updateCard(Card b, String id);
	void InsertCard(Card b);
	void DeleteCard(Card b, String id);
	
	Lists getList(String id);
	void updateList(Lists l, String id);
	void insertList(Lists l);
	
	Organizations getOrganization(String id);
	void updateOrganization(Organizations b, String id);
	void InsertOrganization(Organizations b);
	void DeleteOrganization(Organizations b, String id);
	
}

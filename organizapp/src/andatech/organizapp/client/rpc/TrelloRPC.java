package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.LabelColor;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.domain.trello.Organizations;
import andatech.organizapp.shared.domain.trello.TypeMember;

@RemoteServiceRelativePath("trello")
public interface TrelloRPC extends RemoteService {

	List<Boards> getAllBoards(String token);

	Boards getBoard(String id, String token);

	void updateBoard(Boards b, String token);
	
	void updateBoard(String prop, String value, String id, String token);
	
	void updateBoard(String prop, Boolean value, String id, String token);

	String insertBoard(Boards b, String token);
	
	String insertPowerUps(String board, String power, String token);
	
	String insertLabel(String board, String nombre, LabelColor color, String token);
	
	void insertMember(String board, String miembro, TypeMember type, String token);
	
	void deleteMember(String board, String miembro, String token);

	List<Card> getAllCard(String list, String token);
	
	Card getCard(String id, String token);

	void updateCard(Card b, String token);
	
	void updateCard(String prop, String value, String id, String token);
	
	void updateCard(String prop, Boolean value, String id, String token);
	
	String insertCard(Card b, String token);

	void asignarMiembro(String card, String member, String token);
	
	void votar(String card, String member, String token);
	
	void insertEtiqueta(String card, String label, String token);
	
	void deleteCard(String id, String token);
	
	void quitarEtiqueta(String card, String label, String token);
	
	void desasignaMiembro(String card, String member, String token);
	
	void quitarVoto(String card, String member, String token);

	List<Lists> getAllList(String board, String token);
	
	Lists getList(String id, String token);

	void updateList(Lists l, String token);

	String insertList(Lists l, String token);

	Organizations getOrganization(String id, String token);

	void updateOrganization(Organizations b, String id, String token);

	void InsertOrganization(Organizations b, String token);

	void DeleteOrganization(Organizations b, String id, String token);

}

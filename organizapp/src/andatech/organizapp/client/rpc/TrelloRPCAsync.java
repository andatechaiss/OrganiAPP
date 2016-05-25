package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.shared.domain.trello.Boards;
import andatech.organizapp.shared.domain.trello.Card;
import andatech.organizapp.shared.domain.trello.LabelColor;
import andatech.organizapp.shared.domain.trello.Lists;
import andatech.organizapp.shared.domain.trello.Organizations;
import andatech.organizapp.shared.domain.trello.TypeMember;

public interface TrelloRPCAsync {

	void getAllBoards(String token, AsyncCallback<List<Boards>> callback);

	void getBoard(String id, String token, AsyncCallback<Boards> callback);

	void updateBoard(Boards b, String token, AsyncCallback<Void> callback);

	void updateBoard(String prop, String value, String id, String token, AsyncCallback<Void> callback);

	void updateBoard(String prop, Boolean value, String id, String token, AsyncCallback<Void> callback);

	void insertBoard(Boards b, String token, AsyncCallback<Void> callback);

	void getCard(String id, String token, AsyncCallback<Card> callback);

	void updateCard(Card b, String token, AsyncCallback<Void> callback);

	void getList(String id, String token, AsyncCallback<Lists> callback);

	void updateList(Lists l, String token, AsyncCallback<Void> callback);

	void insertList(Lists l, String token, AsyncCallback<Void> callback);

	void getOrganization(String id, String token, AsyncCallback<Organizations> callback);

	void updateOrganization(Organizations b, String id, String token, AsyncCallback<Void> callback);

	void InsertOrganization(Organizations b, String token, AsyncCallback<Void> callback);

	void DeleteOrganization(Organizations b, String id, String token, AsyncCallback<Void> callback);

	void insertCard(Card b, String token, AsyncCallback<Void> callback);

	void updateCard(String prop, String value, String id, String token, AsyncCallback<Void> callback);

	void updateCard(String prop, Boolean value, String id, String token, AsyncCallback<Void> callback);

	void asignarMiembro(String card, String member, String token, AsyncCallback<Void> callback);

	void deleteCard(String id, String token, AsyncCallback<Void> callback);

	void desasignaMiembro(String card, String member, String token, AsyncCallback<Void> callback);

	void insertEtiqueta(String card, String label, String token, AsyncCallback<Void> callback);

	void quitarEtiqueta(String card, String label, String token, AsyncCallback<Void> callback);

	void quitarVoto(String card, String member, String token, AsyncCallback<Void> callback);

	void votar(String card, String member, String token, AsyncCallback<Void> callback);

	void insertLabel(String board, String nombre, LabelColor color, String token, AsyncCallback<Void> callback);

	void insertMember(String board, String miembro, TypeMember type, String token, AsyncCallback<Void> callback);

	void deleteMember(String board, String miembro, String token, AsyncCallback<Void> callback);

	void getAllList(String board, String token, AsyncCallback<List<Lists>> callback);

	void getAllCard(String list, String token, AsyncCallback<List<Card>> callback);

	void insertPowerUps(String board, String power, String token, AsyncCallback<Void> callback);

}

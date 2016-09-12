package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import andatech.organizapp.shared.domain.trello.Email;
import andatech.organizapp.shared.domain.trello.Member;
import andatech.organizapp.shared.resources.ListaTarjetasResource;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.TareaResource;

public interface OrganizappRPCAsync {

	void createProject(String trelloToken, String name, String desc, AsyncCallback<ProyectoResource> callback);

	void createProject(String trelloToken, String id, String name, String desc,
			AsyncCallback<ProyectoResource> callback);

	void deleteProject(String trelloToken, ProyectoResource p, AsyncCallback<Void> callback);

	void deleteProject(String trelloToken, String id, AsyncCallback<Void> callback);

	void getAllProject(String trelloToken, AsyncCallback<List<ProyectoResource>> callback);

	void getProject(String trelloToken, String id, AsyncCallback<ProyectoResource> callback);

	void updateProject(String trelloToken, ProyectoResource p, AsyncCallback<Void> callback);

	void updateProject(String trelloToken, String id, String field, String value, AsyncCallback<Void> callback);

	void updateProject(String trelloToken, ProyectoResource p, String field, String value,
			AsyncCallback<Void> callback);

	void getAllTaskCard(String trelloToken, String board, AsyncCallback<List<TareaResource>> callback);

	void getUnassignedTaskCard(String trelloToken, String board, AsyncCallback<List<TareaResource>> callback);

	void getStartedTaskCard(String trelloToken, String board, AsyncCallback<List<TareaResource>> callback);

	void getFinishedTaskCard(String trelloToken, ProyectoResource p, AsyncCallback<List<TareaResource>> callback);

	void getUnassignedTaskCard(String trelloToken, ProyectoResource p, AsyncCallback<List<TareaResource>> callback);

	void getAllTaskCard(String trelloToken, ProyectoResource p, AsyncCallback<List<TareaResource>> callback);

	void insertTaskCard(String trelloToken, ProyectoResource p, TareaResource task,
			AsyncCallback<TareaResource> callback);

	void getFinishedTaskCard(String trelloToken, String board, AsyncCallback<List<TareaResource>> callback);

	void getStartedTaskCard(String trelloToken, ProyectoResource p, AsyncCallback<List<TareaResource>> callback);

	void updateTaskCard(String trelloToken, ProyectoResource p, TareaResource task, AsyncCallback<Void> callback);

	void deleteTaskCard(String trelloToken, String task, AsyncCallback<Void> callback);

	void insertMemberProject(String trelloToken, String project, Email m, AsyncCallback<Void> callback);

	void insertMemberProject(String trelloToken, String project, List<Email> lm, AsyncCallback<Void> callback);

	void deleteMemberProject(String trelloToken, String project, String memberId, AsyncCallback<Void> callback);

	void getMemberProject(String trelloToken, String id, AsyncCallback<List<Member>> callback);

	void getMemberTaskCard(String trelloToken, String card, AsyncCallback<List<Member>> callback);

	void insertMemberTaskCard(String trelloToken, String member, String task, AsyncCallback<Void> callback);

	void deleteMemberTaskCard(String trelloToken, String member, String task, AsyncCallback<Void> callback);

	void getAllListCard(String trelloToken, ProyectoResource p, AsyncCallback<List<ListaTarjetasResource>> callback);

	void insertListCard(String trelloToken, ProyectoResource p, ListaTarjetasResource l,
			AsyncCallback<String> callback);

	void updateListCard(String trelloToken, ProyectoResource p, ListaTarjetasResource l, AsyncCallback<Void> callback);

	void deleteListCard(String trelloToken, String id, AsyncCallback<Void> callback);

}

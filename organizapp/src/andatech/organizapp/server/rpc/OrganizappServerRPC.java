package andatech.organizapp.server.rpc;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import andatech.organizapp.client.rpc.OrganizappRPC;
import andatech.organizapp.server.ListCard;
import andatech.organizapp.server.Project;
import andatech.organizapp.server.TaskCard;
import andatech.organizapp.shared.domain.trello.Email;
import andatech.organizapp.shared.domain.trello.Member;
import andatech.organizapp.shared.resources.ListaTarjetasResource;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.TareaResource;

@SuppressWarnings("serial")
public class OrganizappServerRPC  extends RemoteServiceServlet implements OrganizappRPC
{

	@Override
	public List<ProyectoResource> getAllProject(String trelloToken) {
		return Project.getAllProject(trelloToken);
	}

	@Override
	public ProyectoResource getProject(String trelloToken, String id) {
		return Project.getProject(trelloToken, id);
	}

	@Override
	public ProyectoResource createProject(String trelloToken, String name, String desc) {
		return Project.createProject(trelloToken, name, desc);
	}

	@Override
	public ProyectoResource createProject(String trelloToken, String id, String name, String desc) {
		return Project.createProject(trelloToken, id, name, desc);
	}

	@Override
	public void updateProject(String trelloToken, ProyectoResource p) {
		Project.updateProject(trelloToken, p);
	}

	@Override
	public void updateProject(String trelloToken, String id, String field, String value) {
		Project.updateProject(trelloToken, id, field, value);
	}

	@Override
	public void deleteProject(String trelloToken, ProyectoResource p) {
		Project.deleteProject(trelloToken, p);
	}

	@Override
	public void deleteProject(String trelloToken, String id) {
		Project.deleteProject(trelloToken, id);
	}

	@Override
	public void updateProject(String trelloToken, ProyectoResource p, String field, String value) {
		Project.updateProject(trelloToken, p, field, value);
	}

	@Override
	public List<TareaResource> getAllTaskCard(String trelloToken, String board) {
		return TaskCard.getAllTaskCard(trelloToken, board);
	}

	@Override
	public List<TareaResource> getAllTaskCard(String trelloToken, ProyectoResource p) {
		return TaskCard.getAllTaskCard(trelloToken, p);
	}

	@Override
	public List<TareaResource> getUnassignedTaskCard(String trelloToken, String board) {
		return TaskCard.getUnassignedTaskCard(trelloToken, board);
	}

	@Override
	public List<TareaResource> getUnassignedTaskCard(String trelloToken, ProyectoResource p) {
		return TaskCard.getUnassignedTaskCard(trelloToken, p);
	}

	@Override
	public List<TareaResource> getStartedTaskCard(String trelloToken, String board) {
		return TaskCard.getStartedTaskCard(trelloToken, board);
	}

	@Override
	public List<TareaResource> getStartedTaskCard(String trelloToken, ProyectoResource p) {
		return TaskCard.getStartedTaskCard(trelloToken, p);
	}

	@Override
	public List<TareaResource> getFinishedTaskCard(String trelloToken, String board) {
		return TaskCard.getFinishedTaskCard(trelloToken, board);
	}

	@Override
	public List<TareaResource> getFinishedTaskCard(String trelloToken, ProyectoResource p) {
		return TaskCard.getFinishedTaskCard(trelloToken, p);
	}

	@Override
	public TareaResource insertTaskCard(String trelloToken, ProyectoResource p, TareaResource task) {
		return TaskCard.insertTaskCard(trelloToken, p, task);
	}

	@Override
	public void updateTaskCard(String trelloToken, ProyectoResource p, TareaResource task) {
		TaskCard.updateTaskCard(trelloToken, p, task);
	}

	@Override
	public void deleteTaskCard(String trelloToken, String task) {
		TaskCard.deleteTaskCard(trelloToken, task);
	}

	@Override
	public void insertMemberProject(String trelloToken, String project, Email m) {
		Project.insertMemberProject(trelloToken, project, m);
	}

	@Override
	public void insertMemberProject(String trelloToken, String project, List<Email> lm) {
		Project.insertMemberProject(trelloToken, project, lm);
	}

	@Override
	public void deleteMemberProject(String trelloToken, String project, String memberId) {
		Project.deleteMemberProject(trelloToken, project, memberId);
	}

	@Override
	public List<Member> getMemberProject(String trelloToken, String id) {
		return Project.getMemberProject(trelloToken, id);
	}

	@Override
	public List<Member> getMemberTaskCard(String trelloToken, String card) {
		return TaskCard.getMemberTaskCard(trelloToken, card);
	}

	@Override
	public void insertMemberTaskCard(String trelloToken, String member, String task) {
		TaskCard.insertMemberTaskCard(trelloToken, member, task);
	}

	public void deleteMemberTaskCard(String trelloToken, String member, String task) {
		TaskCard.deleteMemberTaskCard(trelloToken, member, task);
	}

	@Override
	public List<ListaTarjetasResource> getAllListCard(String trelloToken, ProyectoResource p) {
		return ListCard.getAllListCard(trelloToken, p);
	}

	@Override
	public String insertListCard(String trelloToken, ProyectoResource p, ListaTarjetasResource l) {
		return ListCard.insertListCard(trelloToken, p, l);
	}

	@Override
	public void updateListCard(String trelloToken, ProyectoResource p, ListaTarjetasResource l) {
		ListCard.updateListCard(trelloToken, p, l);
	}

	@Override
	public void deleteListCard(String trelloToken, String id) {
		ListCard.deleteListCard(trelloToken, id);
	}

}

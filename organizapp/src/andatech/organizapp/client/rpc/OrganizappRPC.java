package andatech.organizapp.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import andatech.organizapp.shared.domain.trello.Email;
import andatech.organizapp.shared.domain.trello.Member;
import andatech.organizapp.shared.resources.EventoResource;
import andatech.organizapp.shared.resources.ListaTarjetasResource;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.TareaResource;
import andatech.organizapp.shared.resources.UbicacionResource;

@RemoteServiceRelativePath("oa")
public interface OrganizappRPC extends RemoteService {
	
	//Project
	List<ProyectoResource> getAllProject(String trelloToken);
	ProyectoResource getProject(String trelloToken, String id);
	List<Member> getMemberProject(String trelloToken, String id);
	ProyectoResource createProject(String googleToken, String trelloToken, String name, String desc);
	ProyectoResource createProject(String googleToken, String trelloToken, String id, String name, String desc);
	void insertMemberProject(String trelloToken, String project, Email m);
	void insertMemberProject(String trelloToken, String project, List<Email> lm);
	void updateProject(String trelloToken, ProyectoResource p);
	void updateProject(String trelloToken, String id, String field, String value);
	void updateProject(String trelloToken, ProyectoResource p, String field, String value);
	void deleteProject(String trelloToken, ProyectoResource p);
	void deleteProject(String trelloToken, String id);
	void deleteMemberProject(String trelloToken, String project, String memberId);
	
	
	//ListCard
	List<ListaTarjetasResource> getAllListCard(String googleToken, String trelloToken, ProyectoResource p);
	String insertListCard(String trelloToken, ProyectoResource p, ListaTarjetasResource l);
	void updateListCard(String trelloToken, ProyectoResource p, ListaTarjetasResource l);
	void deleteListCard(String trelloToken, String id);
	
	
	
	//TaskCard
	List<TareaResource> getAllTaskCard(String trelloToken, String board);
	List<TareaResource> getAllTaskCard(String trelloToken, ProyectoResource p);
	List<TareaResource> getUnassignedTaskCard(String trelloToken, String board);
	List<TareaResource> getUnassignedTaskCard(String trelloToken, ProyectoResource p);
	List<TareaResource> getStartedTaskCard(String trelloToken, String board);
	List<TareaResource> getStartedTaskCard(String trelloToken, ProyectoResource p);
	List<TareaResource> getFinishedTaskCard(String trelloToken, String board);
	List<TareaResource> getFinishedTaskCard(String trelloToken, ProyectoResource p);
	List<Member> getMemberTaskCard(String trelloToken, String card);
	TareaResource insertTaskCard(String trelloToken, ProyectoResource p, TareaResource task);
	void updateTaskCard(String trelloToken, ProyectoResource p, TareaResource task);
	void insertMemberTaskCard(String trelloToken, String member, String task);
	void deleteTaskCard(String trelloToken, String task);
	void deleteMemberTaskCard(String trelloToken, String member, String task);
	
	
	
	//LocationCard
	List<UbicacionResource> getAllLocationCard(String trelloToken, ProyectoResource p);
	List<UbicacionResource> getNearLocationCard(String trelloToken, ProyectoResource p, double lat, double lon, double dist);
	String insertLocationCard(String trelloToken, ProyectoResource p, UbicacionResource u);
	void updateLocationCard(String trelloToken, ProyectoResource p, UbicacionResource u);
	void deleteLocationCard(String trelloToken, String locate);
	
	
	
	//EventCard
	List<EventoResource> getAllEvents(String googleToken, String trelloToken, ProyectoResource p);
	EventoResource getEvent(String googleToken, String trelloToken, String idEvent, ProyectoResource p);
	String insertEvent(String googleToken, String trelloToken, ProyectoResource p, EventoResource e);
	void updateEvent(String googleToken, String trelloToken, ProyectoResource p, EventoResource e);
	void deleteEventCard(String googleToken, String trelloToken, String idCalendar, EventoResource e);
	
	
}

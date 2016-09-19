package andatech.organizapp.api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

@Path("/taskCard")
public class TaskCardResource {

	@GET
	@Produces("application/json")
	public List<TareaResource> getAllTaskCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p) {
		List<TareaResource> res = TaskCard.getAllTaskCard(trelloToken, p);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@GET
	@Path("/unassigned")
	@Produces("application/json")
	public List<TareaResource> getUnassignedTaskCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p) {
		List<TareaResource> res = TaskCard.getUnassignedTaskCard(trelloToken, p);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@GET
	@Path("/started")
	@Produces("application/json")
	public List<TareaResource> getStartedTaskCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p) {
		List<TareaResource> res=TaskCard.getStartedTaskCard(trelloToken, p);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@GET
	@Path("/finished")
	@Produces("application/json")
	public List<TareaResource> getFinishedTaskCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p) {
		List<TareaResource> res=TaskCard.getFinishedTaskCard(trelloToken, p);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@GET
	@Path("/member/{card}")
	@Produces("application/json")
	public List<Member> getMemberTaskCard(@QueryParam("trelloToken") String trelloToken, @PathParam("card") String card) {
		List<Member> res=TaskCard.getMemberTaskCard(trelloToken, card);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@POST
	@Consumes("appilcation/json")
	@Produces("application/json")
	public TareaResource insertTaskCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p,
			TareaResource task) {
		if(p==null||task==null){
			throw new BadRequestException("El proyecto o la tarea no puede ser nulo");
		}
		return TaskCard.insertTaskCard(trelloToken, p, task);
	}

	@POST
	@Path("/{member}/{task}")
	@Consumes("appilcation/json")
	@Produces("application/json")
	public void insertMemberTaskCard(@QueryParam("trelloToken") String trelloToken, @PathParam("member") String member,
			@PathParam("task") String task) {
		if(member==null||task==null){
			throw new BadRequestException("El miembro o la tarea no puede ser nulo");
		}
		TaskCard.insertMemberTaskCard(trelloToken, member, task);
	}

	@PUT
	@Consumes("appilcation/json")
	public void updateTaskCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p, TareaResource task) {
		if(p==null||task==null){
			throw new BadRequestException("El proyecto o la tarea no puede ser nulo");
		}
		TaskCard.updateTaskCard(trelloToken, p, task);
	}

	@DELETE
	public void deleteTaskCard(String trelloToken, String task) {
		TaskCard.deleteTaskCard(trelloToken, task);
	}

	@DELETE
	@Path("/{member}/{task}")
	public void deleteMemberTaskCard(@QueryParam("trelloToken") String trelloToken, @PathParam("member") String member,
			@PathParam("task") String task) {
		TaskCard.deleteMemberTaskCard(trelloToken, member, task);
	}
}

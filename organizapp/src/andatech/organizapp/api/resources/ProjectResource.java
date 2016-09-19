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

@Path("/project")
public class ProjectResource {
	
	@GET
	@Produces("application/json")
	public List<ProyectoResource> getAllProject(@QueryParam("trelloToken") String trelloToken) {
		List<ProyectoResource> res=Project.getAllProjects(trelloToken);
			if(res==null){
				throw new NotFoundException("404 not found");
			}
			return res;
		}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public ProyectoResource getProject(@QueryParam("trelloToken") String trelloToken,@PathParam("id") String id) {
		ProyectoResource res =Project.getProject(trelloToken,id);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@GET
	@Path("/{id}/member")
	@Produces("application/json")
	public List<Member> getMemberProject(@QueryParam("trelloToken") String trelloToken,@PathParam("id") String id) {
		List<Member> res=Project.getMemberProject(trelloToken,id);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@POST
	@Consumes("appilcation/json")
	@Produces("application/json")
	public ProyectoResource createProject(@QueryParam("googleToken") String googleToken,@QueryParam("trelloToken") String trelloToken,ProyectoResource p) {
		if(p==null){
			throw new BadRequestException("El proyecto no puede ser nulo");
		}
		if (p.getId()==null){
			return Project.createProject(googleToken,trelloToken,p.getNombre(),p.getDescripcion());
		}else{
			return Project.createProject(googleToken,trelloToken,p.getId(),p.getNombre(),p.getDescripcion());
		}
	}

	@POST
	@Path("/{id}")
	@Consumes("appilcation/json")
	@Produces("application/json")
	public void insertMemberProject(@QueryParam("trelloToken") String trelloToken,@PathParam("id") String project, Email m) {
		if(project==null||m==null){
			throw new BadRequestException("El proyecto o el email no puede ser nulo");
		}
		Project.insertMemberProject(trelloToken,project,m);
	}

	@PUT
	@Consumes("appilcation/json")
	public void updateProject(@QueryParam("trelloToken") String trelloToken, ProyectoResource p) {
		if(p==null){
			throw new BadRequestException("El proyecto no puede ser nulo");
		}
		Project.updateProject(trelloToken,p);
	}

	@DELETE
	@Path("/{id}")
	public void deleteProject(@QueryParam("trelloToken") String trelloToken,@PathParam("id") String id) {
		Project.deleteProject(trelloToken,id);
	}

	@DELETE
	@Path("/{project}/{member}")
	public void deleteMemberProject(String trelloToken, @PathParam("project")String project,@PathParam("member")String memberId) {
		Project.deleteMemberProject(trelloToken,project,memberId);
	}

}

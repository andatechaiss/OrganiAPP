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

import andatech.organizapp.server.ListCard;
import andatech.organizapp.shared.ID;
import andatech.organizapp.shared.resources.ListaTarjetasResource;
import andatech.organizapp.shared.resources.ProyectoResource;
@Path("/listCard")
public class ListCardResource {

	@GET
	@Produces("application/json")
	public List<ListaTarjetasResource> getAllListCard(@QueryParam("googleToken")String googleToken,@QueryParam("trelloToken") String trelloToken, ProyectoResource p) {
		List<ListaTarjetasResource> res =ListCard.getAllListCard(googleToken, trelloToken, p);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@POST
	@Consumes("appilcation/json")
	@Produces("application/json")
	public ID insertListCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p, ListaTarjetasResource l) {
		if(p==null||l==null){
			throw new BadRequestException("El proyecto o la lista no puede ser nulo");
		}
		return new ID(ListCard.insertListCard(trelloToken, p, l));
	}

	@PUT
	@Consumes("appilcation/json")
	public void updateListCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p, ListaTarjetasResource l) {
		if(p==null||l==null){
			throw new BadRequestException("El proyecto o la lista no puede ser nulo");
		}
		ListCard.updateListCard(trelloToken, p, l);
	}

	@DELETE
	@Path("/{id}")
	public void deleteListCard(@QueryParam("trelloToken") String trelloToken,@PathParam("id") String id) {
		ListCard.deleteListCard(trelloToken, id);
	}
}

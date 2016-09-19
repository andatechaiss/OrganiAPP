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

import andatech.organizapp.server.LocationCard;
import andatech.organizapp.shared.ID;
import andatech.organizapp.shared.resources.ProyectoResource;
import andatech.organizapp.shared.resources.UbicacionResource;
@Path("/locationCard")
public class LocationCardResource {
	
	@GET
	@Produces("application/json")
	public List<UbicacionResource> getAllLocationCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p) {
		List<UbicacionResource> res =LocationCard.getAllLocationCard(trelloToken,p);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}


	@POST
	@Consumes("appilcation/json")
	@Produces("application/json")
	public ID insertLocationCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p, UbicacionResource u) {
		if(p==null||u==null){
			throw new BadRequestException("El proyecto o la ubicacion no puede ser nulo");
		}
		return new ID(LocationCard.insertLocationCard(trelloToken,p,u));
	}

	@PUT
	@Consumes("appilcation/json")
	public void updateLocationCard(@QueryParam("trelloToken") String trelloToken, ProyectoResource p, UbicacionResource u) {
		if(p==null||u==null){
			throw new BadRequestException("El proyecto o la ubicacion no puede ser nulo");
		}
		LocationCard.updateLocationCard(trelloToken,p,u);
	}

	@DELETE
	@Path("/{id}")
	public void deleteLocationCard(@QueryParam("trelloToken") String trelloToken,@PathParam("id") String locate) {
		LocationCard.deleteLocationCard(trelloToken,locate);
	}
}

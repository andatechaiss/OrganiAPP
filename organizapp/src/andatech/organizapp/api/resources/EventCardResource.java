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

import andatech.organizapp.server.EventCard;
import andatech.organizapp.shared.ID;
import andatech.organizapp.shared.resources.EventoResource;
import andatech.organizapp.shared.resources.ProyectoResource;
@Path("/eventCard")
public class EventCardResource {

	@GET
	@Produces("application/json")
	public List<EventoResource> getAllEvents(@QueryParam("googleToken") String googleToken, @QueryParam("trelloToken") String trelloToken, ProyectoResource p) {
		List<EventoResource> res=EventCard.getAllEvents(googleToken, trelloToken, p);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public EventoResource getEvent(@QueryParam("googleToken") String googleToken, @QueryParam("trelloToken") String trelloToken,@PathParam("id") String idEvent, ProyectoResource p) {
		EventoResource res=EventCard.getEvent(googleToken, trelloToken, idEvent, p);
		if(res==null){
			throw new NotFoundException("404 not found");
		}
		return res;
	}

	@POST
	@Consumes("appilcation/json")
	@Produces("application/json")
	public ID insertEvent(@QueryParam("googleToken") String googleToken, @QueryParam("trelloToken") String trelloToken, ProyectoResource p, EventoResource e) {
		if(p==null||e==null){
			throw new BadRequestException("El proyecto o el evento no puede ser nulo");
		}
		return new ID(EventCard.insertEvent(googleToken, trelloToken, p, e));
	}

	@PUT
	@Consumes("appilcation/json")
	public void updateEvent(@QueryParam("googleToken") String googleToken, @QueryParam("trelloToken") String trelloToken, ProyectoResource p, EventoResource e) {
		if(p==null||u==null){
			throw new BadRequestException("El proyecto o el evento no puede ser nulo");
		}
		EventCard.updateEvent(googleToken, trelloToken, p, e);
	}

	@DELETE
	@Path("/{id}")
	public void deleteEventCard(@QueryParam("googleToken") String googleToken, @QueryParam("trelloToken") String trelloToken,@PathParam("id") String idCalendar, EventoResource e) {
		EventCard.deleteEventCard(googleToken, trelloToken, idCalendar, e);
	}
}

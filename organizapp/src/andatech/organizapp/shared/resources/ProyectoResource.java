package andatech.organizapp.shared.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ProyectoResource implements Serializable
{
	private String id;
	private String nombre;
	private String descripcion;
	
	private String calendario;

	private List<ListaTarjetasResource> listaTarjetas = new ArrayList<ListaTarjetasResource>();

	private IdList idList = new IdList();

	public ProyectoResource() {}
	public ProyectoResource(String id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	//acceso
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public IdList getIdList() {
		return idList;
	}

	public void setIdList(IdList idList) {
		this.idList = idList;
	}
	
	public String getCalendario() {
		return calendario;
	}

	public void setCalendario(String calendario) {
		this.calendario = calendario;
	}
	
	public List<ListaTarjetasResource> getListaTarjetas() {
		return listaTarjetas;
	}

	public void setListaTarjetas(List<ListaTarjetasResource> listaTarjetas) {
		this.listaTarjetas = listaTarjetas;
	}
	
	
	
}

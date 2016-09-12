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
	
	private String quitar; //TODO quitar este, es solo provisional

	private List<ListaTarjetasResource> listaTarjetas = new ArrayList<ListaTarjetasResource>();
	private IdList idList = new IdList();

	
	
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

	public String getQuitar() {
		return quitar;
	}

	public void setQuitar(String quitar) {
		this.quitar = quitar;
	}
	
	public IdList getIdList() {
		return idList;
	}

	public void setIdList(IdList idList) {
		this.idList = idList;
	}
	

	@Override
	public String toString() {
		return "ProyectoResource [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", quitar="
				+ quitar + "]";
	}
	
	
	
}

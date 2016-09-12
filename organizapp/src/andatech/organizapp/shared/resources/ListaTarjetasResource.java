package andatech.organizapp.shared.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ListaTarjetasResource implements Serializable
{
	private String id;
	private String nombre;
	private String tipo;
	private String condicion;
	
	private List<TarjetasResource> tarjetas = new ArrayList<TarjetasResource>();

	
	
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public List<TarjetasResource> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<TarjetasResource> tarjetas) {
		this.tarjetas = tarjetas;
	}

	
	@Override
	public String toString() {
		return "ListaTarjetasResource [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", condicion=" + condicion
				+ ", tarjetas=" + tarjetas + "]";
	}
	
}

package andatech.organizapp.shared.resources;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class EventoResource implements TarjetasResource, Serializable {
	private String id;
	private String idCalendar;
	private String nombre;
	private String descripcion;
	
	private String startDia;
	private String startMes;
	private String startAnio;
	private String endDia;
	private String endMes;
	private String endAnio;
	
	
	
	
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
	public String getStartDia() {
		return startDia;
	}
	public void setStartDia(String startDia) {
		this.startDia = startDia;
	}
	public String getStartMes() {
		return startMes;
	}
	public void setStartMes(String startMes) {
		this.startMes = startMes;
	}
	public String getStartAnio() {
		return startAnio;
	}
	public void setStartAnio(String startAnio) {
		this.startAnio = startAnio;
	}
	public String getEndDia() {
		return endDia;
	}
	public void setEndDia(String endDia) {
		this.endDia = endDia;
	}
	public String getEndMes() {
		return endMes;
	}
	public void setEndMes(String endMes) {
		this.endMes = endMes;
	}
	public String getEndAnio() {
		return endAnio;
	}
	public void setEndAnio(String endAnio) {
		this.endAnio = endAnio;
	}
	public String getIdCalendar() {
		return idCalendar;
	}
	public void setIdCalendar(String idCalendar) {
		this.idCalendar = idCalendar;
	}
	@Override
	public String getTipo() {
		return "date";
	}
	
	
	
}

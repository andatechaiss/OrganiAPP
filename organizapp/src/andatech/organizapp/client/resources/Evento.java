package andatech.organizapp.client.resources;

public class Evento 
{
	private Boolean terminacion;
	private Fecha inicio;
	private Fecha fin;
	private String nombre; //TODO summary en calendar
	private String descripcion; //TODO description en calendar
	
	
	//private mapa //TODO mapa
	
	
	//getters y setters
	public Boolean isTerminacion() {
		return terminacion == null ? false : terminacion;
	}
	public void setTerminacion(Boolean terminacion) {
		this.terminacion = terminacion;
	}
	public Fecha getInicio() {
		return inicio;
	}
	public void setInicio(Fecha inicio) {
		this.inicio = inicio;
	}
	public Fecha getFin() {
		return fin;
	}
	public void setFin(Fecha fin) {
		this.fin = fin;
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
}

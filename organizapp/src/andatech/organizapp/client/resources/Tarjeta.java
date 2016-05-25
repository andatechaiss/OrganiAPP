package andatech.organizapp.client.resources;

public abstract class Tarjeta 
{
	//propiedades
	private String nombre;
	private String descripcion;
	private String trelloIdCard;
	
	
	public Tarjeta()
	{
		nombre = "";
		trelloIdCard = "";
	}
	
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTrelloIdCard() {
		return trelloIdCard;
	}
	public void setTrelloIdCard(String trelloIdCard) {
		this.trelloIdCard = trelloIdCard;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	//interfaz
	public abstract CardType getType();
	
}

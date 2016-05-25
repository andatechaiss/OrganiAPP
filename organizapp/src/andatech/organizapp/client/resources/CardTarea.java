package andatech.organizapp.client.resources;

public class CardTarea extends Tarjeta
{
	//propiedades
	private Boolean repetible;
	private Integer diaRepetible;
	private Boolean terminable;
	//private fecha de terminacion;
	private Integer minMimbros;
	private Integer maxMiembros;
	
	
	//interfaz
	public CardType getType() {
		return CardType.TAREA;
	}

}

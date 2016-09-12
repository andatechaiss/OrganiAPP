package andatech.organizapp.client.resources;

public class Fecha 
{
	private int dia;
	private int mes;
	private int anio;
	
	
	public Fecha()
	{
		dia = 0;
		mes = 0;
		anio = 0;
	}


	
	//getters y setters
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}
	
	public void setAnio(int anio) {
		this.anio = anio;
	}
}

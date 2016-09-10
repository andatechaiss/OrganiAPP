package andatech.organizapp.client.resources;

public class Fecha 
{
	private int dia;
	private int mes;
	private int año;
	
	
	public Fecha()
	{
		dia = 0;
		mes = 0;
		año = 0;
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

	public int getAño() {
		return año;
	}
	
	public void setAño(int año) {
		this.año = año;
	}
}

package andatech.organizapp.client.resources;

public class Lista 
{
	//propiedades
	private Rol rol;
	private String nombre;
	
	private String idListTrello;
	
	private Proyecto proyecto;
	
	
	


	//constructor
	public Lista()
	{
		rol = null;
		nombre = "";
		idListTrello = "";
	}
	
	
	// getters/setters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getIdListTrello() {
		return idListTrello;
	}
	
	public void setIdListTrello(String idListTrello) {
		this.idListTrello = idListTrello;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}
	
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}


	//config
	public void setConfig()
	{
		
	}


	//consultores
	void setRol(RolType type)
	{
		switch(type)
		{
			case ASIGNACION:
				rol = new RolAsignacion();
				break;
				
			case ASISTENCIA:
				rol = new RolAsistencia();
				break;
				
			case LIFE_CICLE:
				rol = new RolCicloVida();
				break;
				
			case TIPO:
				rol = new RolTipo();
				break;
				
			case VOTACION:
				rol = new RolVotacion();
				break;
				
			default:
				break;
		}
	}
	
	void setRolProp(String prop, String value) {
		rol.setProp(prop, value);
	}
	
	String getRolProp(String prop) {
		return rol.getProp(prop);
	}
	
	
	
	/*****************ROL****************/
	public enum RolType
	{
		ASIGNACION,
		TIPO,
		LIFE_CICLE,
		VOTACION,
		ASISTENCIA
	}
	
	private interface Rol
	{
		String getProp(String prop);
		void setProp(String prop, String value);
		RolType getType();
	}
	
	private class RolAsignacion implements Rol
	{
		private Boolean asignada;
		public RolAsignacion() {
			asignada = false;
		}
		

		public String getProp(String prop) {
			return prop.equals("asignada") ? asignada.toString() : null;
		}

		public void setProp(String prop, String value) {
			if(prop.equals("asignada"))
				asignada = new Boolean(value);
		}

		public RolType getType() {
			return RolType.ASIGNACION;
		}
	}
	
	private class RolTipo implements Rol
	{
		//TODO en lista
		
		public String getProp(String prop) {
			return null;
		}

		public void setProp(String prop, String value) {
			
		}

		public RolType getType() {
			return RolType.TIPO;
		}
	}
	
	private class RolCicloVida implements Rol
	{
		//TODO en lista
		public String getProp(String prop) {
			return null;
		}

		public void setProp(String prop, String value) {
			
		}

		public RolType getType() {
			return RolType.LIFE_CICLE;
		}
	}
	
	private class RolVotacion implements Rol
	{
		private String nombreVotacion;
		public RolVotacion() {
			nombreVotacion = "";
		}
		

		public String getProp(String prop) {
			return prop.equals("nombre") ? nombreVotacion : null;
		}

		public void setProp(String prop, String value) {
			if(prop.equals("nombre"))
				nombreVotacion = value;
		}

		public RolType getType() {
			return RolType.VOTACION;
		}
	}
	
	private class RolAsistencia implements Rol
	{
		//TODO en lista
		public String getProp(String prop) {
			return null;
		}

		public void setProp(String prop, String value) {
			
		}

		public RolType getType() {
			return RolType.ASISTENCIA;
		}
	}
}

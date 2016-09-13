package andatech.organizapp.client;

import java.util.List;

import andatech.organizapp.shared.domain.trello.Member;
import andatech.organizapp.shared.resources.ProyectoResource;

public class Client 
{
	private static Client instance;
	
	private ProyectoResource proyecto;
	private List<Member> listaMiembros;
	
	
	public static Client get()
	{
		if(instance == null)
			instance = new Client();
		
		return instance;
	}
	
	public void sincronizar()
	{
		//TODO
	}
}

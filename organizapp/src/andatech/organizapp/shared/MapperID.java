package andatech.organizapp.shared;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class MapperID 
{
	public static String getID(String url, Object obj)
	{
		ObjectMapper mp = new ObjectMapper();
		ID res = null;
		String json = null;
		ClientResource cr = null;
		
		try {
			cr = new ClientResource(url);
			json = cr.post(obj).getText();
			res = mp.readValue(json, ID.class);
		} catch (ResourceException re) {
			System.err.println("Error al insertar: " + re.getStatus());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		return res == null ? null : res.getId();
	}
}

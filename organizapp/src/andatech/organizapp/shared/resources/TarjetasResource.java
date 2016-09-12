package andatech.organizapp.shared.resources;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public interface TarjetasResource extends Serializable
{
	String getId();
	void setId(String id);
	
	String getTipo();
}

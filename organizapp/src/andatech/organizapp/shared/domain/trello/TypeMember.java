package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class TypeMember implements Serializable
{
	private static final long serialVersionUID = -8132430310078351758L;
	private String type;
	
	
	public TypeMember()
	{
	}
	
	public TypeMember(Permiso permiso)
	{
		setType(permiso);
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(Permiso type) {
		this.type = type.toString().toLowerCase();
	}
	
	public static enum Permiso
	{
		ADMIN,
		NORMAL,
		OBSERVER
	}
}

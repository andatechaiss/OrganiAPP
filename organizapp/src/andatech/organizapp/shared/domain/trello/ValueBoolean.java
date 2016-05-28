package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ValueBoolean implements Serializable
{
	private static final long serialVersionUID = -5624769682754004858L;
	private Boolean value;
	
	
	public ValueBoolean()
	{
		
	}
	
	
	public ValueBoolean(Boolean value) {
		super();
		this.value = value;
	}


	public Boolean getValue() {
		return value;
	}


	public void setValue(Boolean value) {
		this.value = value;
	}
}

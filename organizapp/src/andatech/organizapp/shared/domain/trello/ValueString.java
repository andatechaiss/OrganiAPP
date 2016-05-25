package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

public class ValueString implements Serializable
{
	private static final long serialVersionUID = -5624769682754004858L;
	private String value;
	
	
	public ValueString()
	{
		
	}
	
	
	public ValueString(String value) {
		super();
		this.value = value;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
}

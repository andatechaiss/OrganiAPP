package andatech.organizapp.shared.resources;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class IdList implements Serializable
{
	private String listConfig;
	private String cardConfig;
	
	private String listTask;
	private String listLocation;
	private String listDate;
	
	
	public String getListConfig() {
		return listConfig;
	}
	public void setListConfig(String listConfig) {
		this.listConfig = listConfig;
	}
	public String getCardConfig() {
		return cardConfig;
	}
	public void setCardConfig(String cardConfig) {
		this.cardConfig = cardConfig;
	}
	public String getListTask() {
		return listTask;
	}
	public void setListTask(String listTask) {
		this.listTask = listTask;
	}
	public String getListLocation() {
		return listLocation;
	}
	public void setListLocation(String listLocation) {
		this.listLocation = listLocation;
	}
	public String getListDate() {
		return listDate;
	}
	public void setListDate(String listDate) {
		this.listDate = listDate;
	}
}

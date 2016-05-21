package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Webhook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8022369089542826216L;
	/**
		 * 
		 */
	private Integer readyState;
	private String responseText;
	private Integer status;
	private String statusText;

	public Webhook() {

	}

	/**
	 * 
	 * @return The readyState
	 */
	public Integer getReadyState() {
		return readyState;
	}

	/**
	 * 
	 * @param readyState
	 *            The readyState
	 */
	public void setReadyState(Integer readyState) {
		this.readyState = readyState;
	}

	/**
	 * 
	 * @return The responseText
	 */
	public String getResponseText() {
		return responseText;
	}

	/**
	 * 
	 * @param responseText
	 *            The responseText
	 */
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	/**
	 * 
	 * @return The status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The statusText
	 */
	public String getStatusText() {
		return statusText;
	}

	/**
	 * 
	 * @param statusText
	 *            The statusText
	 */
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

}
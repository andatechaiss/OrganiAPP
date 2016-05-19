package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lists implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2557501143913478417L;
	/**
		 * 
		 */
	private String id;
	private String name;
	private Boolean closed;
	private String idBoard;
	private Double pos;
	private Boolean subscribed;
	//private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Lists() {

	}

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The closed
	 */
	public Boolean getClosed() {
		return closed;
	}

	/**
	 * 
	 * @param closed
	 *            The closed
	 */
	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	/**
	 * 
	 * @return The idBoard
	 */
	public String getIdBoard() {
		return idBoard;
	}

	/**
	 * 
	 * @param idBoard
	 *            The idBoard
	 */
	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}

	/**
	 * 
	 * @return The pos
	 */
	public Double getPos() {
		return pos;
	}

	/**
	 * 
	 * @param pos
	 *            The pos
	 */
	public void setPos(Double pos) {
		this.pos = pos;
	}

	/**
	 * 
	 * @return The subscribed
	 */
	public Boolean getSubscribed() {
		return subscribed;
	}

	/**
	 * 
	 * @param subscribed
	 *            The subscribed
	 */
	public void setSubscribed(Boolean subscribed) {
		this.subscribed = subscribed;
	}

//	public Map<String, Object> getAdditionalProperties() {
//		return this.additionalProperties;
//	}
//
//	public void setAdditionalProperty(String name, Object value) {
//		this.additionalProperties.put(name, value);
//	}

}
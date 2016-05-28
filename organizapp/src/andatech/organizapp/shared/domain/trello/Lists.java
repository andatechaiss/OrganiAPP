package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
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


}
package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5121086032468929704L;
	/**
		 * 
		 */
	private String id;
	private String name;
	private String idList;

	public Card() {

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
	 * @return The idList
	 */
	public String getIdList() {
		return idList;
	}

	/**
	 * 
	 * @param idList
	 *            The idList
	 */
	public void setIdList(String idList) {
		this.idList = idList;
	}

}
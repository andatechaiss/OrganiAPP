package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Membership implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2094405567743538722L;
	/**
		 * 
		 */
	private String id;
	private String idMember;
	private String memberType;
	private Boolean unconfirmed;
	private Boolean deactivated;

	public Membership() {

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
	 * @return The idMember
	 */
	public String getIdMember() {
		return idMember;
	}

	/**
	 * 
	 * @param idMember
	 *            The idMember
	 */
	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}

	/**
	 * 
	 * @return The memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * 
	 * @param memberType
	 *            The memberType
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * 
	 * @return The unconfirmed
	 */
	public Boolean getUnconfirmed() {
		return unconfirmed;
	}

	/**
	 * 
	 * @param unconfirmed
	 *            The unconfirmed
	 */
	public void setUnconfirmed(Boolean unconfirmed) {
		this.unconfirmed = unconfirmed;
	}

	/**
	 * 
	 * @return The deactivated
	 */
	public Boolean getDeactivated() {
		return deactivated;
	}

	/**
	 * 
	 * @param deactivated
	 *            The deactivated
	 */
	public void setDeactivated(Boolean deactivated) {
		this.deactivated = deactivated;
	}

}
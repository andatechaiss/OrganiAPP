package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Boards implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3110456930126728153L;
	/**
	 * /**
	 * 
	 */

	private String name;
	private String desc;
	private Boolean closed;
	private List<String> powerUps = new ArrayList<String>();
	private String dateLastActivity;
	private String id;
	private Prefs prefs;
	private List<Membership> memberships = new ArrayList<Membership>();
	private Boolean subscribed;
	private String dateLastView;

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
	 * @return The desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 
	 * @param desc
	 *            The desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 
	 * @return The powerUps
	 */
	 public List<String> getPowerUps() {
	 return powerUps;
	 }
	
	 /**
	 *
	 * @param powerUps
	 * The powerUps
	 */
	 public void setPowerUps(List<String> powerUps) {
	 this.powerUps = powerUps;
	 }

	/**
	 * 
	 * @return The dateLastActivity
	 */
	public String getDateLastActivity() {
		return dateLastActivity;
	}

	/**
	 * 
	 * @param dateLastActivity
	 *            The dateLastActivity
	 */
	public void setDateLastActivity(String dateLastActivity) {
		this.dateLastActivity = dateLastActivity;
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
	 * @return The prefs
	 */
	public Prefs getPrefs() {
		return prefs;
	}

	/**
	 * 
	 * @param prefs
	 *            The prefs
	 */
	public void setPrefs(Prefs prefs) {
		this.prefs = prefs;
	}

	/**
	 * 
	 * @return The memberships
	 */
	public List<Membership> getMemberships() {
		return memberships;
	}

	/**
	 * 
	 * @param memberships
	 *            The memberships
	 */
	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
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

	/**
	 * 
	 * @return The dateLastView
	 */
	public String getDateLastView() {
		return dateLastView;
	}

	/**
	 * 
	 * @param dateLastView
	 *            The dateLastView
	 */
	public void setDateLastView(String dateLastView) {
		this.dateLastView = dateLastView;
	}
	
	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}



}
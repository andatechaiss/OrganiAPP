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
	private String descData;
	private Boolean closed;
	private String idOrganization;
	private String pinned;
	private String invitations;
	private String shortLink;
	private List<String> powerUps = new ArrayList<String>();
	private String dateLastActivity;
	private List<String> idTags = new ArrayList<String>();
	private String id;
	private Boolean invited;
	private Boolean starred;
	private String url;
	private Prefs prefs;
	private List<Membership> memberships = new ArrayList<Membership>();
	private Boolean subscribed;
	private LabelNames labelNames;
	private String dateLastView;
	private String shortUrl;

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
	 * @return The descData
	 */
	 public String getDescData() {
	 return descData;
	 }
	
	 /**
	 *
	 * @param descData
	 * The descData
	 */
	 public void setDescData(String descData) {
	 this.descData = descData;
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
	 * @return The idOrganization
	 */
	 public String getIdOrganization() {
	 return idOrganization;
	 }
	
	 /**
	 *
	 * @param idOrganization
	 * The idOrganization
	 */
	 public void setIdOrganization(String idOrganization) {
	 this.idOrganization = idOrganization;
	 }
	
	 /**
	 *
	 * @return The pinned
	 */
	 public String getPinned() {
	 return pinned;
	 }
	
	 /**
	 *
	 * @param pinned
	 * The pinned
	 */
	 public void setPinned(String pinned) {
	 this.pinned = pinned;
	 }
	
	 /**
	 *
	 * @return The invitations
	 */
	 public String getInvitations() {
	 return invitations;
	 }
	
	 /**
	 *
	 * @param invitations
	 * The invitations
	 */
	 public void setInvitations(String invitations) {
	 this.invitations = invitations;
	 }
	
	 /**
	 *
	 * @return The shortLink
	 */
	public String getShortLink() {
		return shortLink;
	}

	/**
	 * 
	 * @param shortLink
	 *            The shortLink
	 */
	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
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
	 * @return The idTags //
	 */
	 public List<String> getIdTags() {
	 return idTags;
	 }
	
	 /**
	 *
	 * @param idTags
	 * The idTags
	 */
	 public void setIdTags(List<String> idTags) {
	 this.idTags = idTags;
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
	 * @return The invited
	 */
	public Boolean getInvited() {
		return invited;
	}

	/**
	 * 
	 * @param invited
	 *            The invited
	 */
	public void setInvited(Boolean invited) {
		this.invited = invited;
	}

	/**
	 * 
	 * @return The starred
	 */
	public Boolean getStarred() {
		return starred;
	}

	/**
	 * 
	 * @param starred
	 *            The starred
	 */
	public void setStarred(Boolean starred) {
		this.starred = starred;
	}

	/**
	 * 
	 * @return The url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @param url
	 *            The url
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return The labelNames
	 */
	public LabelNames getLabelNames() {
		return labelNames;
	}

	/**
	 * 
	 * @param labelNames
	 *            The labelNames
	 */
	public void setLabelNames(LabelNames labelNames) {
		this.labelNames = labelNames;
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

	/**
	 * 
	 * @return The shortUrl
	 */
	public String getShortUrl() {
		return shortUrl;
	}

	/**
	 * 
	 * @param shortUrl
	 *            The shortUrl
	 */
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

}
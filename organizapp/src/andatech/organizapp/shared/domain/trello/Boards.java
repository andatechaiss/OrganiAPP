package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@SuppressWarnings("serial")
@Generated("org.jsonschema2pojo")
public class Boards implements Serializable{

private String name;
private String desc;
private Object descData;
private Boolean closed;
private Object idOrganization;
private Object pinned;
private Object invitations;
private String shortLink;
private List<Object> powerUps = new ArrayList<Object>();
private String dateLastActivity;
private List<Object> idTags = new ArrayList<Object>();
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
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The name
*/
public String getName() {
return name;
}

/**
* 
* @param name
* The name
*/
public void setName(String name) {
this.name = name;
}

/**
* 
* @return
* The desc
*/
public String getDesc() {
return desc;
}

/**
* 
* @param desc
* The desc
*/
public void setDesc(String desc) {
this.desc = desc;
}

/**
* 
* @return
* The descData
*/
public Object getDescData() {
return descData;
}

/**
* 
* @param descData
* The descData
*/
public void setDescData(Object descData) {
this.descData = descData;
}

/**
* 
* @return
* The closed
*/
public Boolean getClosed() {
return closed;
}

/**
* 
* @param closed
* The closed
*/
public void setClosed(Boolean closed) {
this.closed = closed;
}

/**
* 
* @return
* The idOrganization
*/
public Object getIdOrganization() {
return idOrganization;
}

/**
* 
* @param idOrganization
* The idOrganization
*/
public void setIdOrganization(Object idOrganization) {
this.idOrganization = idOrganization;
}

/**
* 
* @return
* The pinned
*/
public Object getPinned() {
return pinned;
}

/**
* 
* @param pinned
* The pinned
*/
public void setPinned(Object pinned) {
this.pinned = pinned;
}

/**
* 
* @return
* The invitations
*/
public Object getInvitations() {
return invitations;
}

/**
* 
* @param invitations
* The invitations
*/
public void setInvitations(Object invitations) {
this.invitations = invitations;
}

/**
* 
* @return
* The shortLink
*/
public String getShortLink() {
return shortLink;
}

/**
* 
* @param shortLink
* The shortLink
*/
public void setShortLink(String shortLink) {
this.shortLink = shortLink;
}

/**
* 
* @return
* The powerUps
*/
public List<Object> getPowerUps() {
return powerUps;
}

/**
* 
* @param powerUps
* The powerUps
*/
public void setPowerUps(List<Object> powerUps) {
this.powerUps = powerUps;
}

/**
* 
* @return
* The dateLastActivity
*/
public String getDateLastActivity() {
return dateLastActivity;
}

/**
* 
* @param dateLastActivity
* The dateLastActivity
*/
public void setDateLastActivity(String dateLastActivity) {
this.dateLastActivity = dateLastActivity;
}

/**
* 
* @return
* The idTags
*/
public List<Object> getIdTags() {
return idTags;
}

/**
* 
* @param idTags
* The idTags
*/
public void setIdTags(List<Object> idTags) {
this.idTags = idTags;
}

/**
* 
* @return
* The id
*/
public String getId() {
return id;
}

/**
* 
* @param id
* The id
*/
public void setId(String id) {
this.id = id;
}

/**
* 
* @return
* The invited
*/
public Boolean getInvited() {
return invited;
}

/**
* 
* @param invited
* The invited
*/
public void setInvited(Boolean invited) {
this.invited = invited;
}

/**
* 
* @return
* The starred
*/
public Boolean getStarred() {
return starred;
}

/**
* 
* @param starred
* The starred
*/
public void setStarred(Boolean starred) {
this.starred = starred;
}

/**
* 
* @return
* The url
*/
public String getUrl() {
return url;
}

/**
* 
* @param url
* The url
*/
public void setUrl(String url) {
this.url = url;
}

/**
* 
* @return
* The prefs
*/
public Prefs getPrefs() {
return prefs;
}

/**
* 
* @param prefs
* The prefs
*/
public void setPrefs(Prefs prefs) {
this.prefs = prefs;
}

/**
* 
* @return
* The memberships
*/
public List<Membership> getMemberships() {
return memberships;
}

/**
* 
* @param memberships
* The memberships
*/
public void setMemberships(List<Membership> memberships) {
this.memberships = memberships;
}

/**
* 
* @return
* The subscribed
*/
public Boolean getSubscribed() {
return subscribed;
}

/**
* 
* @param subscribed
* The subscribed
*/
public void setSubscribed(Boolean subscribed) {
this.subscribed = subscribed;
}

/**
* 
* @return
* The labelNames
*/
public LabelNames getLabelNames() {
return labelNames;
}

/**
* 
* @param labelNames
* The labelNames
*/
public void setLabelNames(LabelNames labelNames) {
this.labelNames = labelNames;
}

/**
* 
* @return
* The dateLastView
*/
public String getDateLastView() {
return dateLastView;
}

/**
* 
* @param dateLastView
* The dateLastView
*/
public void setDateLastView(String dateLastView) {
this.dateLastView = dateLastView;
}

/**
* 
* @return
* The shortUrl
*/
public String getShortUrl() {
return shortUrl;
}

/**
* 
* @param shortUrl
* The shortUrl
*/
public void setShortUrl(String shortUrl) {
this.shortUrl = shortUrl;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
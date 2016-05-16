package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@SuppressWarnings("serial")
@Generated("org.jsonschema2pojo")
public class Prefs implements Serializable{

private String permissionLevel;
private String voting;
private String comments;
private String invitations;
private Boolean selfJoin;
private Boolean cardCovers;
private Boolean calendarFeedEnabled;
private String background;
private Object backgroundImage;
private Object backgroundImageScaled;
private Boolean backgroundTile;
private String backgroundBrightness;
private String backgroundColor;
private Boolean canBePublic;
private Boolean canBeOrg;
private Boolean canBePrivate;
private Boolean canInvite;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The permissionLevel
*/
public String getPermissionLevel() {
return permissionLevel;
}

/**
* 
* @param permissionLevel
* The permissionLevel
*/
public void setPermissionLevel(String permissionLevel) {
this.permissionLevel = permissionLevel;
}

/**
* 
* @return
* The voting
*/
public String getVoting() {
return voting;
}

/**
* 
* @param voting
* The voting
*/
public void setVoting(String voting) {
this.voting = voting;
}

/**
* 
* @return
* The comments
*/
public String getComments() {
return comments;
}

/**
* 
* @param comments
* The comments
*/
public void setComments(String comments) {
this.comments = comments;
}

/**
* 
* @return
* The invitations
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
* @return
* The selfJoin
*/
public Boolean getSelfJoin() {
return selfJoin;
}

/**
* 
* @param selfJoin
* The selfJoin
*/
public void setSelfJoin(Boolean selfJoin) {
this.selfJoin = selfJoin;
}

/**
* 
* @return
* The cardCovers
*/
public Boolean getCardCovers() {
return cardCovers;
}

/**
* 
* @param cardCovers
* The cardCovers
*/
public void setCardCovers(Boolean cardCovers) {
this.cardCovers = cardCovers;
}

/**
* 
* @return
* The calendarFeedEnabled
*/
public Boolean getCalendarFeedEnabled() {
return calendarFeedEnabled;
}

/**
* 
* @param calendarFeedEnabled
* The calendarFeedEnabled
*/
public void setCalendarFeedEnabled(Boolean calendarFeedEnabled) {
this.calendarFeedEnabled = calendarFeedEnabled;
}

/**
* 
* @return
* The background
*/
public String getBackground() {
return background;
}

/**
* 
* @param background
* The background
*/
public void setBackground(String background) {
this.background = background;
}

/**
* 
* @return
* The backgroundImage
*/
public Object getBackgroundImage() {
return backgroundImage;
}

/**
* 
* @param backgroundImage
* The backgroundImage
*/
public void setBackgroundImage(Object backgroundImage) {
this.backgroundImage = backgroundImage;
}

/**
* 
* @return
* The backgroundImageScaled
*/
public Object getBackgroundImageScaled() {
return backgroundImageScaled;
}

/**
* 
* @param backgroundImageScaled
* The backgroundImageScaled
*/
public void setBackgroundImageScaled(Object backgroundImageScaled) {
this.backgroundImageScaled = backgroundImageScaled;
}

/**
* 
* @return
* The backgroundTile
*/
public Boolean getBackgroundTile() {
return backgroundTile;
}

/**
* 
* @param backgroundTile
* The backgroundTile
*/
public void setBackgroundTile(Boolean backgroundTile) {
this.backgroundTile = backgroundTile;
}

/**
* 
* @return
* The backgroundBrightness
*/
public String getBackgroundBrightness() {
return backgroundBrightness;
}

/**
* 
* @param backgroundBrightness
* The backgroundBrightness
*/
public void setBackgroundBrightness(String backgroundBrightness) {
this.backgroundBrightness = backgroundBrightness;
}

/**
* 
* @return
* The backgroundColor
*/
public String getBackgroundColor() {
return backgroundColor;
}

/**
* 
* @param backgroundColor
* The backgroundColor
*/
public void setBackgroundColor(String backgroundColor) {
this.backgroundColor = backgroundColor;
}

/**
* 
* @return
* The canBePublic
*/
public Boolean getCanBePublic() {
return canBePublic;
}

/**
* 
* @param canBePublic
* The canBePublic
*/
public void setCanBePublic(Boolean canBePublic) {
this.canBePublic = canBePublic;
}

/**
* 
* @return
* The canBeOrg
*/
public Boolean getCanBeOrg() {
return canBeOrg;
}

/**
* 
* @param canBeOrg
* The canBeOrg
*/
public void setCanBeOrg(Boolean canBeOrg) {
this.canBeOrg = canBeOrg;
}

/**
* 
* @return
* The canBePrivate
*/
public Boolean getCanBePrivate() {
return canBePrivate;
}

/**
* 
* @param canBePrivate
* The canBePrivate
*/
public void setCanBePrivate(Boolean canBePrivate) {
this.canBePrivate = canBePrivate;
}

/**
* 
* @return
* The canInvite
*/
public Boolean getCanInvite() {
return canInvite;
}

/**
* 
* @param canInvite
* The canInvite
*/
public void setCanInvite(Boolean canInvite) {
this.canInvite = canInvite;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
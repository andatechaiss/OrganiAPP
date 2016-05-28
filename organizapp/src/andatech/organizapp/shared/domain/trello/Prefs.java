package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Prefs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8314407578670245520L;
	/**
		 * 
		 */
	private String permissionLevel;
	private String voting;
	private String comments;
	private String invitations;
	private Boolean selfJoin;
	private Boolean cardCovers;
	private Boolean calendarFeedEnabled;
	private String background;
	private String backgroundImage;
	private String backgroundImageScaled;
	private Boolean backgroundTile;
	private String backgroundBrightness;
	private String backgroundColor;
	private Boolean canBePublic;
	private Boolean canBeOrg;
	private Boolean canBePrivate;
	private Boolean canInvite;

	public Prefs() {

	}

	/**
	 * 
	 * @return The permissionLevel
	 */
	public String getPermissionLevel() {
		return permissionLevel;
	}

	/**
	 * 
	 * @param permissionLevel
	 *            The permissionLevel
	 */
	public void setPermissionLevel(String permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

	/**
	 * 
	 * @return The voting
	 */
	public String getVoting() {
		return voting;
	}

	/**
	 * 
	 * @param voting
	 *            The voting
	 */
	public void setVoting(String voting) {
		this.voting = voting;
	}

	/**
	 * 
	 * @return The comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * 
	 * @param comments
	 *            The comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
	 *            The invitations
	 */
	public void setInvitations(String invitations) {
		this.invitations = invitations;
	}

	/**
	 * 
	 * @return The selfJoin
	 */
	public Boolean getSelfJoin() {
		return selfJoin;
	}

	/**
	 * 
	 * @param selfJoin
	 *            The selfJoin
	 */
	public void setSelfJoin(Boolean selfJoin) {
		this.selfJoin = selfJoin;
	}

	/**
	 * 
	 * @return The cardCovers
	 */
	public Boolean getCardCovers() {
		return cardCovers;
	}

	/**
	 * 
	 * @param cardCovers
	 *            The cardCovers
	 */
	public void setCardCovers(Boolean cardCovers) {
		this.cardCovers = cardCovers;
	}

	/**
	 * 
	 * @return The calendarFeedEnabled
	 */
	public Boolean getCalendarFeedEnabled() {
		return calendarFeedEnabled;
	}

	/**
	 * 
	 * @param calendarFeedEnabled
	 *            The calendarFeedEnabled
	 */
	public void setCalendarFeedEnabled(Boolean calendarFeedEnabled) {
		this.calendarFeedEnabled = calendarFeedEnabled;
	}

	/**
	 * 
	 * @return The background
	 */
	public String getBackground() {
		return background;
	}

	/**
	 * 
	 * @param background
	 *            The background
	 */
	public void setBackground(String background) {
		this.background = background;
	}

	/**
	 * 
	 * @return The backgroundImage
	 */
	public String getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * 
	 * @param backgroundImage
	 *            The backgroundImage
	 */
	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	/**
	 * 
	 * @return The backgroundImageScaled
	 */
	public String getBackgroundImageScaled() {
		return backgroundImageScaled;
	}

	/**
	 * 
	 * @param backgroundImageScaled
	 *            The backgroundImageScaled
	 */
	public void setBackgroundImageScaled(String backgroundImageScaled) {
		this.backgroundImageScaled = backgroundImageScaled;
	}

	/**
	 * 
	 * @return The backgroundTile
	 */
	public Boolean getBackgroundTile() {
		return backgroundTile;
	}

	/**
	 * 
	 * @param backgroundTile
	 *            The backgroundTile
	 */
	public void setBackgroundTile(Boolean backgroundTile) {
		this.backgroundTile = backgroundTile;
	}

	/**
	 * 
	 * @return The backgroundBrightness
	 */
	public String getBackgroundBrightness() {
		return backgroundBrightness;
	}

	/**
	 * 
	 * @param backgroundBrightness
	 *            The backgroundBrightness
	 */
	public void setBackgroundBrightness(String backgroundBrightness) {
		this.backgroundBrightness = backgroundBrightness;
	}

	/**
	 * 
	 * @return The backgroundColor
	 */
	public String getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * 
	 * @param backgroundColor
	 *            The backgroundColor
	 */
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * 
	 * @return The canBePublic
	 */
	public Boolean getCanBePublic() {
		return canBePublic;
	}

	/**
	 * 
	 * @param canBePublic
	 *            The canBePublic
	 */
	public void setCanBePublic(Boolean canBePublic) {
		this.canBePublic = canBePublic;
	}

	/**
	 * 
	 * @return The canBeOrg
	 */
	public Boolean getCanBeOrg() {
		return canBeOrg;
	}

	/**
	 * 
	 * @param canBeOrg
	 *            The canBeOrg
	 */
	public void setCanBeOrg(Boolean canBeOrg) {
		this.canBeOrg = canBeOrg;
	}

	/**
	 * 
	 * @return The canBePrivate
	 */
	public Boolean getCanBePrivate() {
		return canBePrivate;
	}

	/**
	 * 
	 * @param canBePrivate
	 *            The canBePrivate
	 */
	public void setCanBePrivate(Boolean canBePrivate) {
		this.canBePrivate = canBePrivate;
	}

	/**
	 * 
	 * @return The canInvite
	 */
	public Boolean getCanInvite() {
		return canInvite;
	}

	/**
	 * 
	 * @param canInvite
	 *            The canInvite
	 */
	public void setCanInvite(Boolean canInvite) {
		this.canInvite = canInvite;
	}

}
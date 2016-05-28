package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("org.jsonschema2pojo")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Card implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2088074248950133308L;
	
	
	private String id;
    private Badges badges;
    private Boolean closed;
    private String dateLastActivity;
    private String desc;
    private String due;
    private String idBoard;
    private String idList;
    private List<String> idMembers = new ArrayList<String>();
    private List<Label> labels = new ArrayList<Label>();
    private String name;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The badges
     */
    public Badges getBadges() {
        return badges;
    }

    /**
     * 
     * @param badges
     *     The badges
     */
    public void setBadges(Badges badges) {
        this.badges = badges;
    }

    /**
     * 
     * @return
     *     The closed
     */
    public Boolean getClosed() {
        return closed;
    }

    /**
     * 
     * @param closed
     *     The closed
     */
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    /**
     * 
     * @return
     *     The dateLastActivity
     */
    public String getDateLastActivity() {
        return dateLastActivity;
    }

    /**
     * 
     * @param dateLastActivity
     *     The dateLastActivity
     */
    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    /**
     * 
     * @return
     *     The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 
     * @param desc
     *     The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 
     * @return
     *     The due
     */
    public String getDue() {
        return due;
    }

    /**
     * 
     * @param due
     *     The due
     */
    public void setDue(String due) {
        this.due = due;
    }

    /**
     * 
     * @return
     *     The idBoard
     */
    public String getIdBoard() {
        return idBoard;
    }

    /**
     * 
     * @param idBoard
     *     The idBoard
     */
    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    /**
     * 
     * @return
     *     The idList
     */
    public String getIdList() {
        return idList;
    }

    /**
     * 
     * @param idList
     *     The idList
     */
    public void setIdList(String idList) {
        this.idList = idList;
    }

    /**
     * 
     * @return
     *     The idMembers
     */
    public List<String> getIdMembers() {
        return idMembers;
    }

    /**
     * 
     * @param idMembers
     *     The idMembers
     */
    public void setIdMembers(List<String> idMembers) {
        this.idMembers = idMembers;
    }

    /**
     * 
     * @return
     *     The labels
     */
    public List<Label> getLabels() {
        return labels;
    }

    /**
     * 
     * @param labels
     *     The labels
     */
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

}

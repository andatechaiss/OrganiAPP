
package andatech.organizapp.shared.domain.calendar;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CalendarEvent {

    private String kind;
    private String etag;
    private String id;
    private String status;
    private String htmlLink;
    private String created;
    private String updated;
    private String summary;
    private Creator creator;
    private Organizer organizer;
    private Start start;
    private End end;
    private String iCalUID;
    private Integer sequence;
    private Reminders reminders;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * 
     * @param kind
     *     The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 
     * @return
     *     The etag
     */
    public String getEtag() {
        return etag;
    }

    /**
     * 
     * @param etag
     *     The etag
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

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
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The htmlLink
     */
    public String getHtmlLink() {
        return htmlLink;
    }

    /**
     * 
     * @param htmlLink
     *     The htmlLink
     */
    public void setHtmlLink(String htmlLink) {
        this.htmlLink = htmlLink;
    }

    /**
     * 
     * @return
     *     The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * 
     * @param updated
     *     The updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * 
     * @return
     *     The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 
     * @return
     *     The creator
     */
    public Creator getCreator() {
        return creator;
    }

    /**
     * 
     * @param creator
     *     The creator
     */
    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    /**
     * 
     * @return
     *     The organizer
     */
    public Organizer getOrganizer() {
        return organizer;
    }

    /**
     * 
     * @param organizer
     *     The organizer
     */
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    /**
     * 
     * @return
     *     The start
     */
    public Start getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    public void setStart(Start start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The end
     */
    public End getEnd() {
        return end;
    }

    /**
     * 
     * @param end
     *     The end
     */
    public void setEnd(End end) {
        this.end = end;
    }

    /**
     * 
     * @return
     *     The iCalUID
     */
    public String getICalUID() {
        return iCalUID;
    }

    /**
     * 
     * @param iCalUID
     *     The iCalUID
     */
    public void setICalUID(String iCalUID) {
        this.iCalUID = iCalUID;
    }

    /**
     * 
     * @return
     *     The sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * 
     * @param sequence
     *     The sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    /**
     * 
     * @return
     *     The reminders
     */
    public Reminders getReminders() {
        return reminders;
    }

    /**
     * 
     * @param reminders
     *     The reminders
     */
    public void setReminders(Reminders reminders) {
        this.reminders = reminders;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

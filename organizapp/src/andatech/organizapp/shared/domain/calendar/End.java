
package andatech.organizapp.shared.domain.calendar;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@SuppressWarnings("serial")
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class End implements Serializable{

    private String date;
    private String timeZone;

    /**
     * 
     * @return
     *     The dateTime
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param dateTime
     *     The dateTime
     */
    public void setDate(String dateTime) {
        this.date = dateTime;
    }

    /**
     * 
     * @return
     *     The timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * 
     * @param timeZone
     *     The timeZone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}

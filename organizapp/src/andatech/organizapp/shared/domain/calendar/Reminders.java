
package andatech.organizapp.shared.domain.calendar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@SuppressWarnings("serial")
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Reminders implements Serializable{

    private Boolean useDefault;
    private List<Override> overrides = new ArrayList<Override>();

    /**
     * 
     * @return
     *     The useDefault
     */
    public Boolean getUseDefault() {
        return useDefault;
    }

    /**
     * 
     * @param useDefault
     *     The useDefault
     */
    public void setUseDefault(Boolean useDefault) {
        this.useDefault = useDefault;
    }

    /**
     * 
     * @return
     *     The overrides
     */
    public List<Override> getOverrides() {
        return overrides;
    }

    /**
     * 
     * @param overrides
     *     The overrides
     */
    public void setOverrides(List<Override> overrides) {
        this.overrides = overrides;
    }
}

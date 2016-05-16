
package andatech.organizapp.shared.domain.calendar;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Override {

    private String method;
    private Integer minutes;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The method
     */
    public String getMethod() {
        return method;
    }

    /**
     * 
     * @param method
     *     The method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 
     * @return
     *     The minutes
     */
    public Integer getMinutes() {
        return minutes;
    }

    /**
     * 
     * @param minutes
     *     The minutes
     */
    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

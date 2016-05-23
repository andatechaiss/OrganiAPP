
package andatech.organizapp.shared.domain.calendar;

import java.io.Serializable;

import javax.annotation.Generated;

@SuppressWarnings("serial")
@Generated("org.jsonschema2pojo")
public class Override implements Serializable{

    private String method;
    private Integer minutes;

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
}

package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@SuppressWarnings("serial")
@Generated("org.jsonschema2pojo")
public class Webhook implements Serializable{

private Integer readyState;
private String responseText;
private Integer status;
private String statusText;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The readyState
*/
public Integer getReadyState() {
return readyState;
}

/**
* 
* @param readyState
* The readyState
*/
public void setReadyState(Integer readyState) {
this.readyState = readyState;
}

/**
* 
* @return
* The responseText
*/
public String getResponseText() {
return responseText;
}

/**
* 
* @param responseText
* The responseText
*/
public void setResponseText(String responseText) {
this.responseText = responseText;
}

/**
* 
* @return
* The status
*/
public Integer getStatus() {
return status;
}

/**
* 
* @param status
* The status
*/
public void setStatus(Integer status) {
this.status = status;
}

/**
* 
* @return
* The statusText
*/
public String getStatusText() {
return statusText;
}

/**
* 
* @param statusText
* The statusText
*/
public void setStatusText(String statusText) {
this.statusText = statusText;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
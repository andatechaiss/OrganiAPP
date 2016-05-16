package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@SuppressWarnings("serial")
@Generated("org.jsonschema2pojo")
public class Card implements Serializable {

private String id;
private String name;
private String idList;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
* The idList
*/
public String getIdList() {
return idList;
}

/**
* 
* @param idList
* The idList
*/
public void setIdList(String idList) {
this.idList = idList;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
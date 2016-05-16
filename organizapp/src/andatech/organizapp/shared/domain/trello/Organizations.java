package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@SuppressWarnings("serial")
@Generated("org.jsonschema2pojo")
public class Organizations implements Serializable{

	private String id;
	private String name;
	private String displayName;
	private String desc;
	private Object descData;
	private String url;
	private Object website;
	private Object logoHash;
	private List<Object> products = new ArrayList<Object>();
	private List<Object> powerUps = new ArrayList<Object>();
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 
	 * @param displayName
	 *            The displayName
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 
	 * @return The desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 
	 * @param desc
	 *            The desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 
	 * @return The descData
	 */
	public Object getDescData() {
		return descData;
	}

	/**
	 * 
	 * @param descData
	 *            The descData
	 */
	public void setDescData(Object descData) {
		this.descData = descData;
	}

	/**
	 * 
	 * @return The url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @param url
	 *            The url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @return The website
	 */
	public Object getWebsite() {
		return website;
	}

	/**
	 * 
	 * @param website
	 *            The website
	 */
	public void setWebsite(Object website) {
		this.website = website;
	}

	/**
	 * 
	 * @return The logoHash
	 */
	public Object getLogoHash() {
		return logoHash;
	}

	/**
	 * 
	 * @param logoHash
	 *            The logoHash
	 */
	public void setLogoHash(Object logoHash) {
		this.logoHash = logoHash;
	}

	/**
	 * 
	 * @return The products
	 */
	public List<Object> getProducts() {
		return products;
	}

	/**
	 * 
	 * @param products
	 *            The products
	 */
	public void setProducts(List<Object> products) {
		this.products = products;
	}

	/**
	 * 
	 * @return The powerUps
	 */
	public List<Object> getPowerUps() {
		return powerUps;
	}

	/**
	 * 
	 * @param powerUps
	 *            The powerUps
	 */
	public void setPowerUps(List<Object> powerUps) {
		this.powerUps = powerUps;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Organizations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -802339118646680069L;
	/**
	 * 
	 */
	private String id;
	private String name;
	private String displayName;
	private String desc;
	private String descData;
	private String url;
	private String website;
	private String logoHash;
	private List<String> products = new ArrayList<String>();
	private List<String> powerUps = new ArrayList<String>();

	public Organizations() {

	}

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
	public String getDescData() {
		return descData;
	}

	/**
	 * 
	 * @param descData
	 *            The descData
	 */
	public void setDescData(String descData) {
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
	 * @return The website //
	 */
	 public String getWebsite() {
	 return website;
	 }
	
	 /**
	 *
	 * @param website
	 * The website
	 */
	 public void setWebsite(String website) {
	 this.website = website;
	 }
	
	 /**
	 *
	 * @return The logoHash
	 */
	 public String getLogoHash() {
	 return logoHash;
	 }
	
	 /**
	 *
	 * @param logoHash
	 * The logoHash
	 */
	 public void setLogoHash(String logoHash) {
	 this.logoHash = logoHash;
	 }
	
	 /**
	 *
	 * @return The products
	 */
	 public List<String> getProducts() {
	 return products;
	 }
	
	 /**
	 *
	 * @param products
	 * The products
	 */
	 public void setProducts(List<String> products) {
	 this.products = products;
	 }
	
	 /**
	 *
	 * @return The powerUps
	 */
	 public List<String> getPowerUps() {
	 return powerUps;
	 }
	
	 /**
	 *
	 * @param powerUps
	 * The powerUps
	 */
	 public void setPowerUps(List<String> powerUps) {
	 this.powerUps = powerUps;
	 }

}
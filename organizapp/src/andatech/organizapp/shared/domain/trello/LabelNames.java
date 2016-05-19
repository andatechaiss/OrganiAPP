package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelNames implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3050960891540512042L;
	/**
		 * 
		 */
	private String green;
	private String yellow;
	private String orange;
	private String red;
	private String purple;
	private String blue;
	private String sky;
	private String lime;
	private String pink;
	private String black;
	//private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public LabelNames() {

	}

	/**
	 * 
	 * @return The green
	 */
	public String getGreen() {
		return green;
	}

	/**
	 * 
	 * @param green
	 *            The green
	 */
	public void setGreen(String green) {
		this.green = green;
	}

	/**
	 * 
	 * @return The yellow
	 */
	public String getYellow() {
		return yellow;
	}

	/**
	 * 
	 * @param yellow
	 *            The yellow
	 */
	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

	/**
	 * 
	 * @return The orange
	 */
	public String getOrange() {
		return orange;
	}

	/**
	 * 
	 * @param orange
	 *            The orange
	 */
	public void setOrange(String orange) {
		this.orange = orange;
	}

	/**
	 * 
	 * @return The red
	 */
	public String getRed() {
		return red;
	}

	/**
	 * 
	 * @param red
	 *            The red
	 */
	public void setRed(String red) {
		this.red = red;
	}

	/**
	 * 
	 * @return The purple
	 */
	public String getPurple() {
		return purple;
	}

	/**
	 * 
	 * @param purple
	 *            The purple
	 */
	public void setPurple(String purple) {
		this.purple = purple;
	}

	/**
	 * 
	 * @return The blue
	 */
	public String getBlue() {
		return blue;
	}

	/**
	 * 
	 * @param blue
	 *            The blue
	 */
	public void setBlue(String blue) {
		this.blue = blue;
	}

	/**
	 * 
	 * @return The sky
	 */
	public String getSky() {
		return sky;
	}

	/**
	 * 
	 * @param sky
	 *            The sky
	 */
	public void setSky(String sky) {
		this.sky = sky;
	}

	/**
	 * 
	 * @return The lime
	 */
	public String getLime() {
		return lime;
	}

	/**
	 * 
	 * @param lime
	 *            The lime
	 */
	public void setLime(String lime) {
		this.lime = lime;
	}

	/**
	 * 
	 * @return The pink
	 */
	public String getPink() {
		return pink;
	}

	/**
	 * 
	 * @param pink
	 *            The pink
	 */
	public void setPink(String pink) {
		this.pink = pink;
	}

	/**
	 * 
	 * @return The black
	 */
	public String getBlack() {
		return black;
	}

	/**
	 * 
	 * @param black
	 *            The black
	 */
	public void setBlack(String black) {
		this.black = black;
	}

//	public Map<String, Object> getAdditionalProperties() {
//		return this.additionalProperties;
//	}
//
//	public void setAdditionalProperty(String name, Object value) {
//		this.additionalProperties.put(name, value);
//	}

}
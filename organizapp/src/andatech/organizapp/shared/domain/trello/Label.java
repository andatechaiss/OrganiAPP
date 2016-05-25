
package andatech.organizapp.shared.domain.trello;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Label implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8136722956068288557L;
	
	
	private String id;
    private String idBoard;
    private String name;
    private String color;
    private Integer uses;

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
     *     The idBoard
     */
    public String getIdBoard() {
        return idBoard;
    }

    /**
     * 
     * @param idBoard
     *     The idBoard
     */
    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The color
     */
    public String getColor() {
        return color;
    }

    /**
     * 
     * @param color
     *     The color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 
     * @return
     *     The uses
     */
    public Integer getUses() {
        return uses;
    }

    /**
     * 
     * @param uses
     *     The uses
     */
    public void setUses(Integer uses) {
        this.uses = uses;
    }

}

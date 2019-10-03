package models.people;

import java.io.Serializable;
import java.util.Observable;

/**
 * <h1>SuperVillain</h1>
 * <p>Super villain is just an implementation of SuperPerson</p>
 */
public class SuperVillain extends Observable implements Serializable, SuperPerson {
    private String type;
    private String strength;

    /**
     * <p>You need a type and strength for a villain</p>
     * @param type
     * @param strength
     */
    public SuperVillain(String type, String strength) {
        this.type = type;
        this.strength = strength;
    }

    /**
     * <p>get the type of the villain.</p>
     * @return String type
     */
    public String getType() {
        return type;
    }

    /**
     * <p>Set the type of the villain</p>
     * @param String type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <p>Get the strength of the SuperVillain</p>
     * @return String strength
     */
    public String getStrength() {
        return strength;
    }

    /**
     * Set the strength of the Villain
     * @param String strength
     */
    public void setStrength(String strength) {
        this.strength = strength;
    }


    @Override
    public String toString() {
        return "SuperVillain{" +
                "type='" + type + '\'' +
                ", strength='" + strength + '\'' +
                '}';
    }

}

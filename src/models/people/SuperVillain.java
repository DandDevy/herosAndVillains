package models.people;

import java.io.Serializable;
import java.util.Observable;

/**
 * <h1>SuperVillain</h1>
 * <p>Super villain is just an implementation of SuperPerson</p>
 */
public class SuperVillain extends Observable implements Serializable, SuperPerson {
    private String strength;

    /**
     * <p>You need strength for a villain</p>
     * @param strength
     */
    public SuperVillain( String strength) {
        this.strength = strength;
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
                " strength='" + strength + '\'' +
                '}';
    }

}

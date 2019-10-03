package models.people;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 * <h1>SuperHero</h1>
 * <p>SuperHero is just an implementation of SuperPerson</p>
 */
public class SuperHero implements Serializable, SuperPerson, Observer {
    private String type;
    private String strength;
    private String villainLocation;

    /**
     * <p>You need a type and strength for a SuperHero</p>
     * @param type
     * @param strength
     */
    public SuperHero(String type, String strength) {
        this.type = type;
        this.strength = strength;
    }

    /**
     * <p>get the type of the SuperHero.</p>
     * @return String type
     */
    public String getType() {
        return type;
    }

    /**
     * <p>Set the type of the SuperHero</p>
     * @param String type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <p>Get the strength of the SuperHero</p>
     * @return String strength
     */
    public String getStrength() {
        return strength;
    }

    /**
     * Set the strength of the SuperHero
     * @param String strength
     */
    public void setStrength(String strength) {
        this.strength = strength;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("updated: " + this);
    }

    /**
     * <p>Gets the location of the villain the hero is after</p>
     * @return
     */
    public String getVillainLocation() {
        return villainLocation;
    }

    /**
     * <p>Sets the location of the villain the hero is after</p>
     * @param villainLocation
     */
    public void setVillainLocation(String villainLocation) {
        this.villainLocation = villainLocation;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "type='" + type + '\'' +
                ", strength='" + strength + '\'' +
                ", villainLocation='" + villainLocation + '\'' +
                '}';
    }
}

package models.people;

import java.io.Serializable;

/**
 * <h1>SuperHero</h1>
 * <p>SuperHero is just an implementation of SuperPerson</p>
 */
public class SuperHero implements Serializable, SuperPerson {
    private String type;
    private String strength;

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
    public String toString() {
        return "SuperHero{" +
                "type='" + type + '\'' +
                ", strength='" + strength + '\'' +
                '}';
    }
}

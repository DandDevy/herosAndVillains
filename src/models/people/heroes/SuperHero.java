package models.people.heroes;

import controllers.Controller;
import models.people.SuperPerson;
import models.people.villains.SuperVillain;
import models.util.Observer;

import java.io.Serializable;

/**
 * <h1>SuperHero</h1>
 * <p>SuperHero is just an implementation of SuperPerson</p>
 */
public class SuperHero implements Serializable, SuperPerson, Observer {
    private String strength;
    private String villainLocation;

    /**
     * <p>You need strength for a SuperHero</p>
     * @param strength
     */
    public SuperHero(String strength) {
        this.strength = strength;
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
                ", strength='" + strength + '\'' +
                ", villainLocation='" + villainLocation + '\'' +
                '}';
    }

    @Override
    public void update(SuperVillain superVillain) {
        System.out.println("Hero update, villain to beat -->>>" + superVillain);
        Controller.destroyVillain(superVillain.getPath());
    }
}

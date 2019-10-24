package models.people.villains;

import models.people.SuperPerson;
import models.util.Observable;
import models.util.Observer;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


/**
 * <h1>SuperVillain</h1>
 * <p>Super villain is just an implementation of SuperPerson</p>
 */
public class SuperVillain implements Serializable, SuperPerson {
    private String strength;
    private List<Observer> observerList;
    private Path path;

    /**
     * <p>You need strength for a villain</p>
     * @param strength
     */
    public SuperVillain( String strength) {
        this.strength = strength;
        observerList = new ArrayList<Observer>();
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

    /**
     * <p>Get the path for this villain. Which battle zone</p>
     * @return path
     */
    public Path getPath() {
        return path;
    }

    /**
     * <p>Set the path of the villain.</p>
     * @param path
     */
    public void setPath(Path path) {
        this.path = path;
    }
}

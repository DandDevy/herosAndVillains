package models.people;


import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class SuperPerson<SuperPerson extends Observer> extends Observable implements Person, SuperHero, SuperVillain, Serializable {
    private String type;
    private String strength;

    public SuperPerson(String type, String strength) {
        this.type = type;
        this.strength = strength;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    @Override
    public void update(models.people.SuperPerson<Observer> villain) {

    }

    @Override
    public void update() {

    }


    public void update(SuperPerson villain) {

    }

    @Override
    public String toString() {
        return "SuperPerson{" +
                "type='" + type + '\'' +
                ", strength='" + strength + '\'' +
                '}';
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}

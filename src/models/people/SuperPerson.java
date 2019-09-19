package models.people;


import java.io.Serializable;

public class SuperPerson<S> implements Person, SuperHero, SuperVillain, Serializable {
    private String type;
    private String strength;

    public SuperPerson(String type, String strength) {
        this.type = type;
        this.strength = strength;
    }

    public void update(){

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
    public String toString() {
        return "SuperPerson{" +
                "type='" + type + '\'' +
                ", strength='" + strength + '\'' +
                '}';
    }
}

package models.people;

import java.io.Serializable;

public class SuperHero implements Serializable, SuperPerson {
    private String type;
    private String strength;

    public SuperHero(String type, String strength) {
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
    public String toString() {
        return "SuperHero{" +
                "type='" + type + '\'' +
                ", strength='" + strength + '\'' +
                '}';
    }
}

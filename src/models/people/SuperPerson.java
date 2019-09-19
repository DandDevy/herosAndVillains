package models.people;


public class SuperPerson<S> implements Person, SuperHero, SuperVillain{
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
}

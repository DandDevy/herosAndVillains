package models.factories;


import models.people.*;

/**
 * <h1>PeopleFactory</h1>
 * <p>The people you can generate are Person, SuperPerson, SuperHero and SuperVillain</p>
 */
public abstract class PeopleFactory {

    /**
     * Generates and returns a new SuperHero
     * @param type
     * @param strength
     * @return SuperHero
     */
    public static SuperHero getHero(String type, String strength){
        SuperHero hero = null;

        if(type == "Strong")
            hero = new GoodStrongMan(strength);

        else if (type == "Fly")
            hero = new GoodFlyPerson(strength);
        return hero;
    }

    /**
     * Generates and returns a new SuperVillain
     * @param type
     * @param strength
     * @return SuperVillain
     */
    public static SuperVillain getVillain(String type, String strength){
        return new  SuperVillain(type, strength);
    }
}

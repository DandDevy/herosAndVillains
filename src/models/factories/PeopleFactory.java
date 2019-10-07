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

        if(type.equals("Strong"))
            hero = new GoodStrongMan(strength);

        else if (type.equals("Fly"))
            hero = new GoodFlyPerson(strength);
        return hero;
    }

    /**
     * Generates and returns a new SuperVillain
     * @param strength
     * @return SuperVillain
     */
    public static SuperVillain getVillain(String type, String strength){
        SuperVillain villain = null;
        if(type.equals("Strong"))
            villain = new BadStrongMan(strength);

        else if (type.equals("Fly"))
            villain = new BadFlyPerson(strength);
        return villain;
    }
}

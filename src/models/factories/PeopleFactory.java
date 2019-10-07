package models.factories;


import models.people.GoodStrongMan;
import models.people.SuperHero;
import models.people.SuperPerson;
import models.people.SuperVillain;

/**
 * <h1>PeopleFactory</h1>
 * <p>The people you can generate are Person, SuperPerson, SuperHero and SuperVillain</p>
 */
public class PeopleFactory {

    /**
     * Generates and returns a new SuperHero
     * @param type
     * @param strength
     * @return SuperHero
     */
    public static SuperHero getHero(String type, String strength){
        SuperHero hero = null;

//        if(type == "Strong")
//            hero = new GoodStrongMan()
        return new SuperHero(type, strength);
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

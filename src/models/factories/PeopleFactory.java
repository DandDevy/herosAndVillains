package models.factories;

import models.people.Person;
import models.people.SuperHero;
import models.people.SuperPerson;
import models.people.SuperVillain;

import java.util.Observer;

/**
 * <h1>PeopleFactory</h1>
 * <p>The people you can generate are Person, SuperPerson, SuperHero and SuperVillain</p>
 */
public class PeopleFactory {

    /**
     * Generates and returns a new SuperHero
     * @param type
     * @param strength
     * @return SuperPerson<SuperHero>
     */
    public static SuperPerson<SuperHero> getHero(String type, String strength){
        return new SuperPerson<SuperHero>(type, strength);
    }

    /**
     * Generates and returns a new SuperVillain
     * @param type
     * @param strength
     * @return SuperPerson<SuperVillain>
     */
    public static SuperPerson<SuperVillain> getVillain(String type, String strength){
        return new  SuperPerson<SuperVillain>(type, strength);
    }

    /**
     * Generates and returns a new Person
     * @param type
     * @param strength
     * @return SuperPerson<Person>
     */
    public static SuperPerson<Person> getPerson(String type, String strength){
        return new  SuperPerson<Person>(type, strength);
    }

    /**
     * Generates and returns a new SuperPerson
     * @param type
     * @param strength
     * @return SuperPerson
     */
    public static SuperPerson<SuperPerson> getSuperPerson(String type, String strength){
        return new SuperPerson<SuperPerson>(type, strength);
    }
}

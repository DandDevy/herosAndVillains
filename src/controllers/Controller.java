package controllers;

import models.factories.PeopleFactory;
import models.people.SuperHero;
import models.people.SuperPerson;

public class Controller {
    private static final String SERIALIZATION_LOCATION = "C:\\Users\\Dashc\\IdeaProjects\\IdeaThirdYearProjects\\distributedSystemProgramming\\herosAndVillains\\herosAndVillains\\src\\common\\";
    public static void addHero(String type, String strength) {
        SuperPerson<SuperHero> hero = PeopleFactory.getHero(type, strength);
        MySerializerController.serializeHero(hero);

        SuperPerson<SuperHero> hero1 = MySerializerController.deSerializeHero();

        MySerializerController.serializeObject(hero, SERIALIZATION_LOCATION + "battle-zone-1.ser");
        SuperPerson<SuperHero> hero3 = (SuperPerson<SuperHero>) MySerializerController.deSerializeObject(SERIALIZATION_LOCATION + "battle-zone-1.ser");
        System.out.println("hero3" + hero3);
    }
}

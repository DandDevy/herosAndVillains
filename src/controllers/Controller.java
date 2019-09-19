package controllers;

import models.factories.PeopleFactory;
import models.people.SuperHero;
import models.people.SuperPerson;

public class Controller {
    public static void addHero(String type, String strength) {
        SuperPerson<SuperHero> hero = PeopleFactory.getHero(type, strength);
        MySerializerController.serializeHero(hero);

        SuperPerson<SuperHero> hero1 = MySerializerController.deSerializeHero();
    }
}

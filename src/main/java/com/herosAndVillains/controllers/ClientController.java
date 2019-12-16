package main.java.com.herosAndVillains.controllers;

import main.java.com.herosAndVillains.models.people.SuperPerson;
import main.java.com.herosAndVillains.models.people.heroes.SuperHero;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;

import java.util.ArrayList;

public class ClientController {
    public static ArrayList<SuperPerson> lookup(Object object) {
        ArrayList<SuperPerson> superPeople = null;
        if(object instanceof SuperVillain){
            SuperVillain superVillain = (SuperVillain) object;
            SuperHero superHero = Controller.getHeroForVillain(superVillain);
            superPeople = new ArrayList<SuperPerson>();
            superPeople.add(superHero);
            superPeople.add(superVillain);
        }

        return superPeople;
    }
}

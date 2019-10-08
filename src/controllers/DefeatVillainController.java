package controllers;

import models.factories.PeopleFactory;
import models.people.SuperHero;
import models.people.SuperVillain;

import java.nio.file.Path;

/**
 * <h1>DefeatVillainController</h1>
 * <p></p>
 */
public class DefeatVillainController {
    public static void dealWithVillain(Path eventpath) {
        SuperVillain villain = getVillain(eventpath);

        SuperHero hero = getHeroForVillain(villain);

//        villain.notifyObservers(eventpath);
        villain.notifyObservers();
//        hero.update(villain, eventpath);
        defeatVillain(eventpath);
        removeFile(eventpath);
    }

    private static SuperHero getHeroForVillain(SuperVillain villain) {
        return PeopleFactory.getHero("villain.getType()", villain.getStrength());
    }

    private static SuperVillain getVillain(Path eventpath) {
        return (SuperVillain) MySerializerController.deSerializeObject(eventpath.toString());
    }

    private static void removeFile(Path eventpath) {

    }

    private static void defeatVillain(Path eventpath) {

    }
}

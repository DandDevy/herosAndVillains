package controllers;

import models.factories.PeopleFactory;
import models.people.SuperHero;
import models.people.SuperVillain;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static final String SERIALIZATION_LOCATION = "src\\common\\"; //reminder: C:\Users\Dashc\IdeaProjects\IdeaThirdYearProjects\distributedSystemProgramming\herosAndVillains\herosAndVillains\
    private static final String SERIALIZATION_BATTLE_FOLDER_NAME = "battle-zone-";
    private static final String SERIALIZATION_fILE_NAME_ENDING = ".ser";
    private static final int BATTLE_FILE_NUMBER = 1;

    public static void addHero(String type, String strength) {
        SuperHero hero = PeopleFactory.getHero(type, strength);
        MySerializerController.serializeHero(hero);

        SuperHero hero1 = MySerializerController.deSerializeHero();

        MySerializerController.serializeObject(hero, SERIALIZATION_LOCATION + "battle-zone-1.ser");
        SuperHero hero3 = (SuperHero) MySerializerController.deSerializeObject(SERIALIZATION_LOCATION + "battle-zone-1.ser");
        System.out.println("hero3" + hero3);
    }

    public static void addVillain(String type, String strength) {
        SuperVillain villain = PeopleFactory.getVillain(type, strength);
        ArrayList people = MySerializerController.deSerializeObjects(SERIALIZATION_LOCATION + SERIALIZATION_BATTLE_FOLDER_NAME
                + BATTLE_FILE_NUMBER + SERIALIZATION_fILE_NAME_ENDING);

        people.add(villain);
        MySerializerController.serializeObject(people,
                SERIALIZATION_LOCATION + SERIALIZATION_BATTLE_FOLDER_NAME
                        + BATTLE_FILE_NUMBER + SERIALIZATION_fILE_NAME_ENDING
        );
        System.out.println(villain + " has been serialized");
    }

    public static void generateVillain(int delay) {
        while (true){
            addVillain("strong", "fire");
            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

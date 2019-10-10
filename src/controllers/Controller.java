package controllers;

import models.factories.PeopleFactory;
import models.people.BadFlyPerson;
import models.people.BadStrongMan;
import models.people.SuperHero;
import models.people.SuperVillain;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static final String SERIALIZATION_LOCATION = "src\\common\\"; //reminder: C:\Users\Dashc\IdeaProjects\IdeaThirdYearProjects\distributedSystemProgramming\herosAndVillains\herosAndVillains\
    private static final String FOLDER = SERIALIZATION_LOCATION + "battle-zone-";
    private static final String SER_fILE_ENDING = ".ser";
    private static int battleFileNumber = 0;

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

        MySerializerController.serializeObject(villain, FOLDER + getBattleFileNumberUpdated() + SER_fILE_ENDING);
        System.out.println(villain + " has been serialized");
    }

    public static synchronized int getBattleFileNumberUpdated(){
        return battleFileNumber++;
    }

    public static void generateVillain(int delay, String type, String strength) {
        while (true){
            addVillain(type, strength);
            try {
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void observe(int delay) {
        WatcherController.watch(SERIALIZATION_LOCATION, delay);
    }

    public static SuperHero getHeroForVillain(SuperVillain villain) {
        String villainType = "Strong";
        try {
            BadFlyPerson badFlyPerson = (BadFlyPerson) villain;
            villainType = "Fly";
            System.out.println("This is a BadFlyPerson <--" + villain);
        } catch (Exception e){
            System.out.println("not a BadFlyPerson <--" + villain);
        }
        try {
            BadStrongMan badStrongMan = (BadStrongMan) villain;
            villainType = "Strong";
            System.out.println("This is a BadStrongMan <--" + villain);
        } catch (Exception e){
            System.out.println("not a BadStrongMan <--" + villain);
        }
        return PeopleFactory.getHero(villainType, villain.getStrength());
    }

    /**
     * <p>get villain from common folder</p>
     * @param eventpath
     * @return
     */
    private static SuperVillain getVillain(Path eventpath) {
        System.out.println("SERIALIZATION_LOCATION + eventpath.toString():  " + SERIALIZATION_LOCATION + eventpath.toString());
        SuperVillain superVillain = null;
        try {
            superVillain = (SuperVillain) MySerializerController.deSerializeObject(SERIALIZATION_LOCATION + eventpath.toString());
        } catch (Exception e){
            e.printStackTrace();
        }

        return superVillain;
    }


    public static void dealWithVillain(Path eventpath) {
        SuperVillain villain = null;
        try {
            System.out.println("eventpath0: " + eventpath);
            villain = getVillain(eventpath);
            villain.setPath(eventpath);
        } catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("villain : " + villain);

        SuperHero hero = getHeroForVillain(villain);
        villain.registerObserver(hero);
        villain.notifyObservers();

//        villain.notifyObservers(eventpath);
//        hero.update(villain, eventpath);
//        defeatVillain(eventpath);
//        removeFile(eventpath);
    }

    public static void defeatVillain(Path eventpath, SuperHero hero, SuperVillain villain) {

    }

    public static void destroyVillain(Path eventpath) {
     // destroy file SERIALIZATION_LOCATION + eventpath.toString()
        File fileToDestroy = new File(SERIALIZATION_LOCATION + eventpath.toString());
        if(fileToDestroy.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }
}

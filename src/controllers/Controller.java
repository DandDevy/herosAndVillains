package controllers;

import models.factories.heroFactories.GoodFlyPersonFactory;
import models.factories.heroFactories.GoodStrongManFactory;
import models.factories.villainFactories.BadFlyPersonFactory;
import models.factories.villainFactories.BadStrongManFactory;
import models.people.heroes.SuperHero;
import models.people.villains.BadFlyPerson;
import models.people.villains.BadStrongMan;
import models.people.villains.SuperVillain;
import models.threaded.VillainGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static final String SERIALIZATION_LOCATION = "src\\common\\"; //reminder: C:\Users\Dashc\IdeaProjects\IdeaThirdYearProjects\distributedSystemProgramming\herosAndVillains\herosAndVillains\
    private static final String FOLDER = SERIALIZATION_LOCATION + "battle-zone-";
    private static final String SER_fILE_ENDING = ".ser";
    private static int battleFileNumber = 0;
    private static final boolean GENERATE_IN_THREAD = true;

    public static void addHero(String type, String strength) {
        SuperHero hero = null;//PeopleFactory.getHero(type, strength);
        if(type.equals("Strong")){
            hero = new GoodStrongManFactory().getHero(strength);
        } else if(type.equals("Fly")){
            hero = new GoodFlyPersonFactory().getHero(strength);
        }
//        MySerializerController.serializeHero(hero);

//        SuperHero hero1 = MySerializerController.deSerializeHero();

        int battleNumber = getBattleFileNumberUpdated();
        MySerializerController.serializeObject(hero, FOLDER + battleNumber + SER_fILE_ENDING);
        SuperHero deSerializedHero = (SuperHero) MySerializerController.deSerializeObject(FOLDER + battleNumber + SER_fILE_ENDING);
        System.out.println("controller.addHero(): The hero that was serialized was: " + deSerializedHero);
    }

    public static void addVillain(String type, String strength) {
        SuperVillain villain = null;//PeopleFactory.getVillain(type, strength);
        if(type.equals("Strong")){

            villain = new BadStrongManFactory().getVillain(strength);
        } else if(type.equals("Fly")){
            villain = new BadFlyPersonFactory().getVillain(strength);
        }

        MySerializerController.serializeObject(villain, FOLDER + getBattleFileNumberUpdated() + SER_fILE_ENDING);
        System.out.println("controller.addVillain: "+ villain + " has been serialized");
    }

    /**
     * <p>This will return the next battle zone number to use. It increments by 1 and is synchronised.</p>
     * @return
     */
    public static synchronized int getBattleFileNumberUpdated(){
        return battleFileNumber++;
    }

    public static void generateVillain(int delay, String type, String strength) {
        if(GENERATE_IN_THREAD){
            Thread villainGeneratingThread = new Thread(new VillainGenerator(delay, type, strength));
            villainGeneratingThread.start();
        } else {
            while(true){
                addVillain(type, strength);
                try {
                    TimeUnit.SECONDS.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void observe(int delay) {
        WatcherController.watch(SERIALIZATION_LOCATION, delay);
    }

    public static SuperHero getHeroForVillain(SuperVillain villain) {
        SuperHero hero = null;
        if(villain instanceof BadFlyPerson){
            hero = new GoodFlyPersonFactory().getHero(villain.getStrength());
            System.out.println("Controller.getHeroForVillain: This is a BadFlyPerson <--" + villain);

        } else if( villain instanceof BadStrongMan){
            BadStrongMan badStrongMan = (BadStrongMan) villain;
            hero = new GoodStrongManFactory().getHero(villain.getStrength());
            System.out.println("Controller.getHeroForVillain: This is a BadStrongMan <--" + villain);
        }
//        try {
//            BadFlyPerson badFlyPerson = (BadFlyPerson) villain;
//            hero = new GoodFlyPersonFactory().getHero(villain.getStrength());
//            System.out.println("Controller.getHeroForVillain: This is a BadFlyPerson <--" + villain);
//        } catch (Exception e){
//            System.out.println("Controller.getHeroForVillain: not a BadFlyPerson <--" + villain);
//        }
//        try {
//            BadStrongMan badStrongMan = (BadStrongMan) villain;
//            hero = new GoodStrongManFactory().getHero(villain.getStrength());
//            System.out.println("Controller.getHeroForVillain: This is a BadStrongMan <--" + villain);
//        } catch (Exception e){
//            System.out.println("Controller.getHeroForVillain: not a BadStrongMan <--" + villain);
//        }
//        System.out.println("Controller.getHeroForVillain: created ->>" + hero + "   to fight   " + villain);
        return hero;
    }

    /**
     * <p>get villain from common folder</p>
     * @param eventpath
     * @return
     */
    private static SuperVillain getVillain(Path eventpath) {
        System.out.println("Controller.getVillain: SERIALIZATION_LOCATION + eventpath.toString():  " + SERIALIZATION_LOCATION + eventpath.toString());
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
            villain = getVillain(eventpath);
        } catch (Exception e){

            if (e instanceof FileNotFoundException)
                System.out.println("File not found because watcher has already deleted + " + eventpath);

            else
                e.printStackTrace();
        }
        if(villain != null){
            try {
                villain.setPath(eventpath);
            } catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("villain : " + villain);

            SuperHero hero = getHeroForVillain(villain);
            villain.registerObserver(hero);
            villain.notifyObservers();
        }



//        villain.notifyObservers(eventpath);
//        hero.update(villain, eventpath);
//        defeatVillain(eventpath);
//        removeFile(eventpath);
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

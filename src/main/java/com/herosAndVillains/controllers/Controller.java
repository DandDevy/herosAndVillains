package main.java.com.herosAndVillains.controllers;

import main.java.com.herosAndVillains.models.factories.heroFactories.GoodFlyPersonFactory;
import main.java.com.herosAndVillains.models.factories.heroFactories.GoodStrongManFactory;
import main.java.com.herosAndVillains.models.factories.villainFactories.BadFlyPersonFactory;
import main.java.com.herosAndVillains.models.factories.villainFactories.BadStrongManFactory;
import main.java.com.herosAndVillains.models.people.heroes.SuperHero;
import main.java.com.herosAndVillains.models.people.villains.BadFlyPerson;
import main.java.com.herosAndVillains.models.people.villains.BadStrongMan;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.sockets.ClientSocket;
import main.java.com.herosAndVillains.models.sockets.ServerSocketSingleton;
import main.java.com.herosAndVillains.models.threaded.ClientSocketWatcher;
import main.java.com.herosAndVillains.models.threaded.VillainGenerator;
import main.java.com.herosAndVillains.models.threaded.Watcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller {
    private static final String SERIALIZATION_LOCATION = "src\\common\\"; //reminder: C:\Users\Dashc\IdeaProjects\IdeaThirdYearProjects\distributedSystemProgramming\herosAndVillains\herosAndVillains\
    private static final String FOLDER = SERIALIZATION_LOCATION + "battle-zone-";
    private static final String SER_fILE_ENDING = ".ser";
    private static final boolean USE_SOCKETS = false;
    public static final String SERVER_ADDRESS = "localhost";
    public static final int SERVER_PORT = 8731;
    private static int battleFileNumber = 0;
    private static final boolean GENERATE_IN_THREAD = true;
    private static final boolean OBSERVE_IN_THREAD = true;
    private static ExecutorService observerExecutorService;
    private static ArrayList<Watcher> watchersInThreads = new ArrayList<>();
    private static ArrayList<Thread> threadsOfObservers = new ArrayList<>();
    private static ExecutorService villainGeneratorExecutorService;
    private static ArrayList<VillainGenerator> villainsGeneratorsInThreads = new ArrayList<>();


    /**
     * <p>adds a hero to the common folder.</p>
     * @param type
     * @param strength
     */
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

    /**
     * <p>Adds a villain to the common folder</p>
     * @param type
     * @param strength
     */
    public static void addVillain(String type, String strength) {
        SuperVillain villain = null;//PeopleFactory.getVillain(type, strength);
        if(type.equals("Strong")){

            villain = new BadStrongManFactory().getVillain(strength);
        } else if(type.equals("Fly")){
            villain = new BadFlyPersonFactory().getVillain(strength);
        }

        MySerializerController.serializeObject(villain, FOLDER + getBattleFileNumberUpdated() + SER_fILE_ENDING);
        System.out.println("controller.addVillain: "+ villain + " has been serialized");



        if (USE_SOCKETS){
            System.out.println("use sockets for add villain");
            ServerSocketSingleton myServerSocket = ServerSocketSingleton.getInstance();
            myServerSocket.openSocket();
            ObjectOutputStream objectOutputStream = myServerSocket.getObjectOutputStream();
            try {
                objectOutputStream.writeObject(villain);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <p>This will return the next battle zone number to use. It increments by 1 and is synchronised.</p>
     * @return
     */
    public static synchronized int getBattleFileNumberUpdated(){
        return battleFileNumber++;
    }

    /**
     * <p>starts a generator for a villain</p>
     * @param delay
     * @param type
     * @param strength
     */
    public static void generateVillain(int delay, String type, String strength) {
        if(GENERATE_IN_THREAD){

            VillainGenerator villainGenerator = new VillainGenerator(delay, type, strength);
            Thread villainGeneratingThread = new Thread(villainGenerator);
            villainGeneratingThread.start();
//            villainGeneratorExecutorService.execute(villainGeneratingThread);
            villainsGeneratorsInThreads.add(villainGenerator);


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

    /**
     * <p>Can observe in a thread if chosen, takes the delay at which we want to observe at</p>
     * @param delay
     */
    public static void observe(int delay) {

        if(OBSERVE_IN_THREAD) {

            if (USE_SOCKETS){
                ClientSocket clientSocket = new ClientSocket(SERVER_ADDRESS, SERVER_PORT);
                ClientSocketWatcher clientSocketWatcher = new ClientSocketWatcher(clientSocket, delay);
                Thread clientSocketWatcherThread = new Thread(clientSocketWatcher);
                clientSocketWatcherThread.start();


            } else {
                Watcher watcher = new Watcher(SERIALIZATION_LOCATION, delay);
                Thread observerThread = new Thread(watcher);
                watchersInThreads.add(watcher);
                threadsOfObservers.add(observerThread);
                observerThread.start();
//            observerExecutorService.execute(observerThread);
            }


        } else
            Watcher.watch(SERIALIZATION_LOCATION, delay);


    }

    /**
     * <p>gets a specific hero for a specific villain</p>
     * @param villain
     * @return
     */
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
            if(e instanceof ClassCastException)
                System.out.println("THAT WAS HERO");
            else
                e.printStackTrace();
        }

        return superVillain;
    }

    /**
     * <p>get villain from common folder</p>
     * @param eventpath
     * @return
     */
    public static SuperVillain getVillainWithFullPath(Path eventpath) {
        System.out.println("Controller.getVillain: SERIALIZATION_LOCATION + eventpath.toString():  " + eventpath.toString());
        SuperVillain superVillain = null;
        try {
            superVillain = (SuperVillain) MySerializerController.deSerializeObject(eventpath.toString());
            superVillain.setPathAsString(eventpath.toString());
        } catch (Exception e){
            if(e instanceof ClassCastException)
                System.out.println("THAT WAS HERO");
            else
                e.printStackTrace();
        }

        return superVillain;
    }


    /**
     * <p>handle a villain when is found in the common folder</p>
     * @param eventpath
     */
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


    /**
     * <p>destroys villain file.</p>
     * @param eventpath
     */
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
    /**
     * <p>destroys villain file.</p>
     * @param eventpath
     */
    public static void destroyVillainWithFullPath(Path eventpath) {
        // destroy file SERIALIZATION_LOCATION + eventpath.toString()
        File fileToDestroy = new File(eventpath.toString());
        if(fileToDestroy.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }

    /**
     * <p>stops villain generator threads</p>
     */
    public static void stopGenerations() {
        for (VillainGenerator villainGenerator : villainsGeneratorsInThreads)
            villainGenerator.terminate();
    }

    /**
     * <p>Stops watcher threads</p>
     */
    public static void stopObservations() {
        for(Watcher watcher : watchersInThreads) {
            watcher.terminate();
        }
//        watchersInThreads.clear();
//        for (Thread thread : threadsOfObservers) {
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        threadsOfObservers.clear();

        System.out.println("STOPPED OBSERVATIONS");
    }
}

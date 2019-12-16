package main.java.com.herosAndVillains.controllers;

import main.java.com.herosAndVillains.models.factories.villainFactories.BadFlyPersonFactory;
import main.java.com.herosAndVillains.models.factories.villainFactories.BadStrongManFactory;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.sockets.Server;
import main.java.com.herosAndVillains.models.threaded.VillainGenerator;

import java.util.ArrayList;

public class ServerSocketControllerForVillains {

    private static final String SERIALIZATION_LOCATION = "src\\common\\"; //reminder: C:\Users\Dashc\IdeaProjects\IdeaThirdYearProjects\distributedSystemProgramming\herosAndVillains\herosAndVillains\
    private static final String FOLDER = SERIALIZATION_LOCATION + "battle-zone-";
    private static final String SER_fILE_ENDING = ".ser";
    private static int battleFileNumber = 0;
    private static ArrayList<VillainGenerator> villainGenerators = new ArrayList<VillainGenerator>();

    public static void addVillain(String type, String strength) {
        SuperVillain villain = null;
        if(type.equals("Strong")){

            villain = new BadStrongManFactory().getVillain(strength);
        } else if(type.equals("Fly")){
            villain = new BadFlyPersonFactory().getVillain(strength);
        }
        String location = FOLDER + getBattleFileNumberUpdated() + SER_fILE_ENDING;
        MySerializerController.serializeObject(villain, location);
        System.out.println("ServerSocketControllerForVillains.addVillain: "+ villain + " has been serialized");

        Server server = Server.getInstance();
        new Thread(server).start();


//        ServerSocketSingleton serverSocket = ServerSocketSingleton.getInstance();
//        serverSocket.openSocket();
//
//        serverSocket.writeObject(villain);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        serverSocket.writeObject(villain);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        serverSocket.closeSocket();
//        serverSocket.closeServer();
    }
    public static synchronized int getBattleFileNumberUpdated(){
        return battleFileNumber++;
    }

    public static void generateVillain(int delay, String villainType, String strength) {
        VillainGenerator villainGenerator = new VillainGenerator(delay,villainType, strength,true);
        villainGenerators.add(villainGenerator);
        new Thread(villainGenerator).start();
    }

    public static void stopGenerations() {
        villainGenerators.forEach(villainGenerator -> villainGenerator.terminate());
        villainGenerators.clear();
    }

    public static void closeAll() {
        stopGenerations();
    }
}

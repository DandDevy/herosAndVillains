package main.java.com.herosAndVillains.controllers;

import main.java.com.herosAndVillains.models.factories.villainFactories.BadFlyPersonFactory;
import main.java.com.herosAndVillains.models.factories.villainFactories.BadStrongManFactory;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.sockets.ServerSocketSingleton;

public class ServerSocketControllerForVillains {

    private static final String SERIALIZATION_LOCATION = "src\\common\\"; //reminder: C:\Users\Dashc\IdeaProjects\IdeaThirdYearProjects\distributedSystemProgramming\herosAndVillains\herosAndVillains\
    private static final String FOLDER = SERIALIZATION_LOCATION + "battle-zone-";
    private static final String SER_fILE_ENDING = ".ser";
    private static int battleFileNumber = 0;

    public static void addVillain(String type, String strength) {
        SuperVillain villain = null;
        if(type.equals("Strong")){

            villain = new BadStrongManFactory().getVillain(strength);
        } else if(type.equals("Fly")){
            villain = new BadFlyPersonFactory().getVillain(strength);
        }

        MySerializerController.serializeObject(villain, FOLDER + getBattleFileNumberUpdated() + SER_fILE_ENDING);
        System.out.println("controller.addVillain: "+ villain + " has been serialized");
        ServerSocketSingleton serverSocket = ServerSocketSingleton.getInstance();
        serverSocket.openSocket();
    }
    public static synchronized int getBattleFileNumberUpdated(){
        return battleFileNumber++;
    }

    public static void generateVillain(int delay, String villainType, String text) {

    }

    public static void stopGenerations() {

    }

    public static void closeAll() {

    }
}

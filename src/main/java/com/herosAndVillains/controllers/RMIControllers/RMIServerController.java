package main.java.com.herosAndVillains.controllers.RMIControllers;

import main.java.com.herosAndVillains.controllers.MySerializerController;
import main.java.com.herosAndVillains.models.factories.villainFactories.BadFlyPersonFactory;
import main.java.com.herosAndVillains.models.factories.villainFactories.BadStrongManFactory;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.rmi.server.RMIServer;
import main.java.com.herosAndVillains.models.rmi.server.services.ObservableServant;
import main.java.com.herosAndVillains.models.threaded.VillainGenerator;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIServerController {
    private static final String SERIALIZATION_LOCATION = "src\\common\\";
    private static final String FOLDER = SERIALIZATION_LOCATION + "battle-zone-";
    private static final String SER_fILE_ENDING = ".ser";
    private static int battleFileNumber = 0;
    private static ArrayList<VillainGenerator> villainGenerators = new ArrayList<VillainGenerator>();

    public static void addVillain(String villainType, String strength) {
//        System.out.println("RMIServerController : addVillain");
        SuperVillain villain = null;
        if(villainType.equals("Strong")){

            villain = new BadStrongManFactory().getVillain(strength);
        } else if(villainType.equals("Fly")){
            villain = new BadFlyPersonFactory().getVillain(strength);
        }
        String location = FOLDER + getBattleFileNumberUpdated() + SER_fILE_ENDING;
        villain.setPathAsString(location);
        MySerializerController.serializeObject(villain, location);
        System.out.println("RMIServerController : addVillain: "+ villain + " has been serialized");



        try {
            RMIServer rmiServer = RMIServer.getInstance();
            ObservableServant observableServant = rmiServer.getObservableServant();
            if(villain!= null)
                observableServant.notifyObservers(villain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public static synchronized int getBattleFileNumberUpdated(){
        return battleFileNumber++;
    }


//    public static SuperVillain getVillain(){
//        SuperVillain resultingSuperVillain =null;
//        // gets a file
//        File folder = new File(SERIALIZATION_LOCATION);
//        File[] files = folder.listFiles();
//
//        if(files.length > 0){
//            File file = files[0];
//            resultingSuperVillain = Controller.getVillainWithFullPath(file.toPath());
//        }
//
//        return resultingSuperVillain;
//    }

    public static void generateVillain(int delay, String villainType, String strength) {
        System.out.println("RMIServerController : generateVillain");

        VillainGenerator villainGenerator = new VillainGenerator(delay,villainType, strength,false,true);
        villainGenerators.add(villainGenerator);
        new Thread(villainGenerator).start();
    }

    public static void stopGenerations() {
        System.out.println("RMIServerController : stopGenerations");
        villainGenerators.forEach(villainGenerator -> villainGenerator.terminate());
        villainGenerators.clear();
    }

    public static void closeAll() {
        System.out.println("RMIServerController : closeAll");
        stopGenerations();
    }
}

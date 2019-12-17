package main.java.com.herosAndVillains.models.rmi.server.services;

import main.java.com.herosAndVillains.controllers.Controller;
import main.java.com.herosAndVillains.controllers.MySerializerController;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces.ArrayListService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ArrayListServant extends UnicastRemoteObject implements ArrayListService {
    private static int battleFileNumber = 0;
    public ArrayListServant() throws RemoteException {
        super();
    }

    @Override
    public void processArrayList(ArrayList superPeople) throws RemoteException {
        System.out.println("ArrayListServant : processArrayList : superPeople=" + superPeople);

        if(superPeople!=null){
            String location = "src\\battlesWon\\battle-won-"+getBattleFileNumberUpdated()+".ser";
            MySerializerController.serializeObject(superPeople,location);
            System.out.println("ArrayListServant :processArrayList : battle won location " + location);
            superPeople.forEach(superPerson -> {
                if (superPerson instanceof SuperVillain) {
                    SuperVillain superVillain = (SuperVillain) superPerson;
                    Path pathToDestroy = Paths.get(superVillain.getPathAsString());
                    Controller.destroyVillainWithFullPath(pathToDestroy);
                }
            });
        }



    }

    /**
     * <p>This will return the next battle zone number to use. It increments by 1 and is synchronised.</p>
     * @return
     */
    public static synchronized int getBattleFileNumberUpdated(){
        return battleFileNumber++;
    }
}

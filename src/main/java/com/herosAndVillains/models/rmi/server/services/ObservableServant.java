package main.java.com.herosAndVillains.models.rmi.server.services;

import main.java.com.herosAndVillains.controllers.socketControllers.ServerController;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.rmi.clients.interfaces.RMIObserver;
import main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces.ObservableService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ObservableServant extends UnicastRemoteObject implements ObservableService {


    private ArrayList<RMIObserver> rmiObservers;
    public ObservableServant() throws RemoteException {
        super();
        rmiObservers = new ArrayList<RMIObserver>();
    }

    @Override
    public void register(RMIObserver rmiObserver) throws RemoteException {
//        System.out.println("ObservableServant : register : " + rmiObservers);
        rmiObservers.add(rmiObserver);
        System.out.println("ObservableServant : register : " + rmiObservers);
        SuperVillain superVillain = ServerController.getVillain();
        if(superVillain != null)
            notifyObservers(superVillain);
    }

    @Override
    public void notifyObservers(SuperVillain superVillain) throws RemoteException {
        System.out.println("ObservableServant : notifyObservers superVillain=" + superVillain);
        rmiObservers.forEach(rmiObserver -> {
            try {
                rmiObserver.update(superVillain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public String echo(String input) throws RemoteException {
        return "From server: " + input;
    }
}

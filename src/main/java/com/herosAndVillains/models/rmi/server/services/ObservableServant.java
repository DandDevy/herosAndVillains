package main.java.com.herosAndVillains.models.rmi.server.services;

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
        System.out.println("ObservableServant : register : " + rmiObservers);
        rmiObservers.add(rmiObserver);
//        System.out.println("ObservableServant : register : " + rmiObservers);
    }

    @Override
    public String echo(String input) throws RemoteException {
        return "From server: " + input;
    }
}

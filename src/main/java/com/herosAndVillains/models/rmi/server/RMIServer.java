package main.java.com.herosAndVillains.models.rmi.server;


import main.java.com.herosAndVillains.models.rmi.server.services.HelloServant;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    private static boolean createdServer = false;
    private static RMIServer rmiServer;

    public static RMIServer getInstance() throws RemoteException {
        if(!createdServer){
            createdServer = true;
            rmiServer = new RMIServer();
        }
        return rmiServer;
    }

    private RMIServer() throws RemoteException {
        System.out.println("starting RMI server ...");
        Registry registry = LocateRegistry.createRegistry(5099);
        registry.rebind("hello", new HelloServant());
    }
}

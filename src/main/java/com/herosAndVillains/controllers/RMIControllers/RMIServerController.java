package main.java.com.herosAndVillains.controllers.RMIControllers;

import main.java.com.herosAndVillains.models.rmi.server.RMIServer;

import java.rmi.RemoteException;

public class RMIServerController {
    public static void addVillain(String villainType, String strength) {
        System.out.println("RMIServerController : addVillain");
        try {
            RMIServer rmiServer = RMIServer.getInstance();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void generateVillain(int delay, String villainType, String strength) {
        System.out.println("RMIServerController : generateVillain");
    }

    public static void stopGenerations() {
        System.out.println("RMIServerController : stopGenerations");
    }

    public static void closeAll() {
        System.out.println("RMIServerController : closeAll");
    }
}

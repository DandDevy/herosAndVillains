package main.java.com.herosAndVillains.controllers.RMIControllers;

import main.java.com.herosAndVillains.models.rmi.clients.HelloClient;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClientController {
    public static void addHero(String heroType, String strength) {
        System.out.println("RMIClientController : addHero");

    }

    public static void observe() {
        System.out.println("RMIClientController : observe");
        try {
            new HelloClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void stopObservations() {
        System.out.println("RMIClientController : stopObservations");
    }

    public static void closeAll() {
        System.out.println("RMIClientController : closeAll");
    }
}

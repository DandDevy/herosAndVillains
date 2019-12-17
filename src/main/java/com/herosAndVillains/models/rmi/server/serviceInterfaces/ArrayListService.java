package main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ArrayListService extends Remote {
    public void processArrayList(ArrayList superPeople) throws RemoteException;
}

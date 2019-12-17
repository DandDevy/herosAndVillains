package main.java.com.herosAndVillains.models.rmi.clients.interfaces;

import main.java.com.herosAndVillains.models.people.villains.SuperVillain;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIObserver extends Remote {
    public void update(SuperVillain superVillain) throws RemoteException;
}

package main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces;

import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.rmi.clients.interfaces.RMIObserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObservableService extends Remote {
    public void register(RMIObserver rmiObserver) throws RemoteException;
    public void notifyObservers(SuperVillain superVillain) throws RemoteException;
    public String echo(String input) throws RemoteException;
}

package main.java.com.herosAndVillains.models.util;

import java.rmi.RemoteException;

public interface Observable {
    public void registerObserver(Observer observer) throws RemoteException;
    public void notifyObservers() throws RemoteException;
    public void removeObserver(Observer observer) throws RemoteException;
}

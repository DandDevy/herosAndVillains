package main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    public String echo(String input) throws RemoteException;
}

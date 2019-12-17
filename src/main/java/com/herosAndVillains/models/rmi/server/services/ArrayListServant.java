package main.java.com.herosAndVillains.models.rmi.server.services;

import main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces.ArrayListService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ArrayListServant extends UnicastRemoteObject implements ArrayListService {
    public ArrayListServant() throws RemoteException {
        super();
    }

    @Override
    public void processArrayList(ArrayList superPeople) throws RemoteException {
        System.out.println("ArrayListServant : processArrayList : superPeople=" + superPeople);

    }
}

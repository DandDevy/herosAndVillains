package main.java.com.herosAndVillains.models.rmi.clients;

import main.java.com.herosAndVillains.controllers.Controller;
import main.java.com.herosAndVillains.models.people.SuperPerson;
import main.java.com.herosAndVillains.models.people.heroes.SuperHero;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.rmi.clients.interfaces.RMIObserver;
import main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces.ArrayListService;
import main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces.ObservableService;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ObserverClient extends UnicastRemoteObject implements RMIObserver, Serializable, Runnable {
    public ObserverClient() throws RemoteException, NotBoundException, MalformedURLException {
        super();
        ObservableService observableService = (ObservableService) Naming.lookup("rmi://localhost:5099/observe");
        System.out.println("ObserverClient : observableService="+ observableService);
        System.out.println(observableService.echo("bablbla"));
        observableService.register(this);
    }

    @Override
    public void update(SuperVillain superVillain) throws RemoteException{
        System.out.println("ObserverClient : update : superVillain ="+ superVillain);
        if(superVillain!=null){
            SuperHero superHero = Controller.getHeroForVillain(superVillain);
            ArrayList<SuperPerson> superPeople = new ArrayList<>();
            superPeople.add(superHero);
            superPeople.add(superVillain);

            try {
                ArrayListService arrayListService = (ArrayListService) Naming.lookup("rmi://localhost:5099/arraylist");
                arrayListService.processArrayList(superPeople);

            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {

    }
}

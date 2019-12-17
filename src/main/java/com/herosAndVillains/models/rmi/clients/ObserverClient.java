package main.java.com.herosAndVillains.models.rmi.clients;

import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.rmi.clients.interfaces.RMIObserver;
import main.java.com.herosAndVillains.models.rmi.server.serviceInterfaces.ObservableService;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ObserverClient implements RMIObserver, Serializable {
    public ObserverClient() throws RemoteException, NotBoundException, MalformedURLException {
        ObservableService observableService = (ObservableService) Naming.lookup("rmi://localhost:5099/observe");
        System.out.println("ObserverClient : observableService="+ observableService);
        System.out.println(observableService.echo("bablbla"));
        observableService.register(this);
    }

    @Override
    public void update(SuperVillain superVillain) {
        System.out.println("ObserverClient : update : superVillain ="+ superVillain);
    }
}

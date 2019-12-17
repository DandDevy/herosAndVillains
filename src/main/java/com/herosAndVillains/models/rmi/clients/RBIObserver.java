package main.java.com.herosAndVillains.models.rmi.clients;

import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.rmi.clients.interfaces.RMIObserver;

import java.io.Serializable;

public class RBIObserver implements RMIObserver, Serializable {
    @Override
    public void update(SuperVillain superVillain) {
        System.out.println("RBIObserver : update : superVillain ="+ superVillain);
    }
}

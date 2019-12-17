package main.java.com.herosAndVillains.models.rmi.clients.interfaces;

import main.java.com.herosAndVillains.models.people.villains.SuperVillain;

public interface RMIObserver {
    public void update(SuperVillain superVillain);
}

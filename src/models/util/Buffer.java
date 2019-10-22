package models.util;


import models.people.villains.SuperVillain;

public interface Buffer {

    public void set(SuperVillain villain) throws InterruptedException;

    public SuperVillain get() throws InterruptedException;


}

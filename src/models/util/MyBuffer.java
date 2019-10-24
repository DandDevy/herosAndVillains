package models.util;


import models.people.villains.SuperVillain;

public interface MyBuffer {

    public void set(SuperVillain villain) throws InterruptedException;

    public SuperVillain get() throws InterruptedException;


}

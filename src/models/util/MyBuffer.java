package models.util;


import models.people.villains.SuperVillain;

/**
 * <h1>MyBuffer Interface</h1>
 */
public interface MyBuffer {

    /**
     * <p>Sets a villain in the buffer</p>
     * @param villain
     * @throws InterruptedException
     */
    public void set(SuperVillain villain) throws InterruptedException;

    /**
     * <p>Gets a villain from the buffer</p>
     * @return
     * @throws InterruptedException
     */
    public SuperVillain get() throws InterruptedException;


}

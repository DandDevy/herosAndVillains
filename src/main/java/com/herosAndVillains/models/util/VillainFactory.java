package main.java.com.herosAndVillains.models.util;

import main.java.com.herosAndVillains.models.people.villains.SuperVillain;

/**
 * <h1>VillainFactory</h1>
 * <p>VillainFactory is an interface for generating villains.</p>
 */
public interface VillainFactory {
    /**
     * <p>Gets a villain.</p>
     *
     * @return
     */
    SuperVillain getVillain(String strength);

}

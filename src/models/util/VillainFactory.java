package models.util;

import models.people.villains.SuperVillain;

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

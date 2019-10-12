package models.factories.villainFactories;

import models.people.villains.BadStrongMan;
import models.people.villains.SuperVillain;
import models.util.VillainFactory;

/**
 * <h1>BadStrongManFactory</h1>
 * <p>BadStrongManFactory implements VillainFactory.</p>
 */
public class BadStrongManFactory implements VillainFactory {
    /**
     * <p>gets a BadStrongMan SuperVillain.</p>
     * @param strength
     * @return
     */
    public SuperVillain getVillain(String strength) {
        return new BadStrongMan(strength);
    }
}

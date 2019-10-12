package models.factories.villainFactories;

import models.people.villains.BadFlyPerson;
import models.people.villains.SuperVillain;
import models.util.VillainFactory;
/**
 * <h1>BadFlyPersonFactory</h1>
 * <p>BadFlyPersonFactory implements VillainFactory.</p>
 */
public class BadFlyPersonFactory implements VillainFactory {
    /**
     * <p>gets a BadFlyPerson SuperVillain.</p>
     * @param strength
     * @return
     */
    public static SuperVillain getVillain(String strength) {
        return new BadFlyPerson(strength);
    }
}

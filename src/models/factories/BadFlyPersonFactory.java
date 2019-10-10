package models.factories;

import models.people.BadFlyPerson;
import models.people.SuperVillain;
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
    @Override
    public SuperVillain getVillain(String strength) {
        return new BadFlyPerson(strength);
    }
}

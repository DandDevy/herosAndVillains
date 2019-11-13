package main.java.com.herosAndVillains.models.factories.villainFactories;

import main.java.com.herosAndVillains.models.people.villains.BadFlyPerson;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.util.VillainFactory;
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
    public SuperVillain getVillain(String strength) {
        return new BadFlyPerson(strength);
    }
}

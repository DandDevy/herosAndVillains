package main.java.com.herosAndVillains.models.factories.villainFactories;

import main.java.com.herosAndVillains.models.people.villains.BadStrongMan;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.util.VillainFactory;

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

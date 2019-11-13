package main.java.com.herosAndVillains.models.factories.heroFactories;

import main.java.com.herosAndVillains.models.people.heroes.GoodFlyPerson;
import main.java.com.herosAndVillains.models.people.heroes.SuperHero;
import main.java.com.herosAndVillains.models.util.HeroFactory;
/**
 * <h1>GoodFlyPersonFactory</h1>
 * <p>GoodFlyPersonFactory implements HeroFactory.</p>
 */
public class GoodFlyPersonFactory implements HeroFactory {
    /**
     * <p>gets a GoodFlyPerson SuperHero.</p>
     * @param strength
     * @return
     */
    public SuperHero getHero(String strength) {
        return new GoodFlyPerson(strength);
    }
}

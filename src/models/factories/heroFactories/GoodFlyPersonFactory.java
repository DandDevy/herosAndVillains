package models.factories.heroFactories;

import models.people.heroes.GoodFlyPerson;
import models.people.heroes.SuperHero;
import models.util.HeroFactory;
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
    public static SuperHero getHero(String strength) {
        return new GoodFlyPerson(strength);
    }
}

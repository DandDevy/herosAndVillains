package models.factories;

import models.people.GoodFlyPerson;
import models.people.SuperHero;
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
    @Override
    public SuperHero getHero(String strength) {
        return new GoodFlyPerson(strength);
    }
}

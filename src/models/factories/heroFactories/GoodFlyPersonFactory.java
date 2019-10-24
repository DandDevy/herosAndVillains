package models.factories.heroFactories;

import models.people.heroes.GoodFlyPerson;
import models.people.heroes.SuperHero;
import models.util.HeroFactory;
import models.util.MyBuffer;

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
    public SuperHero getHero(String strength, MyBuffer myBuffer) {
        return new GoodFlyPerson(strength, myBuffer);
    }
}

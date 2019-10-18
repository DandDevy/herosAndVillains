package models.factories.heroFactories;

import models.people.heroes.GoodStrongMan;
import models.people.heroes.SuperHero;
import models.util.HeroFactory;

/**
 * <h1>GoodStrongManFactory</h1>
 * <p>GoodStrongManFactory implements HeroFactory</p>
 */
public class GoodStrongManFactory implements HeroFactory {

    /**
     * <p>get a GoodStrongMan SuperHero</p>
     * @param strength
     */
    public SuperHero getHero(String strength) {
        return new GoodStrongMan(strength);
    }
}

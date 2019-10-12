package models.factories;

import models.people.GoodStrongMan;
import models.people.SuperHero;
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
    public static SuperHero getHero(String strength) {
        return new GoodStrongMan(strength);
    }
}

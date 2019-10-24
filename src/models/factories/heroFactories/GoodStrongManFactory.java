package models.factories.heroFactories;

import models.people.heroes.GoodStrongMan;
import models.people.heroes.SuperHero;
import models.util.HeroFactory;
import models.util.MyBuffer;

/**
 * <h1>GoodStrongManFactory</h1>
 * <p>GoodStrongManFactory implements HeroFactory</p>
 */
public class GoodStrongManFactory implements HeroFactory {

    /**
     * <p>get a GoodStrongMan SuperHero</p>
     * @param strength
     */
    public SuperHero getHero(String strength, MyBuffer myBuffer) {
        return new GoodStrongMan(strength, myBuffer);
    }
}

package main.java.com.herosAndVillains.models.factories.heroFactories;

import main.java.com.herosAndVillains.models.people.heroes.GoodStrongMan;
import main.java.com.herosAndVillains.models.people.heroes.SuperHero;
import main.java.com.herosAndVillains.models.util.HeroFactory;

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

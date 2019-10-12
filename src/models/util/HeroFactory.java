package models.util;

import models.people.SuperHero;

/**
 * <h1>HeroFactory</h1>
 * <p>HeroFactory is an interface for generating heroes.</p>
 */
public interface HeroFactory {
    /**
     * <p>Gets a hero.</p>
     * @return
     */
    public static SuperHero getHero(String strength) {
        return new SuperHero(strength);
    }
}

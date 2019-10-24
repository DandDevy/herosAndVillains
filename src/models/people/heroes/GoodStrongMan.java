package models.people.heroes;

import models.util.MyBuffer;

/**
 * <h1>GoodStrongMan</h1>
 * <p>A class extending from hero</p>
 */
public class GoodStrongMan extends SuperHero{
    /**
     * <p>You need a type and strength for a SuperHero</p>
     * @param strength
     */
    public GoodStrongMan(String strength, MyBuffer myBuffer) {
        super(strength, myBuffer);
    }

    @Override
    public String toString() {
        return "GoodStrongMan{} is a" + super.toString();
    }
}

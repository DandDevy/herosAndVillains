package models.people.heroes;

import models.util.MyBuffer;

/**
 * <h1>GoodFlyPerson</h1>
 * <p>A class extending from hero</p>
 */
public class GoodFlyPerson extends SuperHero{
    /**
     * <p>You need a strength for a SuperHero</p>

     * @param strength
     */
    public GoodFlyPerson(String strength, MyBuffer myBuffer) {
        super(strength, myBuffer);
    }

    @Override
    public String toString() {
        return "GoodFlyPerson{} is a" + super.toString();
    }
}

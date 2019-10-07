package models.people;

/**
 * <h1>BadFlyPerson</h1>
 * <p>A class extending from Villain.</p>
 */
public class BadFlyPerson extends SuperVillain{
    /**
     * <p>You need a type and strength for a villain</p>
     *
     * @param type
     * @param strength
     */
    public BadFlyPerson(String type, String strength) {
        super(type, strength);
    }
}

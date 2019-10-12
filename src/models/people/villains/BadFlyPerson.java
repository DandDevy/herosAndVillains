package models.people.villains;

/**
 * <h1>BadFlyPerson</h1>
 * <p>A class extending from Villain.</p>
 */
public class BadFlyPerson extends SuperVillain{
    /**
     * <p>You need strength for a villain</p>
     * @param strength
     */
    public BadFlyPerson(String strength) {
        super( strength);
    }

    @Override
    public String toString() {
        return "BadFlyPerson{} is a "  + super.toString();
    }
}

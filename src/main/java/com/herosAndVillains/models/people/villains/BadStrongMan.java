package main.java.com.herosAndVillains.models.people.villains;

/**
 * <h1>BadStongMan</h1>
 * <p>A class extending from Villain.</p>
 */
public class BadStrongMan extends SuperVillain{
    /**
     * <p>You need strength for a villain</p>
     * @param strength
     */
    public BadStrongMan( String strength) {
        super(strength);
    }

    @Override
    public String toString() {
        return "BadStrongMan{} is a " + super.toString();
    }
}

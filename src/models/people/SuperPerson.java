package models.people;

/**
 * <h1>SuperPerson interface</h1>
 *
 * The SuperPerson interface is the ensure that super heroes and super villains have types and strengths
 */
public interface SuperPerson extends Person{

    /**
     * <p>get the type of the SuperPerson.</p>
     * @return String type
     */
    String getType();

    /**
     * <p>Set the type of the SuperPerson</p>
     * @param String type
     */
    void setType(String type);


    /**
     * <p>Get the strength of the SuperPerson</p>
     * @return String strength
     */
    String getStrength();

    /**
     * Set the strength of the SuperPerson
     * @param String strength
     */
    void setStrength(String strength);
}

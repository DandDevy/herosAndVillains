package models.people;

/**
 * <h1>SuperPerson interface</h1>
 *
 * The SuperPerson interface is the ensure that super heroes and super villains have types and strengths
 */
public interface SuperPerson {
    String getType();

    void setType(String type);


    String getStrength();

    void setStrength(String strength);
}

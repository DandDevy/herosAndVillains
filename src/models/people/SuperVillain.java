package models.people;

import java.util.Observer;

public interface SuperVillain extends Observer {

    String getType();

    void setType(String type);


    String getStrength();

    void setStrength(String strength);


    void update(SuperPerson<Observer> villain);

}

package test.java.heroesAndVillains;

import main.java.com.herosAndVillains.controllers.Controller;
import main.java.com.herosAndVillains.models.people.heroes.GoodStrongMan;
import main.java.com.herosAndVillains.models.people.heroes.SuperHero;
import main.java.com.herosAndVillains.models.people.villains.BadStrongMan;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import org.junit.jupiter.api.BeforeEach;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void addHero() {
        Controller.addHero("Strong", "asd");
    }

    @org.junit.jupiter.api.Test
    void addVillain() {
        Controller.addVillain("Strong", "bold");
    }

    @org.junit.jupiter.api.Test
    void getBattleFileNumberUpdated() {
    }

    @org.junit.jupiter.api.Test
    void generateVillain() {
    }

    @org.junit.jupiter.api.Test
    void observe() {
        Controller.observe(1);
    }

    @org.junit.jupiter.api.Test
    void getHeroForVillain() {
        SuperHero goodStrongMan = Controller.getHeroForVillain(new BadStrongMan("asd"));
    }


    @org.junit.jupiter.api.Test
    void dealWithVillain() {
    }

    @org.junit.jupiter.api.Test
    void destroyVillain() {
    }

    @org.junit.jupiter.api.Test
    void stopGenerations() {
    }

    @org.junit.jupiter.api.Test
    void stopObservations() {
    }
}
package controllers;

import models.people.SuperHero;
import models.people.SuperPerson;

import java.io.*;

public class MySerializerController {
    private static final String SERIALIZATION_LOCATION = "C:\\Users\\Dashc\\IdeaProjects\\IdeaThirdYearProjects\\distributedSystemProgramming\\herosAndVillains\\herosAndVillains\\src\\common\\";

    /**
     * Serializes a SuperPerson<SuperHero> hero
     * @param hero
     */
    public static void serializeHero(SuperPerson<SuperHero> hero) {
        try {
            FileOutputStream fileOut = new FileOutputStream(SERIALIZATION_LOCATION + "battle-zone-1.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(hero);
            out.close();
            fileOut.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public  static SuperPerson<SuperHero> deSerializeHero(){
        SuperPerson<SuperHero> hero = null;
        try {
            FileInputStream fileIn = new FileInputStream(SERIALIZATION_LOCATION + "battle-zone-1.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Serializable o = (Serializable) in.readObject();
            System.out.println("what is inside my serialized file: \n"+o);

            SuperPerson<SuperHero> test = (SuperPerson<SuperHero>) o;

            hero = test;

            in.close();
            fileIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("what list is inside my deserialized file: \n"+hero);

        return hero;
    }


}

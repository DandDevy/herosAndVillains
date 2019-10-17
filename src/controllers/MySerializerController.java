package controllers;

import models.people.heroes.SuperHero;

import java.io.*;
import java.util.ArrayList;

public class MySerializerController {
    private static final String SERIALIZATION_LOCATION = "C:\\Users\\Dashc\\IdeaProjects\\IdeaThirdYearProjects\\distributedSystemProgramming\\herosAndVillains\\herosAndVillains\\src\\common\\";

    /**
     * Serializes a SuperHero
     * @param hero
     */
    public static void serializeHero(SuperHero hero) {
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

    /**
     * Deserialize a  SuperHero hero
     * @return SuperHero hero
     */
    public  static SuperHero deSerializeHero(){
        SuperHero hero = null;
        try {
            FileInputStream fileIn = new FileInputStream(SERIALIZATION_LOCATION + "battle-zone-1.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Serializable o = (Serializable) in.readObject();
            System.out.println("what is inside my serialized file: \n"+o);

            SuperHero test = (SuperHero) o;

            hero = test;

            in.close();
            fileIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("what list is inside my deserialized file: \n"+hero);

        return hero;
    }

    /**
     * Serializes an Object objecta
     * @param object
     */
    public synchronized static void serializeObject(Object object, String location) {
        try {
            FileOutputStream fileOut = new FileOutputStream(location);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Deserialize a  Object object
     * @return Object object
     */
    public synchronized static Object deSerializeObject(String location){
        Object object = null;
        try {
            FileInputStream fileIn = new FileInputStream(location);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Serializable o = (Serializable) in.readObject();

            Object test = (Object) o;

            object = test;

            in.close();
            fileIn.close();

        } catch (Exception e) {
            if (e instanceof FileNotFoundException)
                System.out.println("File not found because watcher has already deleted + " + location);

            else
                e.printStackTrace();
        }

        System.out.println("what list is inside my deserialized file: \n" + object);

        return object;
    }

    /**
     * Serializes an ArrayList<Object> objects
     * @param objects
     */
    public static void serializeObjects(ArrayList<Object> objects, String location) {
        try {
            FileOutputStream fileOut = new FileOutputStream(location);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objects);
            out.close();
            fileOut.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Deserialize a  ArrayList<Object> objects
     * @return objects
     */
    public static ArrayList<Object> deSerializeObjects(String location){
        ArrayList<Object> objects = new ArrayList<Object>();
        try {
            FileInputStream fileIn = new FileInputStream(location);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Serializable o = (Serializable) in.readObject();
            System.out.println("what is inside my serialized file: \n"+o);

            ArrayList<Object> test = (ArrayList<Object>) o;

            objects = test;

            in.close();
            fileIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("what list is inside my deserialized file: \n" + objects);

        return objects;
    }

}

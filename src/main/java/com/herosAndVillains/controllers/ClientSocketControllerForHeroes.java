package main.java.com.herosAndVillains.controllers;

import main.java.com.herosAndVillains.models.sockets.Client;
import main.java.com.herosAndVillains.models.sockets.ClientSocket;
import main.java.com.herosAndVillains.models.sockets.ServerSocketSingleton;

import java.io.EOFException;
import java.io.ObjectInputStream;


public class ClientSocketControllerForHeroes {
    public static void addHero(String heroType, String text) {

    }

    public static void observe(){
        Client client = new Client();
        new Thread(client).start();
    }

    public static void observe(int delay) {
        ClientSocket clientSocket = new ClientSocket("localhost", ServerSocketSingleton.getServerPort());
        Object object = null;
//        while (object == null)
//            object = clientSocket.readObject();


        ObjectInputStream objectInputStream= null;
        try {
            objectInputStream = clientSocket.getObjectInputStream();
        } catch (EOFException e) {
            e.printStackTrace();
        }
        while (object == null) {
            try {
                object = objectInputStream.read();
            }catch (Exception ignored){

            }

        }

        System.out.println("object: "+object);
        clientSocket.close();
        clientSocket.readObject();
//        while (true){
//
//        }
    }

    public static void stopObservations() {

    }

    public static void closeAll() {

    }
}

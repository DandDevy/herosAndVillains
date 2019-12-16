package main.java.com.herosAndVillains.models.sockets;

import main.java.com.herosAndVillains.controllers.ClientController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable{
    private static final String HOST = "localhost";

    public Client() {
//        Socket socket = null;
//        try {
//            socket = new Socket(HOST, 8002);
//
//            // Create an output stream to the server
//            ObjectOutputStream toServer =
//                    new ObjectOutputStream(socket.getOutputStream());
//
//            toServer.writeObject("requesting villain");
//            Object object = null;
//            while (object == null){
//                ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
//                object = fromServer.readObject();
//
//            }
//            System.out.println("object = "+object);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket(HOST, 8002);

            // Create an output stream to the server
            ObjectOutputStream toServer =
                    new ObjectOutputStream(socket.getOutputStream());

            toServer.writeObject("requesting villain");
            Object object = null;
            while (object == null){
                ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
                object = fromServer.readObject();
            }
            System.out.println("object = "+object);
            ArrayList arrayList = ClientController.lookup(object);
            toServer.writeObject(arrayList);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

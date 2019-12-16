package main.java.com.herosAndVillains.models.sockets;

import main.java.com.herosAndVillains.controllers.ServerController;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private static final int PORT_NUMBER = 8002;
    private boolean serverAlreadyInUse = false;
    private ObjectInputStream inputFromClient;
    private static boolean initialised = false;
    private static Server server;

    public static Server getInstance(){
        if (initialised){
            return server;
        } else {
            initialised = true;
            return new Server();
        }
    }

    private Server(){
//        try {
//            // Create a server socket
//            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
//            System.out.println("Server started ");
//
//
//            while (true) {
//                // Listen for a new connection request
//                Socket socket = serverSocket.accept();
//
//                // Create an input stream from the socket
//                inputFromClient =
//                        new ObjectInputStream(socket.getInputStream());
//
//                // Read from input
//                Object object = inputFromClient.readObject();
//
//                // Write to the file
//                if(object != null) {
//                    SuperVillain resultingSuperVillain = ServerController.lookup(object);
//                    if(resultingSuperVillain != null) {
//                        ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
//                        System.out.println("writing back");
//                        outputToClient.writeObject(resultingSuperVillain);
//                    }
//                }
//
//                else
//                    System.out.println("Server: nothing found..  object="+object);
//            }
//        }
//        catch(ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        catch(IOException ex) {
//            ex.printStackTrace();
//        }
//        finally {
//            try {
//                inputFromClient.close();
//            }
//            catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
    }

    @Override
    public void run() {
        if(!serverAlreadyInUse){
            serverAlreadyInUse = true;
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
                System.out.println("Server started ");


                while (true) {
                    // Listen for a new connection request
                    Socket socket = serverSocket.accept();

                    // Create an input stream from the socket
                    inputFromClient =
                            new ObjectInputStream(socket.getInputStream());

                    // Read from input
                    Object object = inputFromClient.readObject();

                    // Write to the file
                    if(object != null) {
//                        ArrayList<SuperPerson> resultingSuperPeople = ServerController.lookup(object);
                        Object resultingObject = ServerController.lookup(object);
                        if(resultingObject != null) {
                            ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
                            System.out.println("writing back");
                            outputToClient.writeObject(resultingObject);
                        }
                    }

                    else
                        System.out.println("Server: nothing found..  object="+object);
                }
            }
            catch(ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    inputFromClient.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

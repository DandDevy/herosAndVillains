package main.java.com.herosAndVillains.models.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketSingleton {
    private static final int SERVER_PORT = 8753;
    private static ServerSocketSingleton serverSocketSingleton;

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private static boolean serverInitialised = false;
    private  boolean isSocketClosed = true;

    private ServerSocketSingleton(int port){

        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static ServerSocketSingleton getInstance(){
        if (serverInitialised)
            return serverSocketSingleton;

        else {
            serverSocketSingleton = new ServerSocketSingleton(SERVER_PORT);
            serverInitialised = true;
            return serverSocketSingleton;
        }
    }

    public void openSocket() {
        if(isSocketClosed){
            try {
                socket = server.accept();
                isSocketClosed = false;
                System.out.println("Client accepted");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ObjectInputStream getObjectInputStream(){
        ObjectInputStream resultingDataStream = null;
        if(!isSocketClosed) {
            try {
                resultingDataStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultingDataStream;
    }

    public ObjectOutputStream getObjectOutputStream(){
        ObjectOutputStream resultingDataOutputSteam = null;
        if(!isSocketClosed){
            try {
                resultingDataOutputSteam = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultingDataOutputSteam;
    }

    public void closeSocket(){
        try {
            socket.close();
            isSocketClosed = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeServer(){
        try {
            server.close();
            serverInitialised = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObject(Object object){
        ObjectOutputStream objectOutputStream = getObjectOutputStream();
        try {
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

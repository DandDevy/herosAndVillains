package main.java.com.herosAndVillains.models.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketSingleton {


    /**
     * <p>SERVER_PORT = 8753</p>
     */
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


    /**
     * <p>Get instance of ServerSocketSingleton.</p>
     * @return ServerSocketSingleton
     */
    public static ServerSocketSingleton getInstance(){
        if (serverInitialised)
            return serverSocketSingleton;

        else {
            serverSocketSingleton = new ServerSocketSingleton(SERVER_PORT);
            serverInitialised = true;
            return serverSocketSingleton;
        }
    }

    /**
     * <p>Open a Socket and accept client on this server. Returns a boolean of if the socket was already opened. Only 1 allowed.</p>
     * @return boolean isSocketClosed
     */
    public boolean openSocket() {
        boolean res = isSocketClosed;
        if(isSocketClosed){
            try {
                socket = server.accept();
                isSocketClosed = false;
                System.out.println("Client accepted");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ServerSocketSingleton: a socket is already in use");
        }
        return res;
    }

    /**
     * <p>Get an ObjectInputStream to use on the socket on this server.</p>
     * @return ObjectInputStream
     */
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

    /**
     * <p>Get an ObjectOutputStream to use on the socket on this server.</p>
     * @return ObjectOutputStream
     */
    public ObjectOutputStream getObjectOutputStream(){
        ObjectOutputStream resultingDataOutputSteam = null;
        if(!isSocketClosed){
            try {
                resultingDataOutputSteam = new ObjectOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ServerSocketSingleton: Socket hasn't been opened yet!");
        }
        return resultingDataOutputSteam;
    }

    /**
     * <p>Close the socket on this port.</p>
     */
    public void closeSocket(){
        try {
            socket.close();
            isSocketClosed = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Close the server and release the port.</p>
     */
    public void closeServer(){
        try {
            server.close();
            serverInitialised = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Write an object to the socket.</p>
     * @param object
     */
    public void writeObject(Object object){
        if(!isSocketClosed) {
            ObjectOutputStream objectOutputStream = getObjectOutputStream();
            try {
                objectOutputStream.writeObject(object);
                System.out.println("ServerSocketSingleton.writeObject : " + object + " written to socket");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <p>Read an object from the socket.</p>
     * @return
     */
    public Object readObject(){
        Object object = null;
        if(!isSocketClosed) {
            ObjectInputStream objectOutputStream = getObjectInputStream();
            try {
                object = objectOutputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    /**
     * returns an int of the server port.
     * @return SERVER_PORT
     */
    public static int getServerPort() {
        return SERVER_PORT;
    }
}

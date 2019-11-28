package main.java.com.herosAndVillains.models.sockets;

import java.io.*;
import java.net.Socket;
import java.lang.Object;

public class ClientSocket {
    private Socket socket = null;
    private ObjectInputStream input = null;
    private ObjectOutputStream out = null;

    /**
     * <p>ClientSocket takes a String address and an int port. Creates a socket that can be take inputs and outputs.</p>
     * @param address
     * @param port
     */
    public ClientSocket(String address, int port) {

        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input  = new ObjectInputStream(System.in);

            // sends output to the socket
            out    = new ObjectOutputStream(socket.getOutputStream());
        } catch(IOException u)
        {
            System.out.println(u);
        }
    }

    /**
     * <p>write an object to the socket.</p>
     * @param object
     */
    public synchronized void writeObject(Object object){
        try {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Returns an object from the socket.</p>
     * @return Object output
     */
    public synchronized Object readObject(){
        try {
            return input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

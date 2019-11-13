package models.sockets;

import java.io.*;
import java.net.Socket;
import java.lang.Object;
import java.net.UnknownHostException;

public class ClientSocket {
    private Socket socket = null;
    private ObjectInputStream input = null;
    private ObjectOutputStream out = null;

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

    public synchronized void writeObject(Object object){
        try {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

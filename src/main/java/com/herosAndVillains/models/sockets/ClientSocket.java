package main.java.com.herosAndVillains.models.sockets;

import java.io.*;
import java.net.Socket;
import java.lang.Object;

public class ClientSocket {
    private Socket socket = null;
    private boolean isSocketOpen = false;

    /**
     * <p>ClientSocket takes a String address and an int port. Creates a socket that can be take inputs and outputs.</p>
     * @param address
     * @param port
     */
    public ClientSocket(String address, int port) {

        try
        {
            socket = new Socket(address, port);
            isSocketOpen = true;
            System.out.println("Connected");

            // takes input from terminal
//            input  = new ObjectInputStream(System.in);
        } catch(IOException u)
        {
            System.out.println(u);
        }
    }

    /**
     * <p>Close the socket</p>
     */
    public void close(){
        try {
            socket.close();
            isSocketOpen = false;
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Get an ObjectInputStream to use on the socket on this client.</p>
     * @return ObjectInputStream
     */
    public ObjectInputStream getObjectInputStream() throws EOFException{
        ObjectInputStream resultingDataStream = null;
        if(isSocketOpen) {
            try {
                InputStream in = socket.getInputStream();
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
                resultingDataStream = new ObjectInputStream(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultingDataStream;
    }

    /**
     * <p>Get an ObjectOutputStream to use on the socket on this client.</p>
     * @return ObjectOutputStream
     */
    public ObjectOutputStream getObjectOutputStream(){
        ObjectOutputStream resultingDataOutputSteam = null;
        if(isSocketOpen){
            try {
                OutputStream out = socket.getOutputStream();
                resultingDataOutputSteam = new ObjectOutputStream(out);
//                resultingDataOutputSteam = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ClientSocket: Socket hasn't been opened yet!");
        }
        return resultingDataOutputSteam;
    }

    /**
     * <p>write an object to the socket.</p>
     * @param object
     */
    public synchronized void writeObject(Object object){
        if(isSocketOpen) {
            ObjectOutputStream objectOutputStream = getObjectOutputStream();
            try {
                objectOutputStream.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <p>Returns an object from the socket.</p>
     * @return Object output
     */
    public synchronized Object readObject(){
        Object object = null;
        if(isSocketOpen) {
            try {
                ObjectInputStream objectOutputStream = getObjectInputStream();
                object = objectOutputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {

                System.out.println("ClientSocket :readObject NullPointerException ");
            }
        }
        return object;
    }
}

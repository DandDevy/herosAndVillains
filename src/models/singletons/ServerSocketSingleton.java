package models.singletons;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketSingleton {
    public static final int PORT = 8731;
    private static ServerSocketSingleton serverSocketSingleton = new ServerSocketSingleton(PORT);

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;
    private static boolean classInitialed = false;
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
        return serverSocketSingleton;
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

    public DataInputStream getDataInputStream(){
        DataInputStream resultingDataStream = null;
        if(!isSocketClosed) {
            try {
                resultingDataStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultingDataStream;
    }

    public DataOutputStream getDataOutputStream(){
        DataOutputStream resultingDataOutputSteam = null;
        if(!isSocketClosed){
            try {
                resultingDataOutputSteam = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
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
}

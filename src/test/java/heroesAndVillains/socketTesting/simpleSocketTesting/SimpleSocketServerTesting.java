package test.java.heroesAndVillains.socketTesting.simpleSocketTesting;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServerTesting {

    @Test
    void simpleServerSocketTesting(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7511);
            serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    void simpleServerSocketTransferTesting(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7515);
            Socket socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                line = in.readUTF();
                System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
}

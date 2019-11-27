package test.java.heroesAndVillains.socketTesting.simpleSocketTesting;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketTesting {

    @Test
    void simpleSocketTest(){
        try {

            Socket socket = new Socket("localhost",7513);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void simpleSocketTransferTest(){
        try {

            Socket socket = new Socket("localhost",7515);
            DataInputStream input  = new DataInputStream(System.in);

            // sends output to the socket
            DataOutputStream out    = new DataOutputStream(socket.getOutputStream());

            String line = "";

            // keep reading until "Over" is input
            while (!line.equals("Over"))
            {
                try
                {
                    line = input.readLine();
                    out.writeUTF(line);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }

            // close the connection
            try
            {
                input.close();
                out.close();
                socket.close();
            }catch(IOException i)
            {
                System.out.println(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

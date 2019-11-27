package test.java.heroesAndVillains.socketTesting.mySocketTesting;

import main.java.com.herosAndVillains.models.sockets.ClientSocket;
import main.java.com.herosAndVillains.models.sockets.ServerSocketSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientSocketTest {

    @BeforeEach
    void setUp() {
        ServerSocketSingleton serverSocketSingleton = ServerSocketSingleton.getInstance();
        serverSocketSingleton.openSocket();
        serverSocketSingleton.writeObject(new String("asd"));
    }

    @AfterEach
    void closeUp(){
        ServerSocketSingleton serverSocketSingleton = ServerSocketSingleton.getInstance();
        serverSocketSingleton.closeSocket();
    }

    @Test
    void writeObject() {

        ClientSocket clientSocket = new ClientSocket("localhost", 9913);
        clientSocket.readObject();
    }

    @Test
    void writeNumber() {
        ClientSocket clientSocket = new ClientSocket("localhost", 9913);
    }

    @Test
    void readObject() {
    }
}
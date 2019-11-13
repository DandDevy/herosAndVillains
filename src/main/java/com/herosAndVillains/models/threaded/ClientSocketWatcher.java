package main.java.com.herosAndVillains.models.threaded;

import main.java.com.herosAndVillains.models.people.villains.SuperVillain;
import main.java.com.herosAndVillains.models.sockets.ClientSocket;

public class ClientSocketWatcher implements Runnable{
    private ClientSocket socket;
    private int delay;

    public ClientSocketWatcher(ClientSocket socket, int delay) {
        this.socket = socket;
        this.delay = delay;
    }

    @Override
    public void run() throws NullPointerException{
        while (true){

            Object object = socket.readObject();
            System.out.println("clients sockets: " + object);
            if(object instanceof SuperVillain){
                System.out.println("VILLAIN FOUND");
            }
        }
    }
}

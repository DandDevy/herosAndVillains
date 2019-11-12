package models.threaded;

import java.net.Socket;

public class SocketWatcher {
    private Socket socket;

    public SocketWatcher(Socket socket) {
        this.socket = socket;
    }
}

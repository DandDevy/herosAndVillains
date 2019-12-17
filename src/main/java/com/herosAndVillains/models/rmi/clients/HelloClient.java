package main.java.com.herosAndVillains.models.rmi.clients;


import main.java.com.herosAndVillains.models.rmi.server.services.HelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {
    public HelloClient() throws RemoteException, NotBoundException, MalformedURLException {
        HelloService service = (HelloService) Naming.lookup("rmi://localhost:5099/hello");
        System.out.println("----- " + service.echo("hey server"));
    }
}

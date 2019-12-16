package main.java.com.herosAndVillains.controllers;

import main.java.com.herosAndVillains.models.people.villains.SuperVillain;

public class ServerController {
    public static SuperVillain lookup(Object object) {
        SuperVillain resultingSuperVillain = null;
        System.out.println("ServerController : lookup : object :" + object);

        if (object instanceof String){
            String clientRequest = (String) object;

            if (clientRequest.equals("requesting villain")){

                // does some serialisation stuff

                resultingSuperVillain = new SuperVillain("");
            }
        }

        return resultingSuperVillain;
    }
}

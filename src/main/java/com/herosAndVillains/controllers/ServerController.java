package main.java.com.herosAndVillains.controllers;

import main.java.com.herosAndVillains.models.people.SuperPerson;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;

import java.io.File;
import java.util.ArrayList;



public class ServerController {
    private static final String SERIALIZATION_LOCATION = "src\\common\\";
    public static Object lookup(Object object) {
        Object resultingObject = null;
        System.out.println("ServerController : lookup : object :" + object);

        if (object instanceof String){
            String clientRequest = (String) object;

            if (clientRequest.equals("requesting villain")){
                object = (Object) getVillain();
            }
        } else if (object instanceof ArrayList){
            ArrayList<SuperPerson> resultingSuperPeople = (ArrayList) object;
            System.out.println("ServerController: resultingSuperPeople" + resultingSuperPeople);
        }



        return object;
    }

    private static SuperVillain getVillain(){
        SuperVillain resultingSuperVillain =null;
        // gets a file
        File folder = new File(SERIALIZATION_LOCATION);
        File[] files = folder.listFiles();

        if(files.length > 0){
            File file = files[0];
            resultingSuperVillain = Controller.getVillainWithFullPath(file.toPath());
        }

        return resultingSuperVillain;
    }
}

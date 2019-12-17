package main.java.com.herosAndVillains.controllers.socketControllers;

import main.java.com.herosAndVillains.controllers.Controller;
import main.java.com.herosAndVillains.controllers.MySerializerController;
import main.java.com.herosAndVillains.models.people.SuperPerson;
import main.java.com.herosAndVillains.models.people.villains.SuperVillain;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;



public class ServerController {
    private static final String SERIALIZATION_LOCATION = "src\\common\\";
    private static int battleFileNumber = 0;
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
            String location = "src\\battlesWon\\battle-won-"+getBattleFileNumberUpdated()+".ser";
            MySerializerController.serializeObject(resultingObject,location);
            System.out.println("ServerController : battle won localtion " + location);
            resultingSuperPeople.forEach(superPerson -> {
                if (superPerson instanceof SuperVillain) {
                    SuperVillain superVillain = (SuperVillain) superPerson;
                    Path pathToDestroy = Paths.get(superVillain.getPathAsString());
                    Controller.destroyVillainWithFullPath(pathToDestroy);
                }
            });
        }



        return object;
    }
    /**
     * <p>This will return the next battle zone number to use. It increments by 1 and is synchronised.</p>
     * @return
     */
    public static synchronized int getBattleFileNumberUpdated(){
        return battleFileNumber++;
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

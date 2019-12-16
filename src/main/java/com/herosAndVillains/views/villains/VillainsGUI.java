package main.java.com.herosAndVillains.views.villains;

import javafx.stage.Stage;
import main.java.com.herosAndVillains.controllers.ServerSocketControllerForVillains;
import main.java.com.herosAndVillains.controllers.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import main.java.com.herosAndVillains.views.MyGUI;

/**
 * <h1>VillainsGUI</h1>
 * <p>This is a VillainsGUI of a GUI that allows the user to generate a Villain on the fly, but also adjust the configuration of the observing the common folder.</p>
 */
public class VillainsGUI extends MyGUI {


    private static final String ENTER_YOUR_VILLAIN_TYPE = "enter your villain type";
    private static final String ENTER_YOUR_VILLAIN_STRENGTH = "enter your villain strength";
    private static final String STRONG_VILLAIN = "STRONG VILLAIN";
    private static final String FLYING_VILLAIN = "FLYING VILLAIN";
    private static final String COLOUR = "#ff0000";
    private static final String ENTER_YOUR_DELAY_OF_GENERATING = "enter your delay of generating (s)";
    private static final String ADD_PERSON_BTN_TEXT = "Add villain now";
    private static final String DELAY_BTN_TEXT = "Or generate at this delay";
    private static final String DEFAULT_DELAY = "1";
    private static final String STOP_ALL_GENERATIONS = "Stop all generations";
    private static final String CLOSE_ALL_TEXT = "Close everything (server)";
    private Button addHeroBtn, observingDelayBtn;
    private Stage stage;

    public VillainsGUI(boolean useSockets, Stage stage) {
        super(
                ENTER_YOUR_VILLAIN_TYPE, STRONG_VILLAIN, FLYING_VILLAIN, ENTER_YOUR_VILLAIN_STRENGTH, COLOUR,
                ENTER_YOUR_DELAY_OF_GENERATING, ADD_PERSON_BTN_TEXT,
                DELAY_BTN_TEXT, DEFAULT_DELAY,
                STOP_ALL_GENERATIONS, CLOSE_ALL_TEXT);
        this.stage = stage;
        setButtons(useSockets);
    }

    public HBox getPrimaryLayout(){
        return super.getPrimaryLayout();
    }

    private void setButtons(boolean useSockets){
        super.getAddSuperPersonBtn().setOnAction(event -> {
            System.out.println("User wishes to add a user!!");

            String villainType;
            if(getAddSuperPersonTypeSting().equals("v1")){
                villainType = "Strong";
            }else {
                villainType = "Fly";
            }
            if(!useSockets)
                Controller.addVillain(villainType, super.getAddSuperPersonStrengthTF().getText());
            else
                ServerSocketControllerForVillains.addVillain(villainType, super.getAddSuperPersonStrengthTF().getText());

        });

        super.getDelayBtn().setOnAction(event -> {
            String villainType;
            if(getAddSuperPersonTypeSting().equals("v1")){
                villainType = "Strong";
            }else {
                villainType = "Fly";
            }
            System.out.println("User wishes to generate at " + super.getDelay() + " seconds");

            if(!useSockets)
                Controller.generateVillain(super.getDelay(),villainType, super.getAddSuperPersonStrengthTF().getText());
            else
                ServerSocketControllerForVillains.generateVillain(super.getDelay(),villainType, super.getAddSuperPersonStrengthTF().getText());
        });

        super.getStopMyThreads().setOnAction(event -> {
            System.out.println("STOP MY GENERATIONS");
            if(!useSockets)
                Controller.stopGenerations();
            else
                ServerSocketControllerForVillains.stopGenerations();
        });

        super.getClose().setOnAction(event -> {

            System.out.println("close everything (socket server!)");
            if(useSockets)
                ServerSocketControllerForVillains.closeAll();

            stage.close();
        });
    }



}

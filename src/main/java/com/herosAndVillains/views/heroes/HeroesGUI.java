package main.java.com.herosAndVillains.views.heroes;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.java.com.herosAndVillains.controllers.RMIControllers.RMIClientController;
import main.java.com.herosAndVillains.controllers.socketControllers.ClientSocketControllerForHeroes;
import main.java.com.herosAndVillains.controllers.Controller;
import main.java.com.herosAndVillains.views.MyGUI;

/**
 * <h1>HeroesGUI</h1>
 * <p>This is a HeroesGUI of a GUI that allows the user to generate a Hero on the fly, but also adjust the configuration of the observing the common folder.</p>
 */
public class HeroesGUI extends MyGUI {


    private static final String ENTER_YOUR_HERO_TYPE = "pick your hero type";
    private static final String ENTER_YOUR_HERO_STRENGTH = "enter your hero strength";
    private static final String STONG_HERO = "STRONG HERO";
    private static final String FLY_HERO = "FLYING HERO";
    private static final String COLOUR = "#00ff00";
    private static final String ENTER_YOUR_DELAY_OF_OBSERVING = "enter your delay of observing (s)";
    private static final String ADD_PERSON_BTN_TEXT = "Add hero now";
    private static final String DELAY_BTN_TEXT = "observe for villains at this delay";
    private static final String DEFAULT_DELAY = "0";
    private static final String STOP_ALL_OBSERVATIONS = "Stop all observations";
    private static final String CLOSE_ALL_TEXT = "close everything";
    private Button addHeroBtn, observingDelayBtn;
    private Stage primaryStage;

    public HeroesGUI(boolean useSockets, boolean useRMI, Stage primaryStage) {
        super(
                ENTER_YOUR_HERO_TYPE,STONG_HERO, FLY_HERO, ENTER_YOUR_HERO_STRENGTH, COLOUR,
                ENTER_YOUR_DELAY_OF_OBSERVING, ADD_PERSON_BTN_TEXT,
                DELAY_BTN_TEXT, DEFAULT_DELAY,
                STOP_ALL_OBSERVATIONS,CLOSE_ALL_TEXT);
        this.primaryStage = primaryStage;
        setButtons(useSockets, useRMI);
    }

    public HBox getPrimaryLayout(){
        return super.getPrimaryLayout();
    }

    private void setButtons(boolean useSockets, boolean useRMI){
        super.getAddSuperPersonBtn().setOnAction(event -> {

            System.out.println("User wishes to add a user!!");

            String heroType;
            if(getAddSuperPersonTypeSting().equals("v1")){
                heroType = "Strong";
            }else {
                heroType = "Fly";
            }
            if(!useSockets)
                if(useRMI)
                    RMIClientController.addHero(heroType, super.getAddSuperPersonStrengthTF().getText());
                else
                    Controller.addHero(heroType, super.getAddSuperPersonStrengthTF().getText());
            else {
                ClientSocketControllerForHeroes.addHero(heroType, super.getAddSuperPersonStrengthTF().getText());
            }

        });

        super.getDelayBtn().setOnAction(event -> {
            System.out.println("User wishes to observe at " + super.getDelay() + " seconds");
            if(!useSockets)
                if(useRMI){
                    RMIClientController.observe();
                } else
                    Controller.observe(super.getDelay());
            else {
                ClientSocketControllerForHeroes.observe();
//                ClientSocketControllerForHeroes.observe(super.getDelay());
            }
        });

        super.getStopMyThreads().setOnAction(event -> {
            System.out.println("User wishes stop all observations");
            if(!useSockets) {
                if(useRMI)
                    RMIClientController.stopObservations();
                else
                    Controller.stopObservations();
            }else{
                ClientSocketControllerForHeroes.stopObservations();
            }

        });

        super.getClose().setOnAction(event -> {
            System.out.println("close everything (socket server!)");
            if(useSockets){
                ClientSocketControllerForHeroes.closeAll();
            } else {
                if (useRMI)
                    RMIClientController.closeAll();
            }

            primaryStage.close();
        });
    }



}

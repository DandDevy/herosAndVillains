package views.heroes;

import controllers.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import views.MyGUI;

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
    private Button addHeroBtn, observingDelayBtn;

    public HeroesGUI() {
        super(
                ENTER_YOUR_HERO_TYPE,STONG_HERO, FLY_HERO, ENTER_YOUR_HERO_STRENGTH, COLOUR,
                ENTER_YOUR_DELAY_OF_OBSERVING, ADD_PERSON_BTN_TEXT,
                DELAY_BTN_TEXT, DEFAULT_DELAY,
                STOP_ALL_OBSERVATIONS);
        setButtons();
    }

    public HBox getPrimaryLayout(){
        return super.getPrimaryLayout();
    }

    private void setButtons(){
        super.getAddSuperPersonBtn().setOnAction(event -> {
            System.out.println("User wishes to add a user!!");

            String heroType;
            if(getAddSuperPersonTypeSting() == "v1"){
                heroType = "Strong";
            }else {
                heroType = "Fly";
            }
            Controller.addHero(heroType, super.getAddSuperPersonStrengthTF().getText());


        });

        super.getDelayBtn().setOnAction(event -> {
            System.out.println("User wishes to observe at " + super.getDelay() + " seconds");
            Controller.observe(super.getDelay());
        });

        super.getStopMyThreads().setOnAction(event -> {
            Controller.stopObservations();
        });
    }



}

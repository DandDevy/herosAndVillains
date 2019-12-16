package main.java.com.herosAndVillains;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.com.herosAndVillains.views.heroes.HeroesGUI;
import main.java.com.herosAndVillains.views.villains.VillainsGUI;

public class HeroesAndVillainsMain extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 180;
    private static final String HEROES_TITLE = "HEROES - Daniel Ashcroft";
    private static final String VILLAINS_TITLE = "VILLAINS - Daniel Ashcroft";
    private static final boolean USE_SOCKETS = false;

    @Override
    public void start(Stage heroStage) throws Exception {

        //first stage for heroes
        heroStage.setTitle(HEROES_TITLE);
        heroStage.setScene(new Scene(
                new HeroesGUI(USE_SOCKETS,heroStage).getPrimaryLayout(),
                WIDTH, HEIGHT
        ));
        heroStage.show();

        //second stage for villains
        Stage villainStage = new Stage();
        villainStage.setTitle(VILLAINS_TITLE);
        villainStage.setScene(new Scene(
                new VillainsGUI(USE_SOCKETS,villainStage).getPrimaryLayout(),
                WIDTH, HEIGHT
        ));
        villainStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

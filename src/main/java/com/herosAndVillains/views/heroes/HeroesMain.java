/*
 * Copyright (c) 2019. This was written by Daniel Ashcroft. Use with permission.
 */

package main.java.com.herosAndVillains.views.heroes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HeroesMain extends Application {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 180;
    private static final String TITLE = "HEROES - Daniel Ashcroft";

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(TITLE);

//        primaryStage.setScene(new Scene(new MyGUI("add hero name", "enter goodness",
//                "#b3ffd9", "generation delay", "addPersonBtnText", "delayBtnText", "0")
//                .getPrimaryLayout(), WIDTH, HEIGHT));

        primaryStage.setScene(new Scene(
                new HeroesGUI().getPrimaryLayout(),
                WIDTH, HEIGHT
        ));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

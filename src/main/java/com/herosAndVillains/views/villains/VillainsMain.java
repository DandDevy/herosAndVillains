/*
 * Copyright (c) 2019. This was written by Daniel Ashcroft. Use with permission.
 */

package main.java.com.herosAndVillains.views.villains;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VillainsMain extends Application {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 180;
    private static final String TITLE = "VILLAINS - Daniel Ashcroft";
    private static final boolean USE_SOCKETS = true;

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(
                new VillainsGUI(USE_SOCKETS,primaryStage).getPrimaryLayout(),
                WIDTH, HEIGHT
        ));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

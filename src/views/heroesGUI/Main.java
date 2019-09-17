/*
 * Copyright (c) 2019. This was written by Daniel Ashcroft. Use with permission.
 */

package views.heroesGUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.MyGUI;

public class Main extends Application {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private static final String TITLE = "HEROES - Daniel Ashcroft";

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(TITLE);
        primaryStage.setScene(new Scene(new MyGUI("add hero", "enter goodness").getPrimaryLayout(), WIDTH, HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

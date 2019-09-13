import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Person;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Person person = new Person();


        primaryStage.setTitle("Daniel Ashcroft lab1");
        primaryStage.setScene(new Scene(new VBox(),800, 500));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}

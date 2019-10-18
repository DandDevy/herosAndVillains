import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.heroes.HeroesGUI;
import views.villains.VillainsGUI;

public class HeroesAndVillainsMain extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 180;
    private static final String HEROES_TITLE = "HEROES - Daniel Ashcroft";
    private static final String VILLAINS_TITLE = "VILLAINS - Daniel Ashcroft";

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle(HEROES_TITLE);
        primaryStage.setScene(new Scene(
                new HeroesGUI().getPrimaryLayout(),
                WIDTH, HEIGHT
        ));
        primaryStage.show();

        Stage villainStage = new Stage();
        villainStage.setTitle(VILLAINS_TITLE);
        villainStage.setScene(new Scene(
                new VillainsGUI().getPrimaryLayout(),
                WIDTH, HEIGHT
        ));
        villainStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

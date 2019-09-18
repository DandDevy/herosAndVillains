package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * <h1>MyGUI</h1>
 * This is my graphical user interface for javafx to inherit from
 */
public class MyGUI {
    private VBox addPersonVbox;
    private HBox primaryLayout;

    private Label addPersonLabel, addPersonLabelStrength;
    private TextField addPersonLabelTypeTF;

    public MyGUI(String addPersonLabelTypeText, String addPersonLabelStrengthText, String colour) {

        primaryLayout = new HBox(10);

        addPersonLabelTypeTF = new TextField();
        addPersonLabel = new Label(addPersonLabelTypeText);
        addPersonLabel.setBackground(new Background(new BackgroundFill(new Color(0.5,0,0.5,0.15), CornerRadii.EMPTY, Insets.EMPTY)));

        addPersonVbox = new VBox(4);
        addPersonVbox.getChildren().addAll(
                addPersonLabel,
                addPersonLabelTypeTF
//                new Label(addPersonLabelStrengthText).setBackground(new Background(new BackgroundFill(new Color(0.5,0,0.5,0.15), CornerRadii.EMPTY, Insets.EMPTY)))
        );


        primaryLayout.getChildren().addAll(addPersonVbox);
        primaryLayout.setAlignment(Pos.CENTER);
//        primaryLayout.setStyle("-fx-background-color:  #b3ffd9;");
        primaryLayout.setStyle("-fx-background-color:  "+ colour +";");
    }

    public HBox getPrimaryLayout(){
        return primaryLayout;
    }


}

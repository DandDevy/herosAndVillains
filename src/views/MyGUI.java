package views;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    public MyGUI(String addPersonLabelTypeText, String addPersonLabelStrengthText) {

        primaryLayout = new HBox(10);

        addPersonVbox = new VBox(4);
        addPersonVbox.getChildren().addAll(
                new Label(addPersonLabelTypeText),
                addPersonLabelTypeTF = new TextField(),
                new Label(addPersonLabelStrengthText)
        );


        primaryLayout.getChildren().addAll(addPersonVbox);
    }

    public HBox getPrimaryLayout(){
        return primaryLayout;
    }


}

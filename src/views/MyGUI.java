package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * <h1>MyGUI</h1>
 * This is my graphical user interface for javafx to inherit from
 */
public class MyGUI {
    private VBox addPersonVbox, configVbox;
    private HBox primaryLayout;

    private Label addPersonLabel, addPersonLabelStrength, delayLabel;
    private TextField addPersonTypeTF, addPersonStrengthTF, delayTF;

    private Button addPersonBtn, delayBtn;

    private static final int PRIMARY_LAYOUT_SPACING = 10;
    private static final int SECONDARY_LAYOUT_SPACING = 4;
    private static final int PRIMARY_LAYOUT_FULL_PADDING = 10;

    public MyGUI(String addPersonLabelTypeText, String addPersonLabelStrengthText, String colour, String delayLabelText, String addPersonBtnText, String delayBtnText) {

        //the primary layout is the layout of layout. The top of the tree.
        primaryLayout = new HBox(PRIMARY_LAYOUT_SPACING);

        //the add Person section allows the user to add a person on the fly
        //It takes data attributes that are for the person

        //name
        addPersonLabel = new Label(addPersonLabelTypeText);
        setMyLabelBackground(addPersonLabel);
        addPersonTypeTF = new TextField();

        //strength
        addPersonLabelStrength = new Label(addPersonLabelStrengthText);
        setMyLabelBackground(addPersonLabelStrength);

        addPersonStrengthTF = new TextField();

        //button will tell
        addPersonBtn = new Button(addPersonBtnText);

        //this layout is adding people
        addPersonVbox = new VBox(SECONDARY_LAYOUT_SPACING);
        addPersonVbox.getChildren().addAll(
                addPersonLabel,
                addPersonTypeTF,
                addPersonLabelStrength,
                addPersonStrengthTF,
                addPersonBtn
        );





        //the user can set the generation delay
        delayLabel = new Label(delayLabelText);
        setMyLabelBackground(delayLabel);

        delayTF = new TextField();

        //this layout is a Vbox for configuring the generation of super people.
        configVbox = new VBox(SECONDARY_LAYOUT_SPACING);


        delayBtn = new Button(delayBtnText);

        configVbox.getChildren().addAll(
                delayLabel,
                delayTF,
                delayBtn
        );

        //primary layout takes layouts, aligns itself and sets a colour style
        primaryLayout.getChildren().addAll(
                addPersonVbox,
                configVbox
        );
        primaryLayout.setAlignment(Pos.CENTER);
        primaryLayout.setPadding(new Insets(PRIMARY_LAYOUT_FULL_PADDING, PRIMARY_LAYOUT_FULL_PADDING, PRIMARY_LAYOUT_FULL_PADDING, PRIMARY_LAYOUT_FULL_PADDING));
        primaryLayout.setStyle("-fx-background-color:  "+ colour +";");
    }



    /**
     * Returns the primary layout of all the layouts.
     * @return HBox primaryLayout
     */
    public HBox getPrimaryLayout(){
        return primaryLayout;
    }

    /**
     * This sets labels to standardised background
     * @param myLabel
     */
    private void setMyLabelBackground(Label myLabel){
        myLabel.setBackground(new Background(new BackgroundFill(new Color(0.5,0,0.5,0.15), CornerRadii.EMPTY, Insets.EMPTY)));
    }

}


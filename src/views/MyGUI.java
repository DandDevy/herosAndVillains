package views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * <h1>MyGUI</h1>
 * This is my graphical user interface for javafx to inherit from
 */
public abstract class MyGUI {
    private VBox addPersonVbox, configVbox;
    private HBox primaryLayout;

    private Label addPersonLabel, addPersonLabelStrength, delayLabel;

    private TextField addSuperPersonStrengthTF;

    private TextField delayTF;

    private RadioButton personVersion1;
    private RadioButton personVersion2;
    private Button addSuperPersonBtn;
    private Button delayBtn;
    private Button stopMyThreads;

    private static final int PRIMARY_LAYOUT_SPACING = 10;
    private static final int SECONDARY_LAYOUT_SPACING = 4;
    private static final int PRIMARY_LAYOUT_FULL_PADDING = 10;



    protected MyGUI(String addPersonLabelTypeText, String personTypeV1, String personTypeV2, String addPersonLabelStrengthText, String colour, String delayLabelText, String addPersonBtnText, String delayBtnText, String defaultDelay, String stopMyThreadsText) {

        //the primary layout is the layout of layout. The top of the tree.
        primaryLayout = new HBox(PRIMARY_LAYOUT_SPACING);

        //the add Person section allows the user to add a person on the fly
        //It takes versions that are for the person

        //type
        addPersonLabel = new Label(addPersonLabelTypeText);
        setMyLabelBackground(addPersonLabel);

        //toggle group different kind of people
        ToggleGroup personToggleGrp = new ToggleGroup();

        personVersion1 = new RadioButton(personTypeV1);
        personVersion1.setToggleGroup(personToggleGrp);
        personVersion1.setSelected(true);

        personVersion2 = new RadioButton(personTypeV2);
        personVersion2.setToggleGroup(personToggleGrp);

        //strength
        addPersonLabelStrength = new Label(addPersonLabelStrengthText);
        setMyLabelBackground(addPersonLabelStrength);

        addSuperPersonStrengthTF = new TextField();

        //button will tell
        addSuperPersonBtn = new Button(addPersonBtnText);

        //this layout is adding people
        addPersonVbox = new VBox(SECONDARY_LAYOUT_SPACING);
        addPersonVbox.getChildren().addAll(
                addPersonLabel,
                personVersion1,
                personVersion2,
                addPersonLabelStrength,
                addSuperPersonStrengthTF,
                addSuperPersonBtn
        );





        //the user can set the generation delay
        delayLabel = new Label(delayLabelText);
        setMyLabelBackground(delayLabel);

        delayTF = new TextField(defaultDelay);

        //this layout is a Vbox for configuring the generation of super people.
        configVbox = new VBox(SECONDARY_LAYOUT_SPACING);


        delayBtn = new Button(delayBtnText);

        stopMyThreads = new Button(stopMyThreadsText);

        configVbox.getChildren().addAll(
                delayLabel,
                delayTF,
                delayBtn,
                stopMyThreads
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
     * returns a button of the stop threads
     * @return Button
     */
    protected Button getStopMyThreads() {
        return stopMyThreads;
    }

    /**
     * returns a button of the add Person
     * @return Button
     */
    protected Button getAddSuperPersonBtn(){
        return addSuperPersonBtn;
    }

    /**
     * returns a Button of the delay
     * @return Button
     */
    protected Button getDelayBtn(){
        return delayBtn;
    }

    /**
     * returns a string of the add hero person version type
     * @return
     */
    public String getAddSuperPersonTypeSting(){
        if(personVersion1.isSelected())
            return "v1";
        else
            return "v2";
    }

    /**
     * returns a Textfield of addSuperPerson Strength
     * @return Textfield
     */
    protected TextField getAddSuperPersonStrengthTF() {
        return addSuperPersonStrengthTF;
    }

    /**
     * returns a textField of the delay of the choice of the user
     * @return Textfield
     */
    protected TextField getDelayTF() {
        return delayTF;
    }

    /**
     * returns the delay chosen by the user
     * @return int delay
     */
    protected int getDelay(){
        int res = -1;

        try {
            int temp_res =Integer.parseInt(delayTF.getText());
            if(temp_res >= 0){
                res = temp_res;
            }
        } catch ( Exception e){
            System.out.println("User is trying a unusable number");
            System.out.println("Must be number [0..infinity]");
        }
        return res;
    }

    /**
     * Returns the primary layout of all the layouts.
     * @return HBox primaryLayout
     */
    protected HBox getPrimaryLayout(){
        return primaryLayout;
    }

    /**
     * This sets labels to standardised background
     * @param myLabel
     */
    protected void setMyLabelBackground(Label myLabel){
        myLabel.setBackground(new Background(new BackgroundFill(new Color(0.5,0,0.5,0.15), CornerRadii.EMPTY, Insets.EMPTY)));
    }

}


package persistence;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import persistence.abstracts.Listeners;

import static javafx.scene.paint.Color.RED;

public class Household extends Listeners {

    //region Fields
    private ObjectProperty<EventHandler<ActionEvent>> propertyOnAction = new SimpleObjectProperty<EventHandler<ActionEvent>>();
    @FXML
    private Label errorLabel;
    @FXML
    private SplitPane splitPane;
    @FXML
    private AnchorPane firstAnchorPane;
    @FXML
    private AnchorPane secondAnchorPane;
    @FXML
    private AnchorPane thirdAnchorPane;
    @FXML
    private AnchorPane fourthAnchorPane;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField peopleCountTextField;
    @FXML
    private TextField chamberCountTextField;
    @FXML
    private CheckBox partChamberCheckBox;
    @FXML
    private CheckBox internetCheckBox;
    //endregion

    public Household (Pane root, int multiplier){
        int rootX = 580;
        int rootY = 50;
        int firstX = 0;
        int firstY = 0;
        int secondX = 5;
        int secondY = 30;
        int textWidth = 50;
        int textHeight = 20;

        setNewPane(multiplier);

        setLayouts(rootX, rootY, firstX, firstY, secondX, secondY, multiplier);

        setTexts();

        addListeners();

        setTextFieldsSizes(textWidth, textHeight);

        root.getChildren().add(splitPane);

        createOnAction();
    }

    //region GETTERs
    public int getNumberTextField() {
        return Integer.parseInt(numberTextField.getText());
    }

    public int getPeopleCountTextField() {
        return Integer.parseInt(peopleCountTextField.getText());
    }

    public int getChamberCountTextField() {
        return Integer.parseInt(chamberCountTextField.getText());
    }

    public boolean getPartChamberCheckBox() {
        return partChamberCheckBox.isSelected();
    }

    public boolean getInternetCheckBox() {
        return internetCheckBox.isSelected();
    }

    public double getCount(){
        if (partChamberCheckBox.isSelected()){
            return 0.5;
        } else {
            return Double.parseDouble(chamberCountTextField.getText());
        }
    }

    public SplitPane getSplitPane() {
        return splitPane;
    }

    public boolean getErrorLabel(){
        return errorLabel.isDisabled();
    }
    //endregion

    //region SETs
    private void setNewPane (int multiplier){
        numberTextField = new TextField(Integer.toString(multiplier+1));
        peopleCountTextField = new TextField();
        chamberCountTextField = new TextField();
        partChamberCheckBox = new CheckBox();
        internetCheckBox = new CheckBox();
        errorLabel = new Label();

        firstAnchorPane = new AnchorPane(numberTextField, errorLabel);
        secondAnchorPane = new AnchorPane(peopleCountTextField);
        thirdAnchorPane = new AnchorPane(chamberCountTextField, partChamberCheckBox);
        fourthAnchorPane = new AnchorPane(internetCheckBox);

        splitPane = new SplitPane();

        splitPane.getItems().addAll(firstAnchorPane, secondAnchorPane, thirdAnchorPane, fourthAnchorPane);
    }

    private void setLayouts (int rootX, int rootY, int firstX, int firstY, int secondX, int secondY, int multiplier){
        splitPane.setPrefSize(rootX, rootY);
        splitPane.setLayoutX(0);
        splitPane.setLayoutY(rootY*multiplier+5);
        splitPane.setDividerPositions(0.175f, 0.385f, 0.67f);

        firstAnchorPane.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.175));
        secondAnchorPane.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.21));
        thirdAnchorPane.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.285));
        fourthAnchorPane.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.33));

        numberTextField.setLayoutX(firstX);
        numberTextField.setLayoutY(firstY);
        peopleCountTextField.setLayoutX(firstX);
        peopleCountTextField.setLayoutY(firstY);
        chamberCountTextField.setLayoutX(firstX);
        chamberCountTextField.setLayoutY(firstY);
        errorLabel.setLayoutX(secondX);
        errorLabel.setLayoutY(secondY);
        errorLabel.setVisible(false);

        partChamberCheckBox.setLayoutX(secondX);
        partChamberCheckBox.setLayoutY(secondY);
        internetCheckBox.setLayoutX(firstX);
        internetCheckBox.setLayoutY(firstY);
    }

    private void setTexts (){
        partChamberCheckBox.setText("Часть комнаты");
        internetCheckBox.setText("Интернет");
        errorLabel.setText("Ошибка");
        errorLabel.setTextFill(RED);
    }

    private void setTextFieldsSizes(int textWidth, int textHeight){
        numberTextField.setPrefWidth(textWidth);
        numberTextField.setPrefHeight(textHeight);
        peopleCountTextField.setPrefWidth(textWidth);
        peopleCountTextField.setPrefHeight(textHeight);
        chamberCountTextField.setPrefWidth(textWidth);
        chamberCountTextField.setPrefHeight(textHeight);
    }

    private void createOnAction(){
        partChamberCheckBox.setOnAction(event -> onActionProperty().get().handle(event));
    }
    //endregion

    //region ErrorChecks
    public void errorCheck(){
        errorLabel.setVisible(lookForErrors());
    }

    private boolean lookForErrors(){
        if (numberTextField.getText().isEmpty()){
            return true;
        } else if (peopleCountTextField.getText().isEmpty()){
            return true;
        } else if (!partChamberCheckBox.isSelected()){
            if (chamberCountTextField.getText().isEmpty()){
                return true;
            }
        } else {
            return false;
        }
        return true;
    }

    private void chamberPartCheck(){
        chamberCountTextField.setDisable(partChamberCheckBox.isSelected());
    }
    //endregion

    //region Listeners
    private void addListeners (){
        createNumericListener(numberTextField);
        createNumericListener(peopleCountTextField);
        createNumericListener(chamberCountTextField);
    }

    @SuppressWarnings("WeakerAccess")
    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        chamberPartCheck();
        return propertyOnAction;
    }

    public final void setOnAction(EventHandler<ActionEvent> handler) {
        propertyOnAction.set(handler);
    }

    public final EventHandler<ActionEvent> getOnAction() {
        return propertyOnAction.get();

    }
    //endregion
}

package views;

import entities.db.dbFlattableEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import persistence.abstracts.AddingControllers;
import persistence.abstracts.FormControllers;

import java.net.URL;
import java.util.ResourceBundle;

public class FormVPt2Controller extends AddingControllers implements Initializable {
    private dbFlattableEntity flat;

    //region FXML Fields
    @FXML
    private Label errorLabel;
    @FXML
    private Label eighteenthLabel;
    @FXML
    private Label nineteenthLabel;
    @FXML
    private Label twentiethLabel;
    @FXML
    private Label twentyFirstLabel;
    @FXML
    private Label twentySecondLabel;
    @FXML
    private Label twentyThirdLabel;
    @FXML
    private ComboBox<String> homeTypeComboBox;
    @FXML
    private TextField squareTextField;
    @FXML
    private TextField chamberNumberTextField;
    @FXML
    private CheckBox tvCheckBox;
    @FXML
    private CheckBox phoneCheckBox;
    @FXML
    private CheckBox radioCheckBox;
    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;
    //endregion

    //region FXML Methods
    @FXML
    private void cancelButtonClick(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void submitButtonClick(){
        updateErrorLabel();
        if (!errorLabel.isVisible()){
            flat = new dbFlattableEntity();
            createFlat();
            addObject("setNewFlat", flat, submitButton);
        }
    }
    //endregion

    //region Initializers
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readHostAndPort();
        initializeComboBoxes();
        addListenersToTextFields();
    }

    private void addListenersToTextFields(){
        createNumericListener(squareTextField);
        createNumericListener(chamberNumberTextField);
    }

    private void initializeComboBoxes(){
        homeTypeComboBox.getItems().removeAll(homeTypeComboBox.getItems());
        homeTypeComboBox.getItems().addAll(livingPlaceOptions);
    }
    //endregion

    //region Errors
    private boolean errorLabelCheck() {
        if (homeTypeComboBox.getSelectionModel().getSelectedIndex() == -1 &&
                !homeTypeComboBox.isDisabled()) {
            return false;
        } else if (!squareTextField.isDisabled() && squareTextField.getText().isEmpty()) {
            return false;
        } else return chamberNumberTextField.isDisabled() || !chamberNumberTextField.getText().isEmpty();
    }

    private void updateErrorLabel () {
        if (errorLabelCheck()) {
            errorLabel.setVisible(false);
        } else {
            errorLabel.setVisible(true);
        }
    }
    //endregion

    //region Switchers
    private void fifthPaneSwitch(boolean switcher){
        eighteenthLabel.setDisable(switcher);
        homeTypeComboBox.setDisable(switcher);
    }

    private void sixthPaneSwitch(boolean switcher){
        nineteenthLabel.setDisable(switcher);
        twentiethLabel.setDisable(switcher);
        squareTextField.setDisable(switcher);
    }

    private void seventhPaneSwitch(boolean switcher){
        chamberNumberTextField.setDisable(switcher);
        twentyFirstLabel.setDisable(switcher);
        twentySecondLabel.setDisable(switcher);
    }

    private void eighthPaneSwitch(boolean switcher){
        twentyThirdLabel.setDisable(switcher);
        phoneCheckBox.setDisable(switcher);
        tvCheckBox.setDisable(switcher);
        radioCheckBox.setDisable(switcher);
    }
    //endregion

    private void createFlat(){
        flat.setBuildingId(resultId);
        flat.setFlatType(getBool(homeTypeComboBox));
        flat.setPhone(phoneCheckBox.isSelected());
        flat.setTv(tvCheckBox.isSelected());
        flat.setRadio(radioCheckBox.isSelected());
        flat.setSquare(Integer.parseInt(squareTextField.getText()));
        flat.setChamberCount(Integer.parseInt(chamberNumberTextField.getText()));
    }

    private void oneFlatHouse(){
        fifthPaneSwitch(true);
        sixthPaneSwitch(false);
        seventhPaneSwitch(false);
        eighthPaneSwitch(false);
    }

    private void setHomeless(){
        fifthPaneSwitch(true);
        sixthPaneSwitch(true);
        seventhPaneSwitch(true);
        eighthPaneSwitch(true);
    }

    private void setManyFlats(){
        fifthPaneSwitch(false);
        sixthPaneSwitch(false);
        seventhPaneSwitch(false);
        eighthPaneSwitch(false);
    }


}

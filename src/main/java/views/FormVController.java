package views;

import entities.db.dbBuildingtableEntity;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import persistence.abstracts.AddingControllers;
import persistence.abstracts.FormControllers;

import java.net.URL;
import java.util.ResourceBundle;

public class FormVController extends AddingControllers implements Initializable {
    private dbBuildingtableEntity building;

    //region FXML Fields
    @FXML
    private Button cancelButton;
    @FXML
    private Button submitButton;
    @FXML
    private TextField otherTypeTextField;
    @FXML
    private TextField otherMaterialsFieldText;
    @FXML
    private CheckBox electricityCheckBox;
    @FXML
    private CheckBox electricStoveCheckBox;
    @FXML
    private ComboBox<String> buildingTypeComboBox;
    @FXML
    private ComboBox<String> foundationTimeComboBox;
    @FXML
    private ComboBox<String> wallsMaterialComboBox;
    @FXML
    private ComboBox<String> gasComboBox;
    @FXML
    private ComboBox<String> heatComboBox;
    @FXML
    private ComboBox<String> waterComboBox;
    @FXML
    private ComboBox<String> hotWaterComboBox;
    @FXML
    private ComboBox<String> canalisationComboBox;
    @FXML
    private ComboBox<String> toiletComboBox;
    @FXML
    private ComboBox<String> bathComboBox;
    @FXML
    private ComboBox<String> garbageComboBox;
    @FXML
    private ComboBox<String> kitchenComboBox;
    @FXML
    private Label errorLabel;
    @FXML
    private Label firstLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private Label thirdLabel;
    @FXML
    private Label fourthLabel;
    @FXML
    private Label fifthLabel;
    @FXML
    private Label sixthLabel;
    @FXML
    private Label seventhLabel;
    @FXML
    private Label eighthLabel;
    @FXML
    private Label ninthLabel;
    @FXML
    private Label tenthLabel;
    @FXML
    private Label eleventhLabel;
    @FXML
    private Label twelfthLabel;
    @FXML
    private Label thirteenthLabel;
    @FXML
    private Label fourteenthLabel;
    @FXML
    private Label fifteenthLabel;
    @FXML
    private Label sixteenthLabel;
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
            building = new dbBuildingtableEntity();
            createBuilding();
            addObject("setNewBuilding", building, submitButton);
        }

    }
    //endregion

    //region Initializers
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeComboBoxes();
        addListenersToComboBoxes();
    }

    private void addListenersToComboBoxes(){
        buildingTypeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (buildingTypeComboBox.getSelectionModel().getSelectedIndex()){
                case 0:{
                    oneFlatHouse();
                    secondLabel.setDisable(true);
                    otherTypeTextField.setDisable(true);
                    firstLabel.setDisable(true);
                    break;
                }
                case 1:{
                    oneFlatHouse();
                    secondLabel.setDisable(true);
                    otherTypeTextField.setDisable(true);
                    firstLabel.setDisable(true);
                    break;
                }
                case 3:
                {   setHomeless();
                    secondLabel.setDisable(true);
                    otherTypeTextField.setDisable(true);
                    firstLabel.setDisable(false);
                    break;
                }
                case 4:
                {
                    setHomeless();
                    secondLabel.setDisable(true);
                    otherTypeTextField.setDisable(true);
                    firstLabel.setDisable(false);
                    break;
                }
                case 5:
                {
                    setHomeless();
                    secondLabel.setDisable(false);
                    otherTypeTextField.setDisable(false);
                    firstLabel.setDisable(false);
                    break;
                }
                case 6:
                {
                    setHomeless();
                    secondLabel.setDisable(true);
                    otherTypeTextField.setDisable(true);
                    firstLabel.setDisable(false);
                    break;
                }
                default:
                {
                    setManyFlats();
                    secondLabel.setDisable(true);
                    otherTypeTextField.setDisable(true);
                    firstLabel.setDisable(true);
                    break;
                }
            }
        });
    }

    private void initializeComboBoxes(){
        buildingTypeComboBox.getItems().removeAll(buildingTypeComboBox.getItems());
        buildingTypeComboBox.getItems().addAll(buildingTypesOptions);
        foundationTimeComboBox.getItems().removeAll(foundationTimeComboBox.getItems());
        foundationTimeComboBox.getItems().addAll(foundationOptions);
        wallsMaterialComboBox.getItems().removeAll(wallsMaterialComboBox.getItems());
        wallsMaterialComboBox.getItems().addAll(materialOptions);
        gasComboBox.getItems().removeAll(gasComboBox.getItems());
        gasComboBox.getItems().addAll(gasOptions);
        waterComboBox.getItems().removeAll(waterComboBox.getItems());
        waterComboBox.getItems().addAll(waterOptions);
        hotWaterComboBox.getItems().removeAll(hotWaterComboBox.getItems());
        hotWaterComboBox.getItems().addAll(hotWaterOptions);
        heatComboBox.getItems().removeAll(heatComboBox.getItems());
        heatComboBox.getItems().addAll(heatOptions);
        canalisationComboBox.getItems().removeAll(canalisationComboBox.getItems());
        canalisationComboBox.getItems().addAll(canalisationOptions);
        toiletComboBox.getItems().removeAll(toiletComboBox.getItems());
        toiletComboBox.getItems().addAll(toiletOptions);
        bathComboBox.getItems().removeAll(bathComboBox.getItems());
        bathComboBox.getItems().addAll(bathOptions);
        garbageComboBox.getItems().removeAll(garbageComboBox.getItems());
        garbageComboBox.getItems().addAll(garbageOptions);
        kitchenComboBox.getItems().removeAll(kitchenComboBox.getItems());
        kitchenComboBox.getItems().addAll(kitchenOptions);
    }
    //endregion

    //region Switchers
    private void secondPaneSwitch(boolean switcher){
        thirdLabel.setDisable(switcher);
        fourthLabel.setDisable(switcher);
        foundationTimeComboBox.setDisable(switcher);
    }

    private void thirdPaneSwitch(boolean switcher){
        if(!switcher){
            fifthLabel.setDisable(switcher);
            wallsMaterialComboBox.setDisable(switcher);
        }else{
            otherMaterialsFieldText.setDisable(switcher);
            sixthLabel.setDisable(switcher);
            fifthLabel.setDisable(switcher);
            wallsMaterialComboBox.setDisable(switcher);
        }
    }

    private void fourthPaneSwitch(boolean switcher){
        seventhLabel.setDisable(switcher);
        eighthLabel.setDisable(switcher);
        ninthLabel.setDisable(switcher);
        tenthLabel.setDisable(switcher);
        eleventhLabel.setDisable(switcher);
        twelfthLabel.setDisable(switcher);
        thirteenthLabel.setDisable(switcher);
        fourteenthLabel.setDisable(switcher);
        fifteenthLabel.setDisable(switcher);
        sixteenthLabel.setDisable(switcher);
        electricityCheckBox.setDisable(switcher);
        electricStoveCheckBox.setDisable(switcher);
        gasComboBox.setDisable(switcher);
        heatComboBox.setDisable(switcher);
        waterComboBox.setDisable(switcher);
        hotWaterComboBox.setDisable(switcher);
        canalisationComboBox.setDisable(switcher);
        toiletComboBox.setDisable(switcher);
        bathComboBox.setDisable(switcher);
        garbageComboBox.setDisable(switcher);
        kitchenComboBox.setDisable(switcher);
    }
    //endregion

    //region Errors
    private boolean errorLabelCheck(){
        if (buildingTypeComboBox.getSelectionModel().getSelectedIndex()==-1){
            return false;
        } else if (!otherTypeTextField.isDisabled() && otherTypeTextField.getText().isEmpty()) {
            return false;
        } else if (foundationTimeComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !foundationTimeComboBox.isDisabled()) {
            return false;
        } else if (wallsMaterialComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !wallsMaterialComboBox.isDisabled()) {
            return false;
        } else if (otherMaterialsFieldText.getText().isEmpty() && !otherMaterialsFieldText.isDisabled()) {
            return false;
        } else if (gasComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !gasComboBox.isDisabled()) {
            return false;
        } else if (heatComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !heatComboBox.isDisabled()) {
            return false;
        } else if (waterComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !waterComboBox.isDisabled()) {
            return false;
        } else if (hotWaterComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !hotWaterComboBox.isDisabled()) {
            return false;
        } else if (bathComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !bathComboBox.isDisabled()) {
            return false;
        } else if (garbageComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !garbageComboBox.isDisabled()) {
            return false;
        } else if (kitchenComboBox.getSelectionModel().getSelectedIndex() ==-1 &&
                !kitchenComboBox.isDisabled()) {
            return false;
        } else {
            return true;
        }
    }

    private void updateErrorLabel(){
        if (errorLabelCheck()){
            errorLabel.setVisible(false);
        } else {
            errorLabel.setVisible(true);
        }
    }
    //endregion

    //region Creators
    private void createBuilding (){
        building.setHomeType(buildingTypeComboBox.getSelectionModel().getSelectedIndex());

        if (!electricityCheckBox.isDisabled()){
            building.setEnergy(electricityCheckBox.isSelected());
        }

        if (!electricStoveCheckBox.isDisabled()){
            building.setStove(electricStoveCheckBox.isSelected());
        }

        if (!otherTypeTextField.isDisabled()){
            building.setTypeString(otherTypeTextField.getText());
        }

        if (!otherMaterialsFieldText.isDisabled()){
            building.setWallString(otherMaterialsFieldText.getText());
        }

        if (!foundationTimeComboBox.isDisabled()){
            building.setHomeType(foundationTimeComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!wallsMaterialComboBox.isDisabled()){
            building.setWallMaterial(wallsMaterialComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!gasComboBox.isDisabled()){
            building.setGas(gasComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!heatComboBox.isDisabled()){
            building.setHeat(heatComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!waterComboBox.isDisabled()){
            building.setWater(waterComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!hotWaterComboBox.isDisabled()){
            building.setHotWater(hotWaterComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!canalisationComboBox.isDisabled()){
            building.setCanalisation(canalisationComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!toiletComboBox.isDisabled()){
            building.setCloset(toiletComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!bathComboBox.isDisabled()){
            building.setShower(bathComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!garbageComboBox.isDisabled()){
            building.setGarbage(garbageComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!kitchenComboBox.isDisabled()){
            building.setKitchen(kitchenComboBox.getSelectionModel().getSelectedIndex());
        }
    }
    //endregion

    //region SetTypeOfBuilding
    private void oneFlatHouse(){
        secondPaneSwitch(false);
        thirdPaneSwitch(false);
        fourthPaneSwitch(false);
    }

    private void setHomeless(){
        secondPaneSwitch(true);
        thirdPaneSwitch(true);
        fourthPaneSwitch(true);
    }

    private void setManyFlats(){
        secondPaneSwitch(false);
        thirdPaneSwitch(false);
        fourthPaneSwitch(false);
    }
    //endregion
}

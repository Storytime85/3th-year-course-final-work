package views;

import entities.db.dbHouseholdtableEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import persistence.Household;
import persistence.abstracts.AddingControllers;
import persistence.abstracts.FormControllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FormVPt3Controller extends AddingControllers implements Initializable {
    private int widthOfPane = 50;
    private List<dbHouseholdtableEntity> households;

    //region FXML Fields
    private List<Household> householdControllers = new ArrayList<>();
    @FXML
    private Pane paneInScrollPane;
    @FXML
    private Label errorLabel;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button plusOneButton;
    @FXML
    private Button minusOneButton;
    //endregion

    //region FXML Methods
    @FXML
    private void plusOneButtonClick (){
        int temp = householdControllers.size();
        switch (temp){
            case 1: {
                minusOneButton.setDisable(false);
                householdControllers.add(new Household(paneInScrollPane,temp));
                paneInScrollPane.setPrefHeight(paneInScrollPane.getPrefWidth()+widthOfPane);
                break;
            }
            case 9: {
                plusOneButton.setDisable(true);
                householdControllers.add(new Household(paneInScrollPane,temp));
                paneInScrollPane.setPrefHeight(paneInScrollPane.getPrefWidth()+widthOfPane);
                break;
            }
            default: {
                householdControllers.add(new Household(paneInScrollPane,temp));
                paneInScrollPane.setPrefHeight(paneInScrollPane.getPrefWidth()+widthOfPane);
                break;
            }
        }
    }
    @FXML
    private void minusOneButtonClick (){
        int temp = householdControllers.size();
        switch (temp) {
            case 2: {
                minusOneButton.setDisable(true);
                paneInScrollPane.getChildren().remove(householdControllers.get(temp - 1).getSplitPane());
                householdControllers.remove(temp - 1);
                paneInScrollPane.setPrefHeight(paneInScrollPane.getPrefWidth()-widthOfPane);
                break;
            }
            case 10: {
                plusOneButton.setDisable(false);
                paneInScrollPane.getChildren().remove(householdControllers.get(temp - 1).getSplitPane());
                householdControllers.remove(temp - 1);
                paneInScrollPane.setPrefHeight(paneInScrollPane.getPrefWidth()-widthOfPane);
                break;
            }
            default: {
                paneInScrollPane.getChildren().remove(householdControllers.get(temp - 1).getSplitPane());
                householdControllers.remove(temp - 1);
                paneInScrollPane.setPrefHeight(paneInScrollPane.getPrefWidth()-widthOfPane);
                break;
            }
        }
    }
    @FXML
    private void cancelButtonClick(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void submitButtonClick(){
        if (!errorCheck()){
            createHouseholdList();
            addObject("setNewHousehold", households, submitButton);
        } else {
            errorLabel.setVisible(true);
        }
    }
    //endregion

    //region Creators
    private void createHouseholdList (){
        households = new ArrayList<>();
        for (Household h: householdControllers){
            households.add(createHousehold(h));
        }
    }

    private dbHouseholdtableEntity createHousehold(Household h){
        dbHouseholdtableEntity result = new dbHouseholdtableEntity();
        result.setFlatId(resultId);
        result.setInternet(h.getInternetCheckBox());
        result.setPeopleCount(h.getPeopleCountTextField());
        result.setChamberCount(h.getCount());
        return result;
    }
    ///endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        householdControllers.add(new Household(paneInScrollPane, 0));
    }

    private boolean errorCheck(){
        boolean result = false;
        for (Household h: householdControllers){
            h.errorCheck();
            if(h.getErrorLabel()){
                result = true;
            }
        }
        return result;
    }


}

package views;

import entities.db.dbMigrationtableEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import persistence.abstracts.AddingControllers;
import persistence.abstracts.FormControllers;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class FormPController extends AddingControllers implements Initializable {
    private dbMigrationtableEntity migrator;

    //region FXML Fields
    @FXML
    private Button cancelButton;
    @FXML
    private Label fifthLabel;
    @FXML
    private Label labelOne;
    @FXML
    private TextField monthsTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private Label monthsLabel;
    @FXML
    private Label sixthLabel;
    @FXML
    private TextField motherlandTextField;
    @FXML
    private Label seventhLabel;
    @FXML
    private TextField citizenshipTextField;
    @FXML
    private CheckBox noCitizenshipCheckBox;
    @FXML
    private Label writeWhichLabel;
    @FXML
    private TextField writeWhichTextField;
    @FXML
    private ComboBox<String> sexComboBox;
    @FXML
    private ComboBox<String> purposeComboBox;
    @FXML
    private Button submitButton;
    @FXML
    private Label errorLabel;
    @FXML
    private Label errorLabel2;
    @FXML
    private Label errorLabel3;
    @FXML
    private TextField countryTextField;
    //endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readHostAndPort();

        purposeComboBox.getItems().removeAll(purposeComboBox.getItems());
        purposeComboBox.getItems().addAll(purposeOptions);
        sexComboBox.getItems().removeAll(sexComboBox.getItems());
        sexComboBox.getItems().addAll(sexOptions);
        purposeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (purposeComboBox.getSelectionModel().getSelectedIndex()){
                case 0: {
                    setSecondColumnEnabled(true);
                    setAnotherTarget(false);
                    break;
                }
                case 1: {
                    setSecondColumnEnabled(true);
                    setAnotherTarget(false);
                    break;
                }
                case 6: {
                    setSecondColumnEnabled(false);
                    setAnotherTarget(true);
                    break;
                }
                default: {
                    setSecondColumnEnabled(false);
                    setAnotherTarget(false);
                    break;
                }
            }
        });

        yearTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")){
                yearTextField.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                if(!checkNumberInRange(newValue,1900,2010)) {
                    errorLabel.setVisible(true);
                } else {
                    errorLabel.setVisible(false);
                }
            }
        });

        monthsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")){
                monthsTextField.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                if (!checkNumberInRange(newValue,1,99)){
                    errorLabel2.setVisible(true);
                } else {
                    errorLabel2.setVisible(false);
                }
            }
        });
    }

    //region FXML Methods
    @FXML
    private void setAnotherTarget(boolean pose){
        if (pose){
            writeWhichLabel.setDisable(false);
            writeWhichTextField.setDisable(false);
        } else {
            writeWhichLabel.setDisable(true);
            writeWhichTextField.setDisable(true);
        }
    }
    @FXML
    private void noCitizenshipCheckBoxOnClick(){
        if (noCitizenshipCheckBox.isSelected()){
            citizenshipTextField.setDisable(true);
            citizenshipTextField.clear();
        } else {
            citizenshipTextField.setDisable(false);
            citizenshipTextField.clear();
        }
    }
    @FXML
    private void updateErrorLabel3(){
        if (checkErrorLabel()){
            errorLabel3.setVisible(false);
        } else {
            errorLabel3.setVisible(true);
        }
    }
    @FXML
    private void cancelButtonClick(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void submitButtonClick(){
        updateErrorLabel3();
        if (!errorLabel3.isVisible()){
            migrator = new dbMigrationtableEntity();
            createMigrator();
            addObject("setNewMigration", migrator, submitButton);
        }
    }
    //endregion

    private void createMigrator() {
        migrator.setHumanId(resultId);
        migrator.setSex(getBool(sexComboBox));
        Calendar cal = Calendar.getInstance();
        cal.set(cal.YEAR, Integer.parseInt(yearTextField.getText()));
        cal.set(cal.DAY_OF_MONTH, 1);
        cal.set(cal.MONTH, 1);
//        updateSeries(calculateAge(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),
//                cal.get(Calendar.DAY_OF_MONTH) ), LocalDate.now()), lineChartData);
        migrator.setBirthYear(new Date (cal.getTime().getTime()));
        migrator.setPermanentCountry(countryTextField.getText());
        migrator.setPurpose(purposeComboBox.getSelectionModel().getSelectedIndex());
        if(!writeWhichTextField.isDisabled()) {
            migrator.setPurposeString(writeWhichTextField.getText());
        }

        if (!monthsTextField.isDisabled()) {
            migrator.setLasting(Integer.parseInt(monthsTextField.getText()));
        }

        if (!motherlandTextField.isDisabled()) {
            migrator.setMotherCountry(motherlandTextField.getText());
        }

        if (!citizenshipTextField.isDisabled()){
           migrator.setCitizenship(getCitizenship());
        }

    }

    private String getCitizenship(){
        if (noCitizenshipCheckBox.isSelected()){
            return "Без гражданства";
        } else {
            return citizenshipTextField.getText();
        }
    }

    private boolean checkErrorLabel(){
        if (sexComboBox.getSelectionModel().getSelectedIndex()==-1){
            return false;
        } else if (errorLabel.isVisible()){
            return false;
        } else if (errorLabel2.isVisible()){
            return false;
        } else if (yearTextField.getText().isEmpty()){
            return false;
        } else if (countryTextField.getText().isEmpty()){
            return false;
        } else if (purposeComboBox.getSelectionModel().getSelectedIndex()==-1){
            return false;
        } else if (writeWhichTextField.getText().isEmpty() && !writeWhichTextField.isDisabled()){
            return false;
        } else if (monthsTextField.getText().isEmpty() && !monthsTextField.isDisabled()){
            return false;
        } else if (motherlandTextField.getText().isEmpty() && !motherlandTextField.isDisabled()){
            return false;
        } else return !citizenshipTextField.getText().isEmpty() || citizenshipTextField.isDisabled();
    }

    private void setSecondColumnEnabled(boolean pose) {
        if (pose)
        {
            fifthLabel.setDisable(false);
            labelOne.setDisable(false);
            monthsTextField.setDisable(false);
            monthsLabel.setDisable(false);
            sixthLabel.setDisable(false);
            motherlandTextField.setDisable(false);
            seventhLabel.setDisable(false);
            citizenshipTextField.setDisable(false);
            noCitizenshipCheckBox.setDisable(false);
        } else {
            fifthLabel.setDisable(true);
            labelOne.setDisable(true);
            monthsTextField.setDisable(true);
            monthsLabel.setDisable(true);
            sixthLabel.setDisable(true);
            motherlandTextField.setDisable(true);
            seventhLabel.setDisable(true);
            citizenshipTextField.setDisable(true);
            noCitizenshipCheckBox.setDisable(true);
        }
    }
}

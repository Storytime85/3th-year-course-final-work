package views;

import entities.db.dbHumantableEntity;
import entities.db.dbSalariestableEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import persistence.abstracts.AddingControllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class FormLController extends AddingControllers implements Initializable {
    private dbHumantableEntity human;
    private dbSalariestableEntity salary;

    //region FXML Fields
    @FXML
    private Label twentyFirstLabel;
    @FXML
    private ComboBox<String> migrationComboBox;
    @FXML
    private ComboBox<String> relationsComboBox;
    @FXML
    private TextField whoItIsTextField;
    @FXML
    private ComboBox<String> sexComboBox;
    @FXML
    private TextField dayTextField;
    @FXML
    private TextField monthTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField birthplaceTextField;
    @FXML
    private ComboBox<String> marriageComboBox;
    @FXML
    private ComboBox<String> registratedComboBox;
    @FXML
    private ComboBox<String> citizenshipComboBox;
    @FXML
    private TextField doubleCitizenshipTextField;
    @FXML
    private TextField nationTextField;
    @FXML
    private CheckBox noAnswerCheckBox;
    @FXML
    private ComboBox<String> educationComboBox;
    @FXML
    private ComboBox<String> educationTypeComboBox;
    @FXML
    private ComboBox<String> readAndWriteComboBox;
    @FXML
    private ComboBox<String> degreeComboBox;
    @FXML
    private ComboBox<String> areYouStudyingComboBox;
    @FXML
    private ComboBox<String> kindergardenComboBox;
    @FXML
    private CheckBox signLanguageCheckBox;
    @FXML
    private TextField firstLanguageTextField;
    @FXML
    private TextField secondLanguageTextField;
    @FXML
    private TextField thirdLanguageTextField;
    @FXML
    private TextField motherTongueTextField;
    @FXML
    private TextField manySourcesTextField;
    @FXML
    private ComboBox<String> workComboBox;
    @FXML
    private ComboBox<String> positionComboBox;
    @FXML
    private ComboBox<String> yourSubjectComboBox;
    @FXML
    private ComboBox<String> inCountryComboBox;
    @FXML
    private TextField whereYouWorkedTextField;
    @FXML
    private ComboBox<String> secondWorkComboBox;
    @FXML
    private ComboBox<String> haveYouLookedComboBox;
    @FXML
    private ComboBox<String> whyNotLookingComboBox;
    @FXML
    private ComboBox<String> areYouReadyComboBox;
    @FXML
    private TextField reasonTextField;
    @FXML
    private TextField yearOfArrivalTextField;
    @FXML
    private TextField subjectBeforeTextField;
    @FXML
    private ComboBox<String> typeOfLocalityComboBox;
    @FXML
    private TextField childrenTextField;
    @FXML
    private TextField childMonthTextField;
    @FXML
    private TextField childYearTextField;
    @FXML
    private CheckBox workCheckBox;
    @FXML
    private CheckBox farmCheckBox;
    @FXML
    private CheckBox feeCheckBox;
    @FXML
    private CheckBox pensionCheckBox;
    @FXML
    private CheckBox disabilityCheckBox;
    @FXML
    private CheckBox gratuityCheckBox;
    @FXML
    private CheckBox benefitCheckBox;
    @FXML
    private CheckBox anotherCheckBox;
    @FXML
    private CheckBox savingsCheckBox;
    @FXML
    private CheckBox leaseCheckBox;
    @FXML
    private CheckBox alimonyCheckBox;
    @FXML
    private CheckBox otherSourceCheckBox;
    @FXML
    private TextField otherSourceTextField;
    @FXML
    private ComboBox<String> russianComboBox;
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
    @FXML
    private Label seventeenthLabel;
    @FXML
    private Label eighteenthLabel;
    @FXML
    private Label nineteenthLabel;
    @FXML
    private Label twentiethLabel;
    @FXML
    private Label errorLabel;
    @FXML
    private Label errorLabel1;
    @FXML
    private Label errorLabel2;
    @FXML
    private Label twentySecondLabel;
    @FXML
    private Label twentyThirdLabel;
    @FXML
    private Label twentyFourthLabel;
    @FXML
    private Label twentyFifthLabel;
    @FXML
    private Label twentySixthLabel;
    @FXML
    private Label twentySeventhLabel;
    @FXML
    private Label twentyEighthLabel;
    @FXML
    private Label twentyNinethLabel;
    @FXML
    private Label thirtiethLabel;
    @FXML
    private Label thirtyFirstLabel;
    @FXML
    private Label thirtySecondLabel;
    @FXML
    private Label thirtyThirdLabel;
    @FXML
    private Label thirtyFourthLabel;
    @FXML
    private Label thirtyFifthLabel;
    @FXML
    private Label thirtySixthLabel;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label errorLabel3;
    //endregion

    //region FXML Methods
    @FXML
    private void noAnswerCheckBoxOnClick() {
        if (noAnswerCheckBox.isSelected()) {
            nationTextField.setDisable(true);
        } else {
            nationTextField.setDisable(false);
        }
    }
    @FXML
    private void otherSourceCheckBoxOnClick() {
        if (otherSourceCheckBox.isSelected()) {
            fifteenthLabel.setDisable(false);
            otherSourceTextField.setDisable(false);
        } else {
            fifteenthLabel.setDisable(true);
            otherSourceTextField.setDisable(true);
        }
        checkBoxCheck();
    }
    @FXML
    private void areYouStudying() {
        if (ageTextField.getText().equals(""))
            return;
        if (checkNumberInRange(ageTextField.getText(), 6, 50)) {
            ninthLabel.setDisable(false);
            tenthLabel.setDisable(false);
            areYouStudyingComboBox.setDisable(false);
        } else {
            ninthLabel.setDisable(true);
            tenthLabel.setDisable(true);
            areYouStudyingComboBox.setDisable(true);
        }
        if (checkNumberInRange(ageTextField.getText(), 15, 200) &&
                sexComboBox.getSelectionModel().getSelectedIndex() == 1) {
            femaleAgeCheck(false);
        } else {
            femaleAgeCheck(true);
        }
        if (checkNumberInRange(ageTextField.getText(), 15, 72)) {
            switchElevenPointOne(false);
        } else {
            switchElevenPointOne(true);
        }

    }
    @FXML
    private void areYouInKindergarden() {
        if (ageTextField.getText().equals(""))
            return;
        if (checkNumberInRange(ageTextField.getText(), 0, 10) &&
                areYouStudyingComboBox.getSelectionModel().getSelectedIndex() == 1) {
            kindergardenComboBox.setDisable(false);
            eleventhLabel.setDisable(false);
            twelfthLabel.setDisable(false);
        } else {
            kindergardenComboBox.setDisable(true);
            eleventhLabel.setDisable(true);
            twelfthLabel.setDisable(true);
        }
    }
    @FXML
    private void checkBoxCheck() {
        if (checkBoxChecking() > 1) {
            thirteenthLabel.setDisable(false);
            fourteenthLabel.setDisable(false);
            manySourcesTextField.setDisable(false);
        } else {
            thirteenthLabel.setDisable(true);
            fourteenthLabel.setDisable(true);
            manySourcesTextField.setDisable(true);
        }
    }
    @FXML
    private void workComboBoxOnClick() {
        switch (workComboBox.getSelectionModel().getSelectedIndex()) {
            case 1: {
                thirtySixthLabel.setDisable(false);
                haveYouLookedComboBox.setDisable(false);
                switchElevenPointTwo(true);
                switchElevenPointThree(true);
                switchElevenPointFour(true);
                break;
            }
            case 0: {
                switchElevenPointTwo(false);
                switchElevenPointFour(false);
                switchElevenPointFive(true);
                thirtyFourthLabel.setDisable(false);
                yourSubjectComboBox.setDisable(false);
            }
        }
    }
    @FXML
    private void cancelButtonOnClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void submitButtonOnClick() {
        checkErrorLabel();
        if (!errorLabel3.isVisible()) {
            createHuman();
            if (human.getCitizenship() == 3 || human.getCitizenship() == 4) {
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Успех");
                alert.setHeaderText("Человек успешно добавлен, но был указан как мигрант. " +
                        "Пожалуйста, заполните опросный лист формы П.");
                alert.showAndWait();
                alert.setOnCloseRequest((DialogEvent e) -> {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/FormP.fxml"));
                        Stage stageTwo = new Stage();
                        Parent root = fxmlLoader.load();

                        FormPController controller = fxmlLoader.getController();
                        controller.setResultID(resultId);

                        Scene scene = new Scene(root);
                        stageTwo.setScene(scene);
                        stageTwo.show();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                });
            } else {
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Успех");
                alert.setHeaderText("Человек успешно добавлен.");
                alert.showAndWait();
            }
        }
    }
    //endregion

    //region Initializers
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readHostAndPort();

        initializeComboBoxes();
        addListenersToComboBoxes();
        addListenersToTextFields();
    }

    private void initializeComboBoxes() {
        relationsComboBox.getItems().removeAll(relationsComboBox.getItems());
        relationsComboBox.getItems().addAll(relativesOptions);
        sexComboBox.getItems().removeAll(sexComboBox.getItems());
        sexComboBox.getItems().addAll(sexOptions);
        marriageComboBox.getItems().removeAll(marriageComboBox.getItems());
        marriageComboBox.getItems().addAll(weddingOptions);
        registratedComboBox.getItems().removeAll(registratedComboBox.getItems());
        registratedComboBox.getItems().addAll(yesNoOptions);
        citizenshipComboBox.getItems().removeAll(citizenshipComboBox.getItems());
        citizenshipComboBox.getItems().addAll(citizenshipOptions);
        educationComboBox.getItems().removeAll(educationComboBox.getItems());
        educationComboBox.getItems().addAll(educationOptions);
        educationTypeComboBox.getItems().removeAll(educationTypeComboBox.getItems());
        educationTypeComboBox.getItems().addAll(higherOptions);
        readAndWriteComboBox.getItems().removeAll(readAndWriteComboBox.getItems());
        readAndWriteComboBox.getItems().addAll(yesNoOptions);
        degreeComboBox.getItems().removeAll(degreeComboBox.getItems());
        degreeComboBox.getItems().addAll(degreeOptions);
        areYouStudyingComboBox.getItems().removeAll(areYouStudyingComboBox.getItems());
        areYouStudyingComboBox.getItems().addAll(yesNoOptions);
        kindergardenComboBox.getItems().removeAll(kindergardenComboBox.getItems());
        kindergardenComboBox.getItems().addAll(yesNoOptions);
        russianComboBox.getItems().removeAll(russianComboBox.getItems());
        russianComboBox.getItems().addAll(yesNoOptions);
        workComboBox.getItems().removeAll(workComboBox.getItems());
        workComboBox.getItems().addAll(yesNoOptions);
        positionComboBox.getItems().removeAll(positionComboBox.getItems());
        positionComboBox.getItems().addAll(positionOptions);
        yourSubjectComboBox.getItems().removeAll(yourSubjectComboBox.getItems());
        yourSubjectComboBox.getItems().addAll(yesNoOptions);
        inCountryComboBox.getItems().removeAll(inCountryComboBox.getItems());
        inCountryComboBox.getItems().addAll(yesNoOptions);
        secondWorkComboBox.getItems().removeAll(secondWorkComboBox.getItems());
        secondWorkComboBox.getItems().addAll(yesNoOptions);
        haveYouLookedComboBox.getItems().removeAll(haveYouLookedComboBox.getItems());
        haveYouLookedComboBox.getItems().addAll(yesNoOptions);
        whyNotLookingComboBox.getItems().removeAll(whyNotLookingComboBox.getItems());
        whyNotLookingComboBox.getItems().addAll(reasonOptions);
        areYouReadyComboBox.getItems().removeAll(areYouReadyComboBox.getItems());
        areYouReadyComboBox.getItems().addAll(yesNoOptions);
        typeOfLocalityComboBox.getItems().removeAll(typeOfLocalityComboBox.getItems());
        typeOfLocalityComboBox.getItems().addAll(localityOptions);
        migrationComboBox.getItems().removeAll(migrationComboBox.getItems());
        migrationComboBox.getItems().addAll(migrationOptions);
    }

    private void addListenersToComboBoxes() {
        relationsComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (relationsComboBox.getSelectionModel().getSelectedIndex()) {
                case 10: {
                    firstLabel.setDisable(false);
                    secondLabel.setDisable(false);
                    whoItIsTextField.setDisable(false);
                    break;
                }
                default: {
                    firstLabel.setDisable(true);
                    secondLabel.setDisable(true);
                    whoItIsTextField.setDisable(true);
                    whoItIsTextField.clear();
                    break;
                }
            }
        });

        marriageComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (marriageComboBox.getSelectionModel().getSelectedIndex()) {
                case 0: {
                    thirdLabel.setDisable(false);
                    registratedComboBox.setDisable(false);
                    break;
                }
                default: {
                    thirdLabel.setDisable(true);
                    registratedComboBox.setDisable(true);
                    registratedComboBox.setValue("");
                    break;
                }
            }
        });

        sexComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (sexComboBox.getSelectionModel().getSelectedIndex()) {
                case 0: {
                    femaleAgeCheck(true);
                    break;
                }
                case 1: {
                    if (checkNumberInRange(ageTextField.getText(), 15, 200) &&
                            sexComboBox.getSelectionModel().getSelectedIndex() == 1) {
                        femaleAgeCheck(false);
                    } else {
                        femaleAgeCheck(true);
                    }
                }
            }
        });

        citizenshipComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (citizenshipComboBox.getSelectionModel().getSelectedIndex()) {
                case 1: {
                    doubleCitizenshipTextField.setDisable(false);
                    fourthLabel.setDisable(false);
                    break;
                }
                case 2: {
                    doubleCitizenshipTextField.setDisable(false);
                    fourthLabel.setDisable(false);
                    break;
                }
                default: {
                    doubleCitizenshipTextField.setDisable(true);
                    doubleCitizenshipTextField.clear();
                    fourthLabel.setDisable(true);
                    break;
                }
            }
        });

        educationComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (educationComboBox.getSelectionModel().getSelectedIndex()) {
                case 6: {
                    educationTypeComboBox.setDisable(false);
                    fifthLabel.setDisable(false);
                    readAndWriteComboBox.setDisable(true);
                    readAndWriteComboBox.setValue("");
                    sixthLabel.setDisable(true);
                    seventhLabel.setDisable(false);
                    eighthLabel.setDisable(false);
                    degreeComboBox.setDisable(false);
                    break;
                }
                case 7: {
                    educationTypeComboBox.setDisable(true);
                    educationTypeComboBox.setValue("");
                    fifthLabel.setDisable(true);
                    readAndWriteComboBox.setDisable(true);
                    readAndWriteComboBox.setValue("");
                    sixthLabel.setDisable(true);
                    seventhLabel.setDisable(false);
                    eighthLabel.setDisable(false);
                    degreeComboBox.setDisable(false);
                    break;
                }
                case 8: {
                    educationTypeComboBox.setDisable(true);
                    educationTypeComboBox.setValue("");
                    fifthLabel.setDisable(true);
                    readAndWriteComboBox.setDisable(false);
                    sixthLabel.setDisable(false);
                    seventhLabel.setDisable(true);
                    eighthLabel.setDisable(true);
                    degreeComboBox.setDisable(true);
                    degreeComboBox.setValue("");
                    break;
                }
                default: {
                    educationTypeComboBox.setDisable(true);
                    educationTypeComboBox.setValue("");
                    fifthLabel.setDisable(true);
                    readAndWriteComboBox.setDisable(true);
                    readAndWriteComboBox.setValue("");
                    sixthLabel.setDisable(true);
                    seventhLabel.setDisable(true);
                    eighthLabel.setDisable(true);
                    degreeComboBox.setDisable(true);
                    degreeComboBox.setValue("");
                    break;
                }
            }
        });

        yourSubjectComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (yourSubjectComboBox.getSelectionModel().getSelectedIndex()) {
                case 0: {
                    inCountryComboBox.setDisable(true);
                    sixteenthLabel.setDisable(true);
                    whereYouWorkedTextField.setDisable(true);
                    seventeenthLabel.setDisable(true);
                    break;
                }
                case 1: {
                    inCountryComboBox.setDisable(false);
                    sixteenthLabel.setDisable(false);
                    break;
                }
            }
        });

        inCountryComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (inCountryComboBox.getSelectionModel().getSelectedIndex()) {
                case 0: {
                    whereYouWorkedTextField.setDisable(true);
                    seventeenthLabel.setDisable(true);
                    break;
                }
                case 1: {
                    whereYouWorkedTextField.setDisable(false);
                    seventeenthLabel.setDisable(false);
                    break;
                }
            }
        });

        haveYouLookedComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (haveYouLookedComboBox.getSelectionModel().getSelectedIndex()) {
                case 0: {
                    eighteenthLabel.setDisable(false);
                    areYouReadyComboBox.setDisable(false);
                    nineteenthLabel.setDisable(true);
                    whyNotLookingComboBox.setDisable(true);
                    twentiethLabel.setDisable(true);
                    reasonTextField.setDisable(true);
                    break;
                }
                case 1: {
                    eighteenthLabel.setDisable(true);
                    areYouReadyComboBox.setDisable(true);
                    nineteenthLabel.setDisable(false);
                    whyNotLookingComboBox.setDisable(false);
                    break;
                }
            }
        });

        whyNotLookingComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (whyNotLookingComboBox.getSelectionModel().getSelectedIndex()) {
                case 4: {
                    twentiethLabel.setDisable(false);
                    reasonTextField.setDisable(false);
                    break;
                }
                default: {
                    twentiethLabel.setDisable(true);
                    reasonTextField.setDisable(true);
                    break;
                }
            }
        });

        migrationComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (migrationComboBox.getSelectionModel().getSelectedIndex()) {
                case 0: {
                    twentyFirstLabel.setDisable(true);
                    yearOfArrivalTextField.setDisable(true);
                    switchTwelvePointTwo(true);
                    break;
                }
                case 1: {
                    twentyFirstLabel.setDisable(true);
                    yearOfArrivalTextField.setDisable(true);
                    switchTwelvePointTwo(true);
                    break;
                }
                case 2: {
                    twentyFirstLabel.setDisable(false);
                    yearOfArrivalTextField.setDisable(false);
                    switchTwelvePointTwo(false);
                    break;
                }
            }
        });

    }

    private void addListenersToTextFields() {
        createNumericListener(ageTextField);
        createYearListener(childMonthTextField);
        createYearListener(childYearTextField);

        dayTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                dayTextField.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                checkDayTextField();
            }

        });

        monthTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                monthTextField.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                if (!checkNumberInRange(newValue, 1, 12)) {
                    errorLabel.setVisible(true);
                } else {
                    checkDayTextField();
                    errorLabel.setVisible(false);
                }
            }
        });

        yearTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                yearTextField.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                if (!checkNumberInRange(newValue, 1880, 2010)) {
                    errorLabel.setVisible(true);
                } else {
                    checkDayTextField();
                    errorLabel.setVisible(false);
                }
            }
        });

        yearOfArrivalTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                yearOfArrivalTextField.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                if (!checkNumberInRange(newValue, 1880, 2010)) {
                    errorLabel1.setVisible(true);
                } else {
                    errorLabel1.setVisible(false);
                }
            }
        });

        childrenTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                childrenTextField.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                if (checkNumberInRange(newValue, 0, 0)) {
                    switchThirteenPointTwo(true);
                } else {
                    switchThirteenPointTwo(false);
                }
            }
            if (childrenTextField.getText().equals("")) {
                switchThirteenPointTwo(true);
            }
        });

    }

    private void createYearListener(TextField textField){
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            } else {
                if (!checkNumberInRange(newValue, 1900, 2010)) {
                    if (!checkNumberInRange(newValue, 1, 12)) {
                        errorLabel2.setVisible(true);
                    }
                } else {
                    errorLabel2.setVisible(false);
                }
            }
        });
    }
    //endregion

    //region Switchers
    private void switchElevenPointOne(boolean switcher) {
        thirtiethLabel.setDisable(switcher);
        thirtyFirstLabel.setDisable(switcher);
        thirtySecondLabel.setDisable(switcher);
        workComboBox.setDisable(switcher);
    }

    private void switchElevenPointTwo(boolean switcher) {
        thirtyThirdLabel.setDisable(switcher);
        positionComboBox.setDisable(switcher);
    }

    private void switchElevenPointThree(boolean switcher) {
        thirtyFourthLabel.setDisable(switcher);
        sixteenthLabel.setDisable(switcher);
        seventeenthLabel.setDisable(switcher);
        yourSubjectComboBox.setDisable(switcher);
        inCountryComboBox.setDisable(switcher);
        whereYouWorkedTextField.setDisable(switcher);
    }

    private void switchElevenPointFour(boolean switcher) {
        thirtyFifthLabel.setDisable(switcher);
        secondWorkComboBox.setDisable(switcher);
    }

    private void switchElevenPointFive(boolean switcher) {
        thirtySixthLabel.setDisable(switcher);
        nineteenthLabel.setDisable(switcher);
        eighteenthLabel.setDisable(switcher);
        twentiethLabel.setDisable(switcher);
        haveYouLookedComboBox.setDisable(switcher);
        whyNotLookingComboBox.setDisable(switcher);
        areYouReadyComboBox.setDisable(switcher);
        reasonTextField.setDisable(switcher);
    }

    private void switchTwelvePointTwo(boolean switcher) {
        twentySecondLabel.setDisable(switcher);
        twentyThirdLabel.setDisable(switcher);
        twentyFourthLabel.setDisable(switcher);
        typeOfLocalityComboBox.setDisable(switcher);
        subjectBeforeTextField.setDisable(switcher);
    }

    private void switchThirteenPointTwo(boolean switcher) {
        twentySeventhLabel.setDisable(switcher);
        twentyEighthLabel.setDisable(switcher);
        twentyNinethLabel.setDisable(switcher);
        childMonthTextField.setDisable(switcher);
        childYearTextField.setDisable(switcher);
    }
    //endregion

    //region GETs
    private void getPartA() {
        human.setHouseholdId(resultId);
        human.setBirthDate(Date.valueOf(yearTextField.getText() + "-" + monthTextField.getText() + "-" +
                dayTextField.getText()));
        human.setWhoIs(relationsComboBox.getSelectionModel().getSelectedIndex());
        human.setMarriage(marriageComboBox.getSelectionModel().getSelectedIndex());
        human.setSex(getBool(sexComboBox));
        human.setBirthPlace(birthplaceTextField.getText());
        human.setRussian(getBool(russianComboBox));
        human.setOtherLang(getLanguages());
        human.setMotherTongue(motherTongueTextField.getText());
        human.setCitizenship(citizenshipComboBox.getSelectionModel().getSelectedIndex());
        human.setNationality(getNation());

        if (!doubleCitizenshipTextField.isDisabled()){
            human.setDoubleCitizenship(doubleCitizenshipTextField.getText());
        }

        if (!registratedComboBox.isDisable()) {
            human.setRegistratedMarriage(getBool(registratedComboBox));
        }

        if (!whoItIsTextField.isDisabled()){
            human.setWhoIsString(whoItIsTextField.getText());
        }

        if(!readAndWriteComboBox.isDisable()) {
            human.setReadnWrite(getBool(readAndWriteComboBox));
        }

        if (!educationTypeComboBox.isDisable()) {
            human.setEducation(educationComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!degreeComboBox.isDisable()){
            human.setScienceGrade(degreeComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!areYouStudyingComboBox.isDisable()) {
            human.setDoYouStudy(getBool(areYouStudyingComboBox));
        }

        if (!kindergardenComboBox.isDisable()) {
            human.setPrimarySchool(getBool(kindergardenComboBox));
        }
    }

    private void getPartB(int number){
        human.setSalarySources(number);
        if (!manySourcesTextField.isDisabled()){
            human.setMainSource(Integer.parseInt(manySourcesTextField.getText()));
        }

        if (!workComboBox.isDisabled()){
            human.setOctoberSalary(getBool(workComboBox));
        }

        if (!childYearTextField.isDisabled()){
            String one = childYearTextField.getText();
            String two = childMonthTextField.getText();
            String kek = one + "-" + two + "-01";
            human.setFirstChildBirthdate(Date.valueOf(kek));
        }

        if (!positionComboBox.isDisabled()){
            human.setPosition(positionComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!yourSubjectComboBox.isDisabled()){
            human.setWorkNear(getBool(yourSubjectComboBox));
        }

        if (!inCountryComboBox.isDisabled()){
            human.setWorkInRf(getBool(inCountryComboBox));
        }

        if (!whereYouWorkedTextField.isDisabled()) {
            human.setWorkNotRf(whereYouWorkedTextField.getText());
        }

        if (!secondWorkComboBox.isDisabled()) {
            human.setSecondJob(getBool(secondWorkComboBox));
        }

        if (!haveYouLookedComboBox.isDisabled()){
            human.setLookingForJob(getBool(haveYouLookedComboBox));
        }

        if (!areYouReadyComboBox.isDisabled()){
            human.setNear2Weeks(getBool(areYouReadyComboBox));
        }

        if (!whyNotLookingComboBox.isDisabled()){
            human.setWhyNotLooking(whyNotLookingComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!migrationComboBox.isDisabled()){
            human.setLiveSinceBirth(migrationComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!yearOfArrivalTextField.isDisabled()){
            human.setYearWhereLive(Date.valueOf(yearOfArrivalTextField.getText() + "-0-0"));
        }

        if (!subjectBeforeTextField.isDisabled()) {
            human.setPlaceWhereLive(subjectBeforeTextField.getText());
        }

        if (!typeOfLocalityComboBox.isDisabled()) {
            human.setTypePlace(typeOfLocalityComboBox.getSelectionModel().getSelectedIndex());
        }

        if (!childrenTextField.isDisabled()){
            human.setChildCount(Integer.parseInt(childrenTextField.getText()));
        }

    }

    private String getNation(){
        if (noAnswerCheckBox.isSelected()){
            return "Отказ от ответа";
        } else {
            return nationTextField.getText();
        }
    }

    private String getLanguages(){
        String result="";
        String temp = "";
        if (!firstLanguageTextField.getText().isEmpty()){
            temp = firstLanguageTextField.getText();
            temp = temp.substring(0,1).toUpperCase() + temp.substring(1).toLowerCase();
            result += temp;
        }
        if (!secondLanguageTextField.getText().isEmpty()){
            temp = secondLanguageTextField.getText();
            temp = temp.substring(0,1).toUpperCase() + temp.substring(1).toLowerCase();
            result += ", " + temp;
        }
        if (!thirdLanguageTextField.getText().isEmpty()){
            temp = thirdLanguageTextField.getText();
            temp = temp.substring(0,1).toUpperCase() + temp.substring(1).toLowerCase();
            result += ", " + temp;
        }
        if (signLanguageCheckBox.isSelected()){
            result += ", Язык жестов";
        }
        return result;
    }
    //endregion

    //region Checkers
    private void checkDayTextField() {
        if (dayTextField.getText().equals("") && monthTextField.getText().equals("") &&
                yearTextField.getText().equals(""))
            return;
        switch (Integer.parseInt(dayTextField.getText())) {
            case 29: {
                if (Integer.parseInt(monthTextField.getText()) == 2 &&
                        !isLeapYear(Integer.parseInt(yearTextField.getText()))) {
                    errorLabel.setVisible(true);
                } else {
                    errorLabel.setVisible(false);
                }
                break;
            }
            case 30: {
                if (Integer.parseInt(monthTextField.getText()) == 4 || Integer.parseInt(monthTextField.getText()) == 6 ||
                        Integer.parseInt(monthTextField.getText()) == 9 || Integer.parseInt(monthTextField.getText()) == 11) {
                    errorLabel.setVisible(false);
                } else {
                    errorLabel.setVisible(true);
                }
                break;
            }
            case 31: {
                if (Integer.parseInt(monthTextField.getText()) == 1 || Integer.parseInt(monthTextField.getText()) == 3 ||
                        Integer.parseInt(monthTextField.getText()) == 5 || Integer.parseInt(monthTextField.getText()) == 7 ||
                        Integer.parseInt(monthTextField.getText()) == 8 || Integer.parseInt(monthTextField.getText()) == 10 ||
                        Integer.parseInt(monthTextField.getText()) == 12) {
                    errorLabel.setVisible(false);
                } else {
                    errorLabel.setVisible(true);
                }
                break;
            }
            default: {
                if (checkNumberInRange(dayTextField.getText(), 1, 28)) {
                    errorLabel.setVisible(false);
                } else {
                    errorLabel.setVisible(true);
                }
                break;
            }
        }
    }

    private int checkBoxChecking() {
        int temp = 0;
        if (workCheckBox.isSelected()) {
            temp++;
        }
        if (farmCheckBox.isSelected()) {
            temp++;
        }
        if (feeCheckBox.isSelected()) {
            temp++;
        }
        if (pensionCheckBox.isSelected()) {
            temp++;
        }
        if (disabilityCheckBox.isSelected()) {
            temp++;
        }
        if (gratuityCheckBox.isSelected()) {
            temp++;
        }
        if (benefitCheckBox.isSelected()) {
            temp++;
        }
        if (anotherCheckBox.isSelected()) {
            temp++;
        }
        if (savingsCheckBox.isSelected()) {
            temp++;
        }
        if (leaseCheckBox.isSelected()) {
            temp++;
        }
        if (alimonyCheckBox.isSelected()) {
            temp++;
        }
        if (otherSourceCheckBox.isSelected()) {
            temp++;
        }
        return temp;
    }

    private void checkErrorLabel() {
        if (!partAErrorCheck() && !partBErrorCheck()){
            errorLabel3.setVisible(true);
        } else {
            errorLabel3.setVisible(false);
        }
    }

    private void femaleAgeCheck(boolean switcher) {
        twentyFifthLabel.setDisable(switcher);
        twentySixthLabel.setDisable(switcher);

        childrenTextField.setDisable(switcher);
    }

    private boolean partAErrorCheck() {
        if (dayTextField.getText().isEmpty()) {
            return false;
        } else if (monthTextField.getText().isEmpty()) {
            return false;
        } else if (yearTextField.getText().isEmpty()) {
            return false;
        } else if (ageTextField.getText().isEmpty()) {
            return false;
        } else if (errorLabel.isVisible()){
            return false;
        } else if (birthplaceTextField.getText().isEmpty()) {
            return false;
        } else if (checkErrorNation()) {
                return false;
        } else if (motherTongueTextField.getText().isEmpty()) {
            return false;
        } else if (doubleCitizenshipTextField.getText().isEmpty() && !doubleCitizenshipTextField.isDisabled()) {
            return false;
        } else if (whoItIsTextField.getText().isEmpty() && !whoItIsTextField.isDisabled()) {
            return false;
        } else if (relationsComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (sexComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (marriageComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (!registratedComboBox.isDisable() && registratedComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (!citizenshipComboBox.isDisable() && citizenshipComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (educationComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (!educationTypeComboBox.isDisable() &&
                educationTypeComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (!readAndWriteComboBox.isDisable() &&
                readAndWriteComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (russianComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (!areYouStudyingComboBox.isDisable() &&
                areYouStudyingComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else if (!degreeComboBox.isDisable() &&
                degreeComboBox.getSelectionModel().getSelectedIndex() == -1) {
            return false;
        } else return kindergardenComboBox.isDisable() || sexComboBox.getSelectionModel().getSelectedIndex() != -1;
    }

    private boolean partBErrorCheck(){
        if (whereYouWorkedTextField.getText().isEmpty() && !whereYouWorkedTextField.isDisabled()) {
            return false;
        } else if (reasonTextField.getText().isEmpty() && !reasonTextField.isDisabled()){
            return false;
        } else if (yearOfArrivalTextField.getText().isEmpty() && !yearOfArrivalTextField.isDisabled()){
            return false;
        } else if (childMonthTextField.getText().isEmpty() && !childMonthTextField.isDisabled()){
            return false;
        } else if (childrenTextField.getText().isEmpty() && !childrenTextField.isDisabled()){
            return false;
        } else if (childYearTextField.getText().isEmpty() && !childYearTextField.isDisabled()){
            return false;
        } else if (otherSourceTextField.getText().isEmpty() && !otherSourceTextField.isDisabled()){
            return false;
        } else if (subjectBeforeTextField.getText().isEmpty()){
            return false;
        }else if (!workComboBox.isDisable() &&
                workComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else if (!positionComboBox.isDisable() &&
                positionComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else if (!inCountryComboBox.isDisable() &&
                inCountryComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else if (!yourSubjectComboBox.isDisable() &&
                yourSubjectComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else if (!secondWorkComboBox.isDisable() &&
                secondWorkComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else if (!haveYouLookedComboBox.isDisable() &&
                haveYouLookedComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else if (!whyNotLookingComboBox.isDisable() &&
                whyNotLookingComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else if (!areYouReadyComboBox.isDisable() &&
                areYouReadyComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else if (!typeOfLocalityComboBox.isDisable() &&
                typeOfLocalityComboBox.getSelectionModel().getSelectedIndex() == -1){
            return false;
        } else return migrationComboBox.getSelectionModel().getSelectedIndex() != -1;
    }
    //endregion

    private void createHuman(){
        human = new dbHumantableEntity();
        salary = new dbSalariestableEntity();
        createSalaries();
        int id = addSalaries();
        if (id == -1){
            throw new IllegalArgumentException("Ошибка при создании записи об источниках дохода");
        } else {
            getPartA();
            getPartB(id);
            addRegularObject("setNewHuman", human);
        }
    }

    private int addSalaries(){
        try {
            int salariesId;
            Socket socket = new Socket(host, port);

            DataOutputStream type = new DataOutputStream(socket.getOutputStream());

            type.writeUTF("database");
            type.flush();

            DataOutputStream command = new DataOutputStream(socket.getOutputStream());

            command.writeUTF("setNewSalary");
            command.flush();

            DataInputStream id = new DataInputStream(socket.getInputStream());
            ObjectOutputStream object = new ObjectOutputStream(socket.getOutputStream());

            object.writeObject(salary);
            object.flush();

            salariesId = id.readInt();

            command.close();
            id.close();
            object.close();

            return salariesId;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void createSalaries(){
        if (workCheckBox.isSelected()){
            salary.setWork(true);
        }
        if (farmCheckBox.isSelected()){
            salary.setFarm(true);
        }
        if (feeCheckBox.isSelected()){
            salary.setGrants(true);
        }
        if (pensionCheckBox.isSelected()){
            salary.setPension(true);
        }
        if (disabilityCheckBox.isSelected()){
            salary.setDisabled(true);
        }
        if (gratuityCheckBox.isSelected()){
            salary.setAllowance(true);
        }
        if (benefitCheckBox.isSelected()){
            salary.setUnemployment(true);
        }
        if (anotherCheckBox.isSelected()){
            salary.setGovSupport(true);
        }
        if (savingsCheckBox.isSelected()){
            salary.setSavings(true);
        }
        if (leaseCheckBox.isSelected()){
            salary.setLeasing(true);
        }
        if (alimonyCheckBox.isSelected()){
            salary.setAlimony(true);
        }
        if (otherSourceCheckBox.isSelected()){
            salary.setOther(true);
        }
        if (!otherSourceTextField.isDisabled()){
            salary.setOtherString(otherSourceTextField.getText());
        }
    }

    private boolean checkErrorNation(){
        return !noAnswerCheckBox.isSelected() && nationTextField.getText().isEmpty();
    }

}
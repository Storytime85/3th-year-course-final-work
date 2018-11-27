package views;

import entities.UsersEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistence.abstracts.FormControllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationFormController extends FormControllers implements Initializable {

    private UsersEntity newUser;

    //region FXML Fields
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField patronimicTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField serialTextField;
    @FXML
    private TextField passportTextField;
    @FXML
    private TextField codeTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField repeatPasswordTextField;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label label;
    //endregion

    //region Initializers
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTextFields();
    }

    private void initializeTextFields(){
        createNumericListener(codeTextField);
        createNumericListener(passportTextField);
        createNumericListener(serialTextField);
    }
    //endregion

    //region FXML Methods
    @FXML
    private void cancelButtonClick(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        try {
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Login.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void submitButtonClick(){
        if(checkTextFields()) {
            label.setVisible(false);
        } else {
            label.setVisible(true);
        }
        if (label.isVisible()){
            return;
        } else {
            boolean tempBoolean = false;
            setPerson();
            try(Socket socket = new Socket("localhost", 3345)) {
                DataOutputStream type = new DataOutputStream(socket.getOutputStream());

                type.writeUTF("registration");
                type.flush();

                ObjectOutputStream userOut = new ObjectOutputStream(socket.getOutputStream());
                DataInputStream connected = new DataInputStream(socket.getInputStream());
                userOut.writeObject(newUser);
                userOut.flush();
                tempBoolean=connected.readBoolean();

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (tempBoolean){
                Stage stage = (Stage) submitButton.getScene().getWindow();
                try{
                    stage.close();
                    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/views/Login.fxml"));
                    Parent root1 = fxmlloader.load();
                    Stage stage1 = new Stage();
                    stage1.setScene(new Scene(root1));
                    stage1.show();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                    alert.setTitle("Регистрация");
                    alert.setHeaderText(null);
                    alert.setContentText("Регистрация проведена успешно");

                    alert.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    @FXML
    private void enterKeyPressed(){
        anchorPane.setOnKeyPressed(this::handle);
    }
    //endregion

    private void setPerson (){
        newUser = new UsersEntity();
        newUser.setUserName(nameTextField.getText());
        newUser.setUserLastname(lastnameTextField.getText());
        newUser.setUserPatrenimic(patronimicTextField.getText());
        newUser.setCode(Integer.parseInt(codeTextField.getText()));
        newUser.setPassport(Integer.parseInt(serialTextField.getText()));
        newUser.setSerial(Integer.parseInt(passportTextField.getText()));
        newUser.setUserEmail(emailTextField.getText());
        newUser.setPassword(passwordTextField.getText());
        newUser.setPermissions(3);
    }

    private void handle(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            submitButtonClick();
        }
    }

    private boolean checkTextFields(){
        if (nameTextField.getText().isEmpty()||lastnameTextField.getText().isEmpty()||
                patronimicTextField.getText().isEmpty()){
            return false;
        } else if (serialTextField.getText().length()!=4 || passportTextField.getText().length()!=6||
                codeTextField.getText().length()!=6){
            return false;
        } else if (!passwordTextField.getText().equals(repeatPasswordTextField.getText())){
            return false;
        } else return !emailTextField.getText().isEmpty();
    }
}

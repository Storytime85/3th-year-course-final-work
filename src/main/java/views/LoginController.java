package views;

import entities.UsersEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import persistence.abstracts.FormControllers;

import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class LoginController extends FormControllers implements Initializable {
    private UsersEntity newPerson;
    private boolean isConnected;

    //region FXML Fields
    @FXML
    private Button submitButton;
    @FXML
    private Button secondButton;
    @FXML
    private TextField loginBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private Label errorLabel;
    //endregion

    //region FXML Methods
    @FXML
    private void submitButtonOnClick() throws IOException {
        errorLabel.setVisible(false);
        Stage stage = (Stage) submitButton.getScene().getWindow();
        try {
            Socket socket = new Socket(host, port);
            DataOutputStream type = new DataOutputStream(socket.getOutputStream());

            type.writeUTF("login");
            type.flush();

            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            DataInputStream connected = new DataInputStream(socket.getInputStream());

            output.writeUTF(loginBox.getText());
            output.flush();
            output.writeUTF(passwordBox.getText());
            output.flush();
            isConnected = connected.readBoolean();
            if (isConnected) {
                newPerson = (UsersEntity) input.readObject();
            }
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.print("Земля тебе пухом");
        }
        if (isConnected) {
            switch (newPerson.getPermissions()) {
                case 1: {
                    setMainStage(stage);
                    break;
                }
                case 2: {
                    setMainStage(stage);
                    break;
                }
                case 3: {
                    setStage(stage, "/views/FormL.fxml");
                    break;
                }
                case 4: {
                    setStage(stage, "/views/FormL.fxml");
                    break;
                }
                default: {
                    throw new NullPointerException();
                }
            }
        } else {
            notifyWrongRecords();
        }
    }
    @FXML
    private void secondButtonOnClick(){
        Stage stage = (Stage) secondButton.getScene().getWindow();
        try {
            setStage(stage, "/views/RegistrationForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void notifyWrongRecords(){
        errorLabel.setVisible(true);
    }
    @FXML
    private void loginBoxOnKeyPressed(){
        loginBox.setOnKeyPressed(this::handle);
    }
    @FXML
    private void passwordBoxOnKeyPressed(){
        passwordBox.setOnKeyPressed(this::handle);
    }
    //endregion

    //region Set Stages
    private void setMainStage (Stage stage) throws IOException {
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/MainWindow.fxml"));
        Parent root1 = fxmlLoader.load();

        MainWindowController mainWindowController = fxmlLoader.getController();
        mainWindowController.setPerson(newPerson);


        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }

    private void setStage (Stage stage, String path) throws IOException {
        stage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root1 = fxmlLoader.load();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.setTitle("Регистрация");
        //stage1.getIcons().add(new Image(RegistrationFormController.class.getResourceAsStream("icon.jpg")));

        stage1.show();
    }
    //endregion

    private void handle(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            try {
                submitButtonOnClick();
            } catch (IOException es){
                es.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readHostAndPort();
    }
}

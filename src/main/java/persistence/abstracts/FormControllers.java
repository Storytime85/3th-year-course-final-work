package persistence.abstracts;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;


public abstract class FormControllers extends Lists {
    protected String host;
    protected int port;

    protected boolean getBool(ComboBox<String> box){
        return box.getSelectionModel().getSelectedIndex() == 0;
    }

    protected boolean checkNumberInRange(String number, int lower, int upper) {
        if (number.equals("")) {
            return false;
        }
        final int intNumber = Integer.parseInt(number);
        return (intNumber >= lower && intNumber <= upper);
    }

    protected boolean isLeapYear(int year) {
        int yearTwo = year % 400;
        year %= 4;
        return year == 0 && yearTwo == 0;
    }

    protected boolean addRegularObject(String command, Object object){
        try {
            Socket socket = new Socket(host, port);
            DataOutputStream type = new DataOutputStream(socket.getOutputStream());

            type.writeUTF("database");
            type.flush();

            DataOutputStream string = new DataOutputStream(socket.getOutputStream());

            string.writeUTF(command);
            string.flush();

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            output.writeObject(object);
            output.flush();

            string.close();
            output.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    protected void addObject (String command, Object object, Button submitButton){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (addRegularObject(command, object)) {
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.close();

            alert.setTitle("Успех");
            alert.setHeaderText("Информация успешно добавлена.");
            alert.showAndWait();
        } else {
            alert.setTitle("Ошибка");
            alert.setHeaderText("Непредвиденная ошибка. Повторите позже");
            alert.showAndWait();
        }
    }

    protected void readHostAndPort(){
        try{
            String filePath = new File("").getAbsolutePath();
            FileInputStream fStream = new FileInputStream(filePath.concat("/src/main/resources/config.cfg"));
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

            String strLine;

            while ((strLine = br.readLine()) != null){
                String[] line = strLine.split(":", 2);
                switch (line[0]){
                    case ("host") : {
                        host = line[1];
                        break;
                    }
                    case ("port"):{
                        String temp = line[1];
                        port = Integer.parseInt(line[1]);
                        break;
                    }
                    default :{
                        throw new IOException("Конфиг проверь.");
                    }
                }
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
    }
}

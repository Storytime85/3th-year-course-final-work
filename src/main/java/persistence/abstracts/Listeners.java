package persistence.abstracts;

import javafx.scene.control.TextField;

public abstract class Listeners {
    protected void createNumericListener(TextField textField){
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }


}

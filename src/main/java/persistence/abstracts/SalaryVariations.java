package persistence.abstracts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class SalaryVariations {
   protected final static ObservableList<String> variations = FXCollections.observableArrayList(
            "Трудовая деятельность",
           "Личное подсобное хозяйство",
           "Стипендия",
           "Пенсия",
           "Пенсия по инвалидности",
           "Пособие",
           "Пособие по безработице",
           "Другое гос. обеспечение",
           "Сбережения",
           "Сдача жилья",
           "Иждевение",
           "Иное"
           );
}

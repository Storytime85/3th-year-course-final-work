package persistence.abstracts;

import javafx.collections.ObservableList;
import java.sql.Date;
import java.util.Calendar;

public abstract class TableViews extends Lists {
    protected String getSex (boolean sex){
        if (sex){
            return sexOptions.get(0);
        } else {
            return sexOptions.get(1);
        }
    }

    protected String boolToString(Boolean bool, ObservableList<String> list){
        if (bool == null){
            return " ";
        } else if (bool){
            return list.get(0);
        } else {
            return list.get(1);
        }
    }

    protected String createAnotherType(Integer index, ObservableList<String> list, String string,
                                       Integer indexOfException){
        if (index == null){
            return " ";
        } else if (index.equals(indexOfException)){
            return string;
        } else {
            return list.get(index);
        }
    }

    protected String dateToString(Date date){
        if (date == null){
            return " ";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return String.valueOf(cal.get(Calendar.YEAR));
    }

    protected String intToString(Integer index, ObservableList<String> list){
        if (index != null){
            return list.get(index);
        } else {
            return " ";
        }
    }

    protected String intToString(Integer number){
        if (number == null){
            return " ";
        } else {
            return Integer.toString(number);
        }
    }
}

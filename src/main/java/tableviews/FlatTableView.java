package tableviews;

import entities.db.dbFlattableEntity;
import persistence.abstracts.TableViews;

public class FlatTableView extends TableViews {
    //region Fields
    int id;
    private String flatType;
    private String square;
    private String chamberCount;
    private String phone;
    private String tv;
    private String radio;
    //endregion

    //region GETTERs
    public int getId(){
        return id;
    }

    public String getFlatType() {
        return flatType;
    }

    public String getSquare() {
        return square;
    }

    public String getChamberCount() {
        return chamberCount;
    }

    public String getPhone() {
        return phone;
    }

    public String getTv() {
        return tv;
    }

    public String getRadio() {
        return radio;
    }
    //endregion

    public FlatTableView (dbFlattableEntity flat){
        id = flat.getFlatId();
        flatType = boolToString(flat.getFlatType(), livingPlaceOptions);

        square = Integer.toString(flat.getSquare());
        chamberCount = Integer.toString(flat.getChamberCount());
        phone = boolToString(flat.getPhone(), yesNoOptions);
        tv = boolToString(flat.getTv(), yesNoOptions);
        radio = boolToString(flat.getRadio(), yesNoOptions);
    }
}

package tableviews;

import entities.db.dbHouseholdtableEntity;
import persistence.abstracts.TableViews;

public class HouseholdTableView extends TableViews {
    //region Fields
    private int id;
    private String peopleCount;
    private String chamberCount;
    private String internet;
    //endregion

    //region GETTERs
    public int getId() {
        return id;
    }

    public String getPeopleCount() {
        return peopleCount;
    }

    public String getChamberCount() {
        return chamberCount;
    }

    public String getInternet() {
        return internet;
    }
    //endregion

    public HouseholdTableView (dbHouseholdtableEntity household){
        id = household.getHouseholdId();
        peopleCount = Integer.toString(household.getPeopleCount());
        chamberCount = doubleToString(household.getChamberCount());
        if (household.getInternet()){
            internet = yesNoOptions.get(0);
        } else if (!household.getInternet()){
            internet = yesNoOptions.get(1);
        } else {
            internet = " ";
        }
    }

    private String doubleToString(double chamberCount){
        if (chamberCount == 0.5){
            return Double.toString(0.5);
        } else {
            return Integer.toString((int)chamberCount);
        }
    }
}

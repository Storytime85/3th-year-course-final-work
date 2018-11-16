package tableviews;

import entities.db.dbMigrationtableEntity;
import persistence.abstracts.TableViews;

public class MigrationTableView extends TableViews {
    //region Fields
    private int id;
    private String sex;
    private String year;
    private String permanentCountry;
    private String purpose;
    private String lasting;
    private String motherCountry;
    private String citizenship;
    //endregion

    //region GETTERs
    public int getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    public String getYear() {
        return year;
    }

    public String getPermanentCountry() {
        return permanentCountry;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getLasting() {
        return lasting;
    }

    public String getMotherCountry() {
        return motherCountry;
    }

    public String getCitizenship() {
        return citizenship;
    }
    //endregion

    public MigrationTableView(dbMigrationtableEntity migrator) {
        id = migrator.getId();
        sex = getSex(migrator.getSex());
        year = dateToString(migrator.getBirthYear());
        permanentCountry = migrator.getPermanentCountry();
        lasting = checkLasting(migrator);
        motherCountry = checkNull(migrator.getMotherCountry());
        citizenship = checkNull(migrator.getCitizenship());
        purpose = checkNull(migrator.getPurposeString());
    }

    private String checkNull(String migrator){
        if (migrator != null){
            return migrator;
        } else {
            return " ";
        }
    }

    private String checkLasting (dbMigrationtableEntity migrator){
        if (migrator.getPurpose() == 6){
            return migrator.getPurposeString();
        } else {
            return purposeOptions.get(migrator.getPurpose());
        }
    }
}

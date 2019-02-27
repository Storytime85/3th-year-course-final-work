package tableviews;

import entities.db.dbHumantableEntity;
import entities.db.dbSalariestableEntity;
import persistence.abstracts.TableViews;

import java.sql.Date;
import java.util.Calendar;

public class HumanTableView extends TableViews {
    //region Fields
    private int id;
    private String whoIs;
    private String sex;
    private String birthDate;
    private String birthPlace;
    private String marriage;
    private String citizenship;
    private String nationality;
    private String education;
    private String readnWrite;
    private String scienceGrade;
    private String doYouStudy;
    private String primarySchool;
    private String russian;
    private String otherLang;
    private String motherTongue;
    private String salarySources;
    private String mainSource;
    private String octoberSalary;
    private String position;
    private String workNear;
    private String workInRf;
    private String workNotRf;
    private String secondJob;
    private String lookingForJob;
    private String near2Weeks;
    private String whyNotLooking;
    private String liveSinceBirth;
    private String yearWhereLive;
    private String placeWhereLive;
    private String typePlace;
    private String childCount;
    private String firstChildBirthdate;
    //endregion

    //region Getters
    public int getId() {
        return id;
    }

    public String getWhoIs() {
        return whoIs;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getMarriage() {
        return marriage;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getNationality() {
        return nationality;
    }

    public String getEducation() {
        return education;
    }

    public String getReadnWrite() {
        return readnWrite;
    }

    public String getScienceGrade() {
        return scienceGrade;
    }

    public String getDoYouStudy() {
        return doYouStudy;
    }

    public String getPrimarySchool() {
        return primarySchool;
    }

    public String getRussian() {
        return russian;
    }

    public String getOtherLang() {
        return otherLang;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public String getSalarySources() {
        return salarySources;
    }

    public String getMainSource() {
        return mainSource;
    }

    public String getOctoberSalary() {
        return octoberSalary;
    }

    public String getPosition() {
        return position;
    }

    public String getWorkNear() {
        return workNear;
    }

    public String getWorkInRf() {
        return workInRf;
    }

    public String getWorkNotRf() {
        return workNotRf;
    }

    public String getSecondJob() {
        return secondJob;
    }

    public String getLookingForJob() {
        return lookingForJob;
    }

    public String getNear2Weeks() {
        return near2Weeks;
    }

    public String getWhyNotLooking() {
        return whyNotLooking;
    }

    public String getLiveSinceBirth() {
        return liveSinceBirth;
    }

    public String getYearWhereLive() {
        return yearWhereLive;
    }

    public String getPlaceWhereLive() {
        return placeWhereLive;
    }

    public String getTypePlace() {
        return typePlace;
    }

    public String getChildCount() {
        return childCount;
    }

    public String getFirstChildBirthdate() {
        return firstChildBirthdate;
    }
    //endregion

    public HumanTableView (dbHumantableEntity human, dbSalariestableEntity salary){
        id = human.getHumanId();
        whoIs = createAnotherType(human.getWhoIs(), relativesOptions, human.getWhoIsString(), 9);
        sex = boolToString(human.getSex(), sexOptions);
        birthDate = createBirthDate(human.getBirthDate());
        birthPlace = human.getBirthPlace();
        citizenship = createCitizenship(human.getCitizenship(), human.getDoubleCitizenship());
        nationality = human.getNationality();
        readnWrite = boolToString(human.getReadnWrite(), yesNoOptions);
        education = intToString(human.getScienceGrade(), educationOptions);
        scienceGrade = intToString(human.getScienceGrade(), degreeOptions);
        doYouStudy = boolToString(human.getDoYouStudy(), yesNoOptions);
        primarySchool = boolToString(human.getDoYouStudy(), yesNoOptions);
        russian = boolToString(human.getDoYouStudy(), yesNoOptions);
        otherLang = human.getOtherLang();
        motherTongue =human.getMotherTongue();
        firstChildBirthdate = createFirstChildBirthDate(human.getFirstChildBirthdate());
        childCount = intToString(human.getChildCount());
        typePlace = intToString(human.getTypePlace(), localityOptions);
        placeWhereLive = human.getPlaceWhereLive();
        yearWhereLive = dateToString(human.getYearWhereLive());
        liveSinceBirth = intToString(human.getLiveSinceBirth(), migrationOptions);
        whyNotLooking = intToString(human.getWhyNotLooking(), reasonOptions);
        near2Weeks = boolToString(human.getNear2Weeks(), yesNoOptions);
        lookingForJob = boolToString(human.getLookingForJob(), yesNoOptions);
        secondJob = boolToString(human.getSecondJob(), yesNoOptions);
        workNotRf = human.getWorkNotRf();
        workInRf = boolToString(human.getWorkInRf(), yesNoOptions);
        workNear = boolToString(human.getWorkNear(), yesNoOptions);
        position = intToString(human.getPosition(), positionOptions);
        octoberSalary = boolToString(human.getOctoberSalary(), yesNoOptions);
        marriage = createMarriage(human.getMarriage(), human.getRegistratedMarriage());
        salarySources = createSalaries(salary);
        if (salary == null){
            mainSource = " ";
        } else {
            mainSource = salary.giveMainSource(human.getMainSource());
        }

    }

    private String createBirthDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return intToStringWithZero(cal.get(Calendar.DAY_OF_MONTH)) + "." + intToStringWithZero(cal.get(Calendar.MONTH)+1) +
                "." + cal.get(Calendar.YEAR);
    }

    private String createFirstChildBirthDate(Date date){
        if (date == null){
            return " ";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return intToStringWithZero(cal.get(Calendar.MONTH)) + "." + cal.get(Calendar.YEAR);
    }

    private String intToStringWithZero(int number){
        if (number<10){
            return "0" + number;
        } else {
            return Integer.toString(number);
        }
    }

    private String createCitizenship(Integer index, String string){
        if (index == null) {
            return " ";
        } else {
            switch (index) {
                case 0: {
                    return citizenshipOptions.get(0);
                }
                case 1: {
                    return string;
                }
                case 2: {
                    return citizenshipOptions.get(0) + ", " + string;
                }
                case 3: {
                    return citizenshipOptions.get(3);
                }
                default: {
                    return "error";
                }
            }
        }
    }

    private String createMarriage(Integer index, Boolean isRegistrated){
        if (index == null){
            return " ";
        } else {
            switch (index) {
                case 0: {
                    if (isRegistrated) {
                        return weddingOptions.get(0) + ", брак зарегестрирован";
                    } else {
                        return weddingOptions.get(0) + ", брак не зарегестрирован";
                    }
                }
                case 1:
                case 2:
                case 3:
                case 4: {
                    return weddingOptions.get(index);
                }
                default: {
                    return "Error";
                }
            }
        }
    }

    private String createSalaries(dbSalariestableEntity salary){
        if (salary == null){
            return " ";
        } else {
            return salary.createStringVersion();
        }
    }
}

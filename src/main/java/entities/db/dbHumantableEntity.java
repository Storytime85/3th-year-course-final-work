package entities.db;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "humantable", schema = "curse", catalog = "")
public class dbHumantableEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //region Fields
    private int householdId;
    private int humanId;
    private Integer whoIs;
    private String whoIsString;
    private Boolean sex;
    private Date birthDate;
    private String birthPlace;
    private Integer marriage;
    private Boolean registratedMarriage;
    private Integer citizenship;
    private String doubleCitizenship;
    private String nationality;
    private Integer education;
    private Boolean readnWrite;
    private Integer scienceGrade;
    private Boolean doYouStudy;
    private Boolean primarySchool;
    private Boolean russian;
    private String otherLang;
    private String motherTongue;
    private Integer salarySources;
    private Integer mainSource;
    private Boolean octoberSalary;
    private Integer position;
    private Boolean workNear;
    private Boolean workInRf;
    private String workNotRf;
    private Boolean secondJob;
    private Boolean lookingForJob;
    private Boolean near2Weeks;
    private Integer whyNotLooking;
    private Integer liveSinceBirth;
    private Date yearWhereLive;
    private String placeWhereLive;
    private Integer typePlace;
    private Integer childCount;
    private Date firstChildBirthdate;
    //endregion

    //region GETTERs and SETTERs
    @Basic
    @Column(name = "HouseholdID", nullable = true)
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HumanID", nullable = false)
    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    @Basic
    @Column(name = "WhoIs", nullable = true)
    public Integer getWhoIs() {
        return whoIs;
    }

    public void setWhoIs(Integer whoIs) {
        this.whoIs = whoIs;
    }

    @Basic
    @Column(name = "WhoIsString", nullable = true, length = 20)
    public String getWhoIsString() {
        return whoIsString;
    }

    public void setWhoIsString(String whoIsString) {
        this.whoIsString = whoIsString;
    }

    @Basic
    @Column(name = "Sex", nullable = true)
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "BirthDate", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "BirthPlace", nullable = true, length = 100)
    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Basic
    @Column(name = "Marriage", nullable = true)
    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    @Basic
    @Column(name = "RegistratedMarriage", nullable = true)
    public Boolean getRegistratedMarriage() {
        return registratedMarriage;
    }

    public void setRegistratedMarriage(Boolean registratedMarriage) {
        this.registratedMarriage = registratedMarriage;
    }

    @Basic
    @Column(name = "Citizenship", nullable = true)
    public Integer getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Integer citizenship) {
        this.citizenship = citizenship;
    }

    @Basic
    @Column(name = "DoubleCitizenship", nullable =  true, length = 20)
    public String getDoubleCitizenship() {
        return doubleCitizenship;
    }

    public void setDoubleCitizenship(String doubleCitizenship) {
        this.doubleCitizenship = doubleCitizenship;
    }

    @Basic
    @Column(name = "Nationality", nullable = true, length = 20)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "Education", nullable = true)
    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    @Basic
    @Column(name = "ReadnWrite", nullable = true)
    public Boolean getReadnWrite() {
        return readnWrite;
    }

    public void setReadnWrite(Boolean readnWrite) {
        this.readnWrite = readnWrite;
    }

    @Basic
    @Column(name = "ScienceGrade", nullable = true)
    public Integer getScienceGrade() {
        return scienceGrade;
    }

    public void setScienceGrade(Integer scienceGrade) {
        this.scienceGrade = scienceGrade;
    }

    @Basic
    @Column(name = "DoYouStudy", nullable = true)
    public Boolean getDoYouStudy() {
        return doYouStudy;
    }

    public void setDoYouStudy(Boolean doYouStudy) {
        this.doYouStudy = doYouStudy;
    }

    @Basic
    @Column(name = "PrimarySchool", nullable = true)
    public Boolean getPrimarySchool() {
        return primarySchool;
    }

    public void setPrimarySchool(Boolean primarySchool) {
        this.primarySchool = primarySchool;
    }

    @Basic
    @Column(name = "Russian", nullable = true)
    public Boolean getRussian() {
        return russian;
    }

    public void setRussian(Boolean russian) {
        this.russian = russian;
    }

    @Basic
    @Column(name = "OtherLang", nullable = true, length = 100)
    public String getOtherLang() {
        return otherLang;
    }

    public void setOtherLang(String otherLang) {
        this.otherLang = otherLang;
    }

    @Basic
    @Column(name = "MotherTongue", nullable = true, length = 20)
    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    @Basic
    @Column(name = "SalarySources", nullable = true)
    public Integer getSalarySources() {
        return salarySources;
    }

    public void setSalarySources(Integer salarySources) {
        this.salarySources = salarySources;
    }

    @Basic
    @Column(name = "MainSource", nullable = true)
    public Integer getMainSource() {
        return mainSource;
    }

    public void setMainSource(Integer mainSource) {
        this.mainSource = mainSource;
    }

    @Basic
    @Column(name = "OctoberSalary", nullable = true)
    public Boolean getOctoberSalary() {
        return octoberSalary;
    }

    public void setOctoberSalary(Boolean octoberSalary) {
        this.octoberSalary = octoberSalary;
    }

    @Basic
    @Column(name = "Pose", nullable = true)
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Basic
    @Column(name = "WorkNear", nullable = true)
    public Boolean getWorkNear() {
        return workNear;
    }

    public void setWorkNear(Boolean workNear) {
        this.workNear = workNear;
    }

    @Basic
    @Column(name = "WorkInRF", nullable = true)
    public Boolean getWorkInRf() {
        return workInRf;
    }

    public void setWorkInRf(Boolean workInRf) {
        this.workInRf = workInRf;
    }

    @Basic
    @Column(name = "WorkNotRF", nullable = true, length = 20)
    public String getWorkNotRf() {
        return workNotRf;
    }

    public void setWorkNotRf(String workNotRf) {
        this.workNotRf = workNotRf;
    }

    @Basic
    @Column(name = "SecondJob", nullable = true)
    public Boolean getSecondJob() {
        return secondJob;
    }

    public void setSecondJob(Boolean secondJob) {
        this.secondJob = secondJob;
    }

    @Basic
    @Column(name = "LookingForJob", nullable = true)
    public Boolean getLookingForJob() {
        return lookingForJob;
    }

    public void setLookingForJob(Boolean lookingForJob) {
        this.lookingForJob = lookingForJob;
    }

    @Basic
    @Column(name = "Near2Weeks", nullable = true)
    public Boolean getNear2Weeks() {
        return near2Weeks;
    }

    public void setNear2Weeks(Boolean near2Weeks) {
        this.near2Weeks = near2Weeks;
    }

    @Basic
    @Column(name = "WhyNotLooking", nullable = true)
    public Integer getWhyNotLooking() {
        return whyNotLooking;
    }

    public void setWhyNotLooking(Integer whyNotLooking) {
        this.whyNotLooking = whyNotLooking;
    }

    @Basic
    @Column(name = "LiveSinceBirth", nullable = true)
    public Integer getLiveSinceBirth() {
        return liveSinceBirth;
    }

    public void setLiveSinceBirth(Integer liveSinceBirth) {
        this.liveSinceBirth = liveSinceBirth;
    }

    @Basic
    @Column(name = "YearWhereLive", nullable = true)
    public Date getYearWhereLive() {
        return yearWhereLive;
    }

    public void setYearWhereLive(Date yearWhereLive) {
        this.yearWhereLive = yearWhereLive;
    }

    @Basic
    @Column(name = "PlaceWhereLive", nullable = true, length = 20)
    public String getPlaceWhereLive() {
        return placeWhereLive;
    }

    public void setPlaceWhereLive(String placeWhereLive) {
        this.placeWhereLive = placeWhereLive;
    }

    @Basic
    @Column(name = "TypePlace", nullable = true)
    public Integer getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(Integer typePlace) {
        this.typePlace = typePlace;
    }

    @Basic
    @Column(name = "ChildCount", nullable = true)
    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    @Basic
    @Column(name = "FirstChildBirthdate", nullable = true)
    public Date getFirstChildBirthdate() {
        return firstChildBirthdate;
    }

    public void setFirstChildBirthdate(Date firstChildBirthdate) {
        this.firstChildBirthdate = firstChildBirthdate;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dbHumantableEntity that = (dbHumantableEntity) o;
        return householdId == that.householdId &&
                humanId == that.humanId &&
                whoIs == that.whoIs &&
                marriage == that.marriage &&
                citizenship == that.citizenship &&
                education == that.education &&
                scienceGrade == that.scienceGrade &&
                salarySources == that.salarySources &&
                mainSource == that.mainSource &&
                position == that.position &&
                whyNotLooking == that.whyNotLooking &&
                typePlace == that.typePlace &&
                childCount.equals(that.childCount) &&
                Objects.equals(whoIsString, that.whoIsString) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(birthPlace, that.birthPlace) &&
                Objects.equals(registratedMarriage, that.registratedMarriage) &&
                Objects.equals(nationality, that.nationality) &&
                Objects.equals(readnWrite, that.readnWrite) &&
                Objects.equals(doYouStudy, that.doYouStudy) &&
                Objects.equals(primarySchool, that.primarySchool) &&
                Objects.equals(russian, that.russian) &&
                Objects.equals(otherLang, that.otherLang) &&
                Objects.equals(motherTongue, that.motherTongue) &&
                Objects.equals(octoberSalary, that.octoberSalary) &&
                Objects.equals(workNear, that.workNear) &&
                Objects.equals(workInRf, that.workInRf) &&
                Objects.equals(workNotRf, that.workNotRf) &&
                Objects.equals(secondJob, that.secondJob) &&
                Objects.equals(lookingForJob, that.lookingForJob) &&
                Objects.equals(near2Weeks, that.near2Weeks) &&
                Objects.equals(liveSinceBirth, that.liveSinceBirth) &&
                Objects.equals(yearWhereLive, that.yearWhereLive) &&
                Objects.equals(placeWhereLive, that.placeWhereLive) &&
                Objects.equals(firstChildBirthdate, that.firstChildBirthdate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(householdId, humanId, whoIs, whoIsString, sex, birthDate, birthPlace, marriage, registratedMarriage, citizenship, nationality, education, readnWrite, scienceGrade, doYouStudy, primarySchool, russian, otherLang, motherTongue, salarySources, mainSource, octoberSalary, position, workNear, workInRf, workNotRf, secondJob, lookingForJob, near2Weeks, whyNotLooking, liveSinceBirth, yearWhereLive, placeWhereLive, typePlace, childCount, firstChildBirthdate);
    }
}

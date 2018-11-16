package entities.db;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "migrationtable", schema = "curse", catalog = "")
public class dbMigrationtableEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //region Fields
    private int humanId;
    private int id;
    private Boolean sex;
    private Date birthYear;
    private String permanentCountry;
    private Integer purpose;
    private String purposeString;
    private Integer lasting;
    private String motherCountry;
    private String citizenship;
    //endregion

    //region GETTERs and SETTERs
    @Basic
    @Column(name = "HumanID", nullable = true)
    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int listId) {
        this.id = listId;
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
    @Column(name = "BirthYear", nullable = true)
    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
    }

    @Basic
    @Column(name = "PermanentCountry", nullable = true, length = 20)
    public String getPermanentCountry() {
        return permanentCountry;
    }

    public void setPermanentCountry(String permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    @Basic
    @Column(name = "Purpose", nullable = true)
    public Integer getPurpose() {
        return purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    @Basic
    @Column(name = "PurposeString", nullable = true)
    public String getPurposeString() {
        return purposeString;
    }

    public void setPurposeString(String purposeString) {
        this.purposeString = purposeString;
    }

    @Basic
    @Column(name = "Lasting", nullable = true)
    public Integer getLasting() {
        return lasting;
    }

    public void setLasting(Integer lasting) {
        this.lasting = lasting;
    }

    @Basic
    @Column(name = "MotherCountry", nullable = true, length = 20)
    public String getMotherCountry() {
        return motherCountry;
    }

    public void setMotherCountry(String motherCountry) {
        this.motherCountry = motherCountry;
    }

    @Basic
    @Column(name = "Citizenship", nullable = true)
    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dbMigrationtableEntity that = (dbMigrationtableEntity) o;
        return humanId == that.humanId &&
                id == that.id &&
                purpose == that.purpose &&
                lasting == that.lasting &&
                citizenship == that.citizenship &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(birthYear, that.birthYear) &&
                Objects.equals(permanentCountry, that.permanentCountry) &&
                Objects.equals(motherCountry, that.motherCountry);
    }

    @Override
    public int hashCode() {

        return Objects.hash(humanId, id, sex, birthYear, permanentCountry, purpose, lasting, motherCountry, citizenship);
    }

}

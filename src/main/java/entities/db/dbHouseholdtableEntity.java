package entities.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "householdtable", schema = "curse", catalog = "")
public class dbHouseholdtableEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //region Fields
    private int householdId;
    private int flatId;
    private Integer peopleCount;
    private Double chamberCount;
    private Boolean internet;
    //endregion

    //region GETTERs and SETTERs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HouseholdID", nullable = false)
    public int getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(int householdId) {
        this.householdId = householdId;
    }

    @Basic
    @Column(name = "FlatID", nullable = false)
    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int houseId) {
        this.flatId = houseId;
    }

    @Basic
    @Column(name = "PeopleCount", nullable = true)
    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    @Basic
    @Column(name = "ChamberCount", nullable = true)
    public Double getChamberCount() {
        return chamberCount;
    }

    public void setChamberCount(Double chamberCount) {
        this.chamberCount = chamberCount;
    }

    @Basic
    @Column(name = "Internet", nullable = true)
    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dbHouseholdtableEntity that = (dbHouseholdtableEntity) o;
        return householdId == that.householdId &&
                flatId == that.flatId &&
                peopleCount == that.peopleCount &&
                chamberCount == that.chamberCount &&
                Objects.equals(internet, that.internet);
    }

    @Override
    public int hashCode() {

        return Objects.hash(householdId, flatId, peopleCount, chamberCount, internet);
    }

}

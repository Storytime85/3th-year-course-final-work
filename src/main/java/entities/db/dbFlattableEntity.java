package entities.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "flattable", schema = "curse", catalog = "")
public class dbFlattableEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //region Fields
    private int flatId;
    private int buildingId;
    private Boolean flatType;
    private Integer square;
    private Integer chamberCount;
    private Boolean phone;
    private Boolean tv;
    private Boolean radio;
    //endregion

    //region GETTERs and SETTERs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FlatID", nullable = false)
    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    @Basic
    @Column(name = "BuildingID", nullable = false)
    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    @Basic
    @Column(name = "FlatType", nullable = true)
    public Boolean getFlatType() {
        return flatType;
    }

    public void setFlatType(Boolean flatType) {
        this.flatType = flatType;
    }

    @Basic
    @Column(name = "Square", nullable = true)
    public Integer getSquare() {
        return square;
    }

    public void setSquare(Integer square) {
        this.square = square;
    }

    @Basic
    @Column(name = "ChamberCount", nullable = true)
    public Integer getChamberCount() {
        return chamberCount;
    }

    public void setChamberCount(Integer chamberCount) {
        this.chamberCount = chamberCount;
    }

    @Basic
    @Column(name = "Phone", nullable = true)
    public Boolean getPhone() {
        return phone;
    }

    public void setPhone(Boolean phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "TV", nullable = true)
    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    @Basic
    @Column(name = "Radio", nullable = true)
    public Boolean getRadio() {
        return radio;
    }

    public void setRadio(Boolean radio) {
        this.radio = radio;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dbFlattableEntity that = (dbFlattableEntity) o;
        return flatId == that.flatId &&
                buildingId == that.buildingId &&
                square == that.square &&
                chamberCount == that.chamberCount &&
                Objects.equals(flatType, that.flatType) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(tv, that.tv) &&
                Objects.equals(radio, that.radio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatId, buildingId, flatType, square, chamberCount, phone, tv, radio);
    }

}

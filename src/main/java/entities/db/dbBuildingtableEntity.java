package entities.db;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "buildingtable", schema = "curse", catalog = "")
public class dbBuildingtableEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //region Fields
    private int buildingId;
    private Integer homeType;
    private String typeString;
    private Integer dateFound;
    private Integer wallMaterial;
    private String wallString;
    private Boolean energy;
    private Boolean stove;
    private Integer gas;
    private Integer heat;
    private Integer water;
    private Integer hotWater;
    private Integer canalisation;
    private Integer closet;
    private Integer shower;
    private Integer garbage;
    private Integer kitchen;
    //endregion

    //region GETTERs and SETTERs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BuildingID", nullable = false)
    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    @Basic
    @Column(name = "HomeType", nullable = true)
    public Integer getHomeType() {
        return homeType;
    }

    public void setHomeType(Integer homeType) {
        this.homeType = homeType;
    }

    @Basic
    @Column(name = "TypeString", nullable = true, length = 20)
    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    @Basic
    @Column(name = "DateFound", nullable = true)
    public Integer getDateFound() {
        return dateFound;
    }

    public void setDateFound(Integer dateFound) {
        this.dateFound = dateFound;
    }

    @Basic
    @Column(name = "WallMaterial", nullable = true)
    public Integer getWallMaterial() {
        return wallMaterial;
    }

    public void setWallMaterial(Integer wallMaterial) {
        this.wallMaterial = wallMaterial;
    }

    @Basic
    @Column(name = "WallString", nullable = true, length = 20)
    public String getWallString() {
        return wallString;
    }

    public void setWallString(String wallString) {
        this.wallString = wallString;
    }

    @Basic
    @Column(name = "Energy", nullable = true)
    public Boolean getEnergy() {
        return energy;
    }

    public void setEnergy(Boolean energy) {
        this.energy = energy;
    }

    @Basic
    @Column(name = "Stove", nullable = true)
    public Boolean getStove() {
        return stove;
    }

    public void setStove(Boolean stove) {
        this.stove = stove;
    }

    @Basic
    @Column(name = "Gas", nullable = true)
    public Integer getGas() {
        return gas;
    }

    public void setGas(Integer gas) {
        this.gas = gas;
    }

    @Basic
    @Column(name = "Heat", nullable = true)
    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    @Basic
    @Column(name = "Water", nullable = true)
    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    @Basic
    @Column(name = "HotWater", nullable = true)
    public Integer getHotWater() {
        return hotWater;
    }

    public void setHotWater(Integer hotWater) {
        this.hotWater = hotWater;
    }

    @Basic
    @Column(name = "Canalisation", nullable = true)
    public Integer getCanalisation() {
        return canalisation;
    }

    public void setCanalisation(Integer canalisation) {
        this.canalisation = canalisation;
    }

    @Basic
    @Column(name = "Closet", nullable = true)
    public Integer getCloset() {
        return closet;
    }

    public void setCloset(Integer closet) {
        this.closet = closet;
    }

    @Basic
    @Column(name = "Shower", nullable = true)
    public Integer getShower() {
        return shower;
    }

    public void setShower(Integer shower) {
        this.shower = shower;
    }

    @Basic
    @Column(name = "Garbage", nullable = true)
    public Integer getGarbage() {
        return garbage;
    }

    public void setGarbage(Integer garbage) {
        this.garbage = garbage;
    }

    @Basic
    @Column(name = "Kitchen", nullable = true)
    public Integer getKitchen() {
        return kitchen;
    }

    public void setKitchen(Integer kitchen) {
        this.kitchen = kitchen;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        dbBuildingtableEntity that = (dbBuildingtableEntity) o;
        return buildingId == that.buildingId &&
                homeType == that.homeType &&
                dateFound == that.dateFound &&
                wallMaterial == that.wallMaterial &&
                gas == that.gas &&
                heat == that.heat &&
                water == that.water &&
                hotWater == that.hotWater &&
                canalisation == that.canalisation &&
                closet == that.closet &&
                shower == that.shower &&
                garbage == that.garbage &&
                kitchen == that.kitchen &&
                Objects.equals(typeString, that.typeString) &&
                Objects.equals(wallString, that.wallString) &&
                Objects.equals(energy, that.energy) &&
                Objects.equals(stove, that.stove);
    }

    @Override
    public int hashCode() {

        return Objects.hash(buildingId, homeType, typeString, dateFound, wallMaterial, wallString, energy, stove, gas, heat, water, hotWater, canalisation, closet, shower, garbage, kitchen);
    }
}

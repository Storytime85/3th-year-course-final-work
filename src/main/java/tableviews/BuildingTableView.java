package tableviews;

import entities.db.dbBuildingtableEntity;
import persistence.abstracts.TableViews;

public class BuildingTableView extends TableViews {
    //region Fields
    private int id;
    private String homeType;
    private String dateFound;
    private String wallMaterial;
    private String energy;
    private String stove;
    private String gas;
    private String heat;
    private String water;
    private String hotWater;
    private String canalisation;
    private String closet;
    private String shower;
    private String garbage;
    private String kitchen;
    //endregion

    //region Getters
    public int getId() {
        return id;
    }

    public String getHomeType() {
        return homeType;
    }

    public String getDateFound() {
        return dateFound;
    }

    public String getWallMaterial() {
        return wallMaterial;
    }

    public String getEnergy() {
        return energy;
    }

    public String getStove() {
        return stove;
    }

    public String getGas() {
        return gas;
    }

    public String getHeat() {
        return heat;
    }

    public String getWater() {
        return water;
    }

    public String getHotWater() {
        return hotWater;
    }

    public String getCanalisation() {
        return canalisation;
    }

    public String getCloset() {
        return closet;
    }

    public String getShower() {
        return shower;
    }

    public String getGarbage() {
        return garbage;
    }

    public String getKitchen() {
        return kitchen;
    }
    //endregion

    public BuildingTableView (dbBuildingtableEntity building) {
        id = building.getBuildingId();
        homeType = createAnotherType(building.getHomeType(), buildingTypesOptions, building.getTypeString(), 5);
        dateFound = intToString(building.getDateFound(), foundationOptions);
        wallMaterial = createAnotherType(building.getWallMaterial(), materialOptions, building.getWallString(), 5);
        energy = boolToString(building.getEnergy(), yesNoOptions);
        stove = boolToString(building.getStove(), yesNoOptions);
        gas = intToString(building.getGas(), gasOptions);
        heat = intToString(building.getHeat(), heatOptions);
        water = intToString(building.getWater(), waterOptions);
        hotWater = intToString(building.getHotWater(), hotWaterOptions);
        canalisation = intToString(building.getCanalisation(), canalisationOptions);
        closet = intToString(building.getCloset(), toiletOptions);
        shower = intToString(building.getShower(), bathOptions);
        garbage = intToString(building.getGarbage(), garbageOptions);
        kitchen = intToString(building.getKitchen(), kitchenOptions);
    }

}

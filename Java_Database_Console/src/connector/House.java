package connector;

import javax.persistence.Id;

/**
 * Created by Sander on 2-6-2015.
 */
public class House {

    @Id
    private Integer id;
    private Integer broker;
    private String address;
    private String postal;
    private String city;
    private float price;
    private Integer priceType;
    private Integer typeObject;
    private Integer sortHouse;
    private Integer typeHouse;
    private Integer sortBouw;
    private String description;
    private Integer buildYear;
    private Integer garden;
    private float gardenSurfaceArea;
    private Integer status;
    private float livingSurfaceArea;
    private float capacity;
    private Integer roomCount;
    private Integer bathRoomCount;
    private Integer levels;
    private float surfaceArea;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBroker() {
        return broker;
    }

    public void setBroker(Integer broker) {
        this.broker = broker;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public Integer getTypeObject() {
        return typeObject;
    }

    public void setTypeObject(Integer typeObject) {
        this.typeObject = typeObject;
    }

    public Integer getSortHouse() {
        return sortHouse;
    }

    public void setSortHouse(Integer sortHouse) {
        this.sortHouse = sortHouse;
    }

    public Integer getTypeHouse() {
        return typeHouse;
    }

    public void setTypeHouse(Integer typeHouse) {
        this.typeHouse = typeHouse;
    }

    public Integer getSortBouw() {
        return sortBouw;
    }

    public void setSortBouw(Integer sortBouw) {
        this.sortBouw = sortBouw;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Integer buildYear) {
        this.buildYear = buildYear;
    }

    public Integer getGarden() {
        return garden;
    }

    public void setGarden(Integer garden) {
        this.garden = garden;
    }

    public float getGardenSurfaceArea() {
        return gardenSurfaceArea;
    }

    public void setGardenSurfaceArea(float gardenSurfaceArea) {
        this.gardenSurfaceArea = gardenSurfaceArea;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public float getLivingSurfaceArea() {
        return livingSurfaceArea;
    }

    public void setLivingSurfaceArea(float livingSurfaceArea) {
        this.livingSurfaceArea = livingSurfaceArea;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Integer getBathRoomCount() {
        return bathRoomCount;
    }

    public void setBathRoomCount(Integer bathRoomCount) {
        this.bathRoomCount = bathRoomCount;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

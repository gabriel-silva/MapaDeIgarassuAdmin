package br.edu.ifpe.pibex.iphan.mapadeigarassuadmin.model;

public class LocationModel{

    private int id;
    private String name;
    private double longitude;
    private double latitude;
    private String address;
    private String description;

    public LocationModel() {
    }

    public LocationModel(String name, double longitude, double latitude, String address, String description) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.description = description;
    }

    public LocationModel(int id, String name, String address, String description, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
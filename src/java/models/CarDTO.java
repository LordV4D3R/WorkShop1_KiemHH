/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Vader
 */
public class CarDTO {
    private int carID;
    private String carName;
    private String manufacturer;
    private double price;
    private int releasedYear;

    public CarDTO() {
    }

    public CarDTO(int carID, String carName, String manufacturer, double price, int releasedYear) {
        this.carID = carID;
        this.carName = carName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.releasedYear = releasedYear;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }
    
}

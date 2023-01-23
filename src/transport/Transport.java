package transport;

import static transport.Utilities.*;

public abstract class Transport {
    private String brand;
    private String model;
    private final int year;
    private final String country;
    private String color;
    private int maxSpeed;


    public Transport(String brand, String model, int year, String country, String color, int maxSpeed) {
        this.brand = checkStringValidation(brand);
        this.model = checkStringValidation(model);
        this.year = year;
        this.country = country;
        this.color = checkColor(color);
        this.maxSpeed = checkMaxSpeed(maxSpeed);
    }

    //region getters and setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = checkStringValidation(brand);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = checkStringValidation(model);
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = checkColor(color);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = checkIntValidation(maxSpeed);
    }
    //endregion

    private String checkColor(String input) {
        if (input == null || input.isBlank()) {
            return "БЕЛЫЙ";
        } else {
            return input.toUpperCase();
        }
    }

}

public class Auto {

    private String brand;
    private String model;
    private double engineValue;
    private String color;
    private int year;
    private String country;


    public Auto(String brand, String model, double engineValue, String color, int year, String country) {
        this.brand = checkBrand(brand);
        this.model = checkModel(model);
        this.engineValue = checkEngineValue(engineValue);
        this.color = checkColor(color);
        this.year = checkYear(year);
        this.country = checkCountry(country);
    }

    private String checkBrand(String brand) {
        if (brand == null||brand.isBlank()) {
            return "default";
        } else {
            return brand.toUpperCase();
        }
    }
    private String checkModel(String model) {
        if (model == null||model.isBlank()) {
            return "default";
        } else {
            return model.toUpperCase();
        }
    }
    private String checkCountry(String country) {
        if (country == null||country.isBlank()) {
            return "default";
        } else {
            return country.toUpperCase();
        }
    }
    private double checkEngineValue(double engineValue) {
        double defaultValue = 1.5;
        if (engineValue <=0) {
            return defaultValue;
        } else {
            return engineValue;
        }
    }
    private String checkColor(String color) {
        if (color == null||color.isBlank()) {
            return "белый";
        } else {
            return color.toLowerCase();
        }
    }

    private int checkYear(int year) {
        int createYear = 2000;
        int firstAutoYear = 1768;
        if (year < firstAutoYear) {
            return createYear;
        } else {
            return year;
        }
    }

    @Override

    public String toString() {
        return brand + " " + model + ", " + year + " год выпуска, сборка в "
                + country + ", " + color + " цвет кузова, обьем двигателя - " + engineValue+" л.";
    }


}

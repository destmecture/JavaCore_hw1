package transport;


import java.util.regex.Pattern;

import static transport.Utilities.*;

public class Car {

    private final String brand;
    private final String model;
    private final int year;
    private final String country;
    private final String bodyType;
    private final int numOfSeats;

    private double engineValue;
    private String color;
    private String transmission;
    private String regNumber;
    private String tiresType;
    private boolean isWinterTires;
    private Key key;


    public Car(String brand,
               String model,
               double engineValue,
               String color,
               int year,
               String country,
               String bodyType,
               int numOfSeats,
               String transmission,
               String regNumber,
               String tiresType,
               Key key) {
        this.brand = checkStringValidation(brand);
        this.model = checkStringValidation(model);
        this.engineValue = checkEngineValue(engineValue);
        this.color = checkColor(color);
        this.year = checkYear(year);
        this.country = checkStringValidation(country);
        this.bodyType = checkStringValidation(bodyType);
        this.numOfSeats = checkIntValidation(numOfSeats);
        this.transmission = checkStringValidation(transmission);
        this.regNumber = checkRegNumber(regNumber);
        this.tiresType = checkTypeOfTires(tiresType);
        this.key = key;
    }

    //region getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public double getEngineValue() {
        return engineValue;
    }

    public String getColor() {
        return color;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getTiresType() {
        return tiresType;
    }
//endregion

    //region setters
    public void setColor(String color) {
        this.color = checkColor(color);
    }

    public void setEngineValue(double engineValue) {
        this.engineValue = checkEngineValue(engineValue);
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public void setTransmission(String transmission) {
        this.transmission = checkStringValidation(transmission);
    }

    public void setTiresType(String tiresType) {
        this.tiresType = checkTypeOfTires(tiresType);
    }
//endregion

    //region checking validation
    private int checkYear(int year) {
        int firstAutoYear = 1768;
        if (year < firstAutoYear) {
            return firstAutoYear;
        } else {
            return year;
        }
    }

    private double checkEngineValue(double engineValue) {
        double defaultValue = 1.5;
        if (engineValue <= 0) {
            return defaultValue;
        } else {
            return engineValue;
        }
    }

    private String checkColor(String input) {
        if (input == null || input.isBlank()) {
            return "БЕЛЫЙ";
        } else {
            return input.toUpperCase();
        }
    }

    private String checkRegNumber(String input) {
        String number = input.toUpperCase();
        String[] invalidLetters = {"Б", "Г", "Д", "Ё", "Ж", "З", "Й", "Л", "П",
                "Ф", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я"};

        if (Pattern.matches("[А-Я][0-9]{2}[1-9][А-Я]{2}[0-9]{2,3}", number)) {
            for (int i = 0; i < invalidLetters.length; i++) {
                if (number.contains(invalidLetters[i])) {
                    return "Неверный регистрационный номер";
                } else {
                    return number;
                }
            }
        }
        return "Неверный регистрационный номер";
    }

    private String checkTypeOfTires(String input) {
        String inputToUpper = input.toUpperCase();
        if (input == null || input.isBlank()) {
            return "Тип резины неопределен";
        } else if (inputToUpper.startsWith("ЗИМ")) {       //если указана "ЗИМняя" или "ЗИМа" isWinterTires принимает тру
            isWinterTires = true;                          //данная переменная нужна в будущем для смены резины
            return "Зимняя";
        } else if (inputToUpper.startsWith("ЛЕТ")) {       //"ЛЕТо" "ЛЕТняя"
            isWinterTires = false;
            return "Летняя";
        }
        return "Тип резины неопределен";
    }
    //endregion

    //region car methods
    public void changeTypeOfTires() {                      //Можно в методе принимать инт число, которое мы укажем как
        if (isWinterTires) {                               //текущую температуру в вашем городе, и если меньше 0 то
            this.setTiresType("ЛЕТНЯЯ");                   //менять на зимнюю и наоборот
        } else {
            this.setTiresType("ЗИМНЯЯ");
        }
        System.out.println("Произведена замена шин на автомобиле " + this.getBrand() + " " + this.getModel() + ". Текущий тип резины - " + this.getTiresType() + "\n");

    }
    //endregion

    public static class Key {

        private Boolean remoteStart;
        private Boolean keylessAccess;

        public Key(Boolean remoteStart, Boolean keylessAccess) {
            this.remoteStart = checkBooleanValidation(remoteStart);
            this.keylessAccess = checkBooleanValidation(keylessAccess);


        }

        private static String getAnswer(Boolean a) {
            if (a) {
                return "имеет";
            } else {
                return "не имеет";
            }
        }

        @Override
        public String toString() {
            return "Ваш ключ " + getAnswer(remoteStart) + " удаленный запуск двигателя и " + getAnswer(keylessAccess) + " бесключевой доступ";
        }
    }


    @Override
    public String toString() {
        return brand + " "
                + model + ", "
                + year + " год выпуска, сборка в "
                + country + ", "
                + color + " " +
                "цвет кузова. Обьем двигателя - "
                + engineValue + " л.\nТип кузова - "
                + bodyType + ". Количество пассажирских мест - "
                + numOfSeats + ". Коробка передач - "
                + transmission + ". Регистрационный номер - "
                + regNumber + ". Тип резины - "
                + tiresType + ".\n"
                + key + ".\n";
    }

}
package transport;

import java.util.regex.Pattern;

import static transport.Utilities.*;

public class Car extends Transport {
    private final String bodyType;
    private final int numOfSeats;
    private double engineValue;
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
               int maxSpeed,
               Key key) {
        super(brand,
                model,
                checkYear(year),
                checkCountry(country),
                color,
                maxSpeed);

        this.engineValue = checkEngineValue(engineValue);
        this.bodyType = checkStringValidation(bodyType);
        this.numOfSeats = checkIntValidation(numOfSeats);
        this.transmission = checkStringValidation(transmission);
        this.regNumber = checkRegNumber(regNumber);
        this.tiresType = checkTypeOfTires(tiresType);
        this.key = key;
    }

    //region getters
    public String getBodyType() {
        return bodyType;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public double getEngineValue() {
        return engineValue;
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


    private double checkEngineValue(double engineValue) {
        double defaultValue = 1.5;
        if (engineValue <= 0) {
            return defaultValue;
        } else {
            return engineValue;
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
        return  getBrand() + " "
                + getModel() + ", "
                + getYear() + " год выпуска, сборка в "
                + getCountry() + ". "
                + getColor() + " " +
                "цвет кузова. "
                + getMaxSpeed()+ "км/ч - максимальная скорость. Обьем двигателя - "
                + engineValue + " л.\nТип кузова - "
                + bodyType + ". Количество пассажирских мест - "
                + numOfSeats + ". Коробка передач - "
                + transmission + ". Регистрационный номер - "
                + regNumber + ". Тип резины - "
                + tiresType + ".\n"
                + key + ".\n";
    }

}
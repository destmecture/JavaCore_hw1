package transport;

import java.time.Year;

class Utilities {

    public static String checkStringValidation(String input) {
        if (input == null||input.isBlank()) {
            return "default";
        } else {
            return input.toUpperCase();
        }
    }

    public static int checkIntValidation(int input) {
        if (input <= 0) {
            return 1;
        } else {
            return input;
        }
    }

    public static Boolean checkBooleanValidation(Boolean input) {
        if (input == null) {
            input = false;
        }
        return input;
    }
    public static String checkCountry(String input) {
        if (input == null||input.isBlank()) {
            return "default";
        } else {
            return input.toUpperCase();
        }
    }
    public static int checkYear(int year) {
        int currentYear = Year.now().getValue();
        int firstAutoYear = 1768;
        if (year < firstAutoYear||year>currentYear) {
            return firstAutoYear;
        } else {
            return year;
        }
    }

    public static int checkMaxSpeed(int input) {
        if (input <= 0||input>300) {
            return 1;
        } else {
            return input;
        }
    }


}
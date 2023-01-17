package transport;

import java.util.regex.Pattern;

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

}
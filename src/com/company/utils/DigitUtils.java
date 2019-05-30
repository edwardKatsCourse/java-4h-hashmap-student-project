package com.company.utils;

public class DigitUtils {

    public static Integer convertDigit(String possibleDigit) {
        if (StringUtils.isNullOrEmptyOrBlank(possibleDigit)) {
            return null;
        }
        return Integer.parseInt(possibleDigit);
    }

    public static boolean isDigit(String possibleDigit) {
        if (StringUtils.isNullOrEmptyOrBlank(possibleDigit)) {
            return true;
        }
        try {
            Integer.parseInt(possibleDigit);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

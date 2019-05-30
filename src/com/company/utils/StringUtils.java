package com.company.utils;

public class StringUtils {

    public static boolean isNull(String s) {
        return s == null;
    }

    public static boolean isNullOrEmpty(String s) {
        if (isNull(s)) {
            return true;
        }
        return s.isEmpty();
    }

    public static boolean isNullOrEmptyOrBlank(String s) {
        if (isNull(s)) {
            return true;
        }
        return isNullOrEmpty(s.trim());
    }
}

package com.company.utils;

import java.util.Scanner;

public class ConsoleUtils {

    public static String read() {
        String data = new Scanner(System.in).nextLine();
        if (StringUtils.isNullOrEmptyOrBlank(data)) {
            return null;
        }
        return data;
    }

    public static Integer readDigit() {
        String possibleDigit = read();

        while (!DigitUtils.isDigit(possibleDigit)) {
            System.out.println("This field must be a digit");
            possibleDigit = read();
        }
        return DigitUtils.convertDigit(possibleDigit);
    }

    public static void print(String text) {
        System.out.println(text);
    }
}

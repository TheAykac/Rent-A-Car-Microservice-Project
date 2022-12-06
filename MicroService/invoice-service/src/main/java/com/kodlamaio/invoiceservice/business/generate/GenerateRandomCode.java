package com.kodlamaio.invoiceservice.business.generate;

import java.time.LocalDate;
import java.util.Random;

public class GenerateRandomCode {

    /**
     * It generates a random 8 digit number, then adds the current year, month, and day to the beginning of it
     *
     * @return A string of the current date and a random 8 digit number.
     */
    public static String generate() {

        int leftLimit = 48; // letter '0'
        int rightLimit = 57; // letter '9'
        int targetStringLength = 8;

        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String year = String.valueOf(LocalDate.now().getYear());
        String month = String.valueOf(LocalDate.now().getMonthValue());
        String day = String.valueOf(LocalDate.now().getDayOfMonth());

        if (month.length() == 1) {
            month = "0" + month;
        }

        if (day.length() == 1) {
            day = "0" + day;
        }

        return year + month + day + generatedString;
    }
}

package com.incubyte;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        // Check for custom delimiter syntax at the start
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            delimiter = Pattern.quote(numbers.substring(2, delimiterEndIndex));
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;

        for (String part : parts) {
            sum += Integer.parseInt(part);
        }

        return sum;
    }
}

package com.incubyte;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            delimiter = Pattern.quote(numbers.substring(2, delimiterEndIndex));
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] parts = numbers.split(delimiter);
        int sum = 0;

        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                throw new IllegalArgumentException("negatives not allowed: " + num);
            }
            sum += num;
        }

        return sum;
    }
}

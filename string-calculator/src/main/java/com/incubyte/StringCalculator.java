package com.incubyte;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiterPattern = ",|\n"; // default delimiters

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            String delimiterSection = numbers.substring(2, delimiterEndIndex);

            // Support for multiple or long delimiters in square brackets
            List<String> delimiters = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiterSection);
            while (matcher.find()) {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }

            if (delimiters.isEmpty()) {
                // Single-char delimiter fallback
                delimiters.add(Pattern.quote(delimiterSection));
            }

            delimiterPattern = String.join("|", delimiters);
            numbers = numbers.substring(delimiterEndIndex + 1);
        }

        String[] parts = numbers.split(delimiterPattern);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0) {
                negatives.add(num);
            } else if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives.toString().replaceAll("[\\[\\] ]", ""));
        }

        return sum;
    }
}

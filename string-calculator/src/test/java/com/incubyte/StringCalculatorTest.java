package com.incubyte;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void testEmptyStringReturnsZero() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }
    @Test
    void testSingleNumberReturnsThatNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }
    @Test
    void testTwoNumbersReturnTheirSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("1,2"));
    }
    @Test
    void testMultipleNumbersReturnTheirSum() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1,2,3"));
    }
    @Test
    void testNewLineAsDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }
    @Test
    void testCustomDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }
    @Test
    void testNegativeNumberThrowsException() {
        StringCalculator calc = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("-1");
        });

        assertEquals("negatives not allowed: -1", exception.getMessage());
    }
    @Test
    void testMultipleNegativesThrowExceptionWithAllNegativesListed() {
        StringCalculator calc = new StringCalculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.add("1,-2,-3");
        });

        assertEquals("negatives not allowed: -2,-3", exception.getMessage());
    }
    @Test
    void testNumbersGreaterThan1000AreIgnored() {
        StringCalculator calc = new StringCalculator();
        assertEquals(2, calc.add("2,1001"));
    }
    @Test
    void testCustomDelimiterOfAnyLength() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("//[***]\n1***2***3"));
    }
    @Test
    void testMultipleCustomDelimiters() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("//[*][%]\n1*2%3"));
    }
    @Test
    void testMultipleCustomDelimitersOfAnyLength() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("//[**][%%]\n1**2%%3"));
    }
}

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
}

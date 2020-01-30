package com.and.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestIntegerExtraction {
    @Test
    void testDigitExtractionWithDigitOnly() {
        String input = "123";
        Map<Integer, Integer> res = Solution.getIntAndCount(input);
        List<Integer> digits = new ArrayList<>(res.keySet());
        List<Integer> occs = new ArrayList<>(res.values());
        assertEquals(digits.size(), 3);
        assertEquals(Solution.sum(occs), 3);
    }

    @Test
    public static void testDigitExtractionWithDigitsAndChars() {
        String input = "1a2b3c";
        Map<Integer, Integer> res = Solution.getIntAndCount(input);
        List<Integer> digits = new ArrayList<>(res.keySet());
        List<Integer> occs = new ArrayList<>(res.values());
        assertEquals(digits.size(), 3);
        assertEquals(Solution.sum(occs), 3);
    }

    @Test
    public static void testDigitExtractionWithWhiteSpace() {
        String input = "1 2 3 ";
        Map<Integer, Integer> res = Solution.getIntAndCount(input);
        List<Integer> digits = new ArrayList<>(res.keySet());
        List<Integer> occs = new ArrayList<>(res.values());
        assertEquals(digits.size(), 3);
        assertEquals(Solution.sum(occs), 3);
    }

    @Test
    public static void testDigitExtractionWithWhiteSpaceAndChars() {
        String input = "Q1a q2ab cd3e ";
        Map<Integer, Integer> res = Solution.getIntAndCount(input);
        List<Integer> digits = new ArrayList<>(res.keySet());
        List<Integer> occs = new ArrayList<>(res.values());
        assertEquals(digits.size(), 3);
        assertEquals(Solution.sum(occs), 3);
    }

    @Test
    public static void testDigitExtractionWithRepetition() {
        String input = "112233";
        Map<Integer, Integer> res = Solution.getIntAndCount(input);
        List<Integer> digits = new ArrayList<>(res.keySet());
        List<Integer> occs = new ArrayList<>(res.values());
        assertEquals(digits.size(), 3);
        assertEquals(Solution.sum(occs), 6);
    }
}
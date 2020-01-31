package com.and.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPermutations {
    @Test
    void testPermutationCorrectness() {
        String input = "236";
        String expected = "632,623,362,326,263,236";
        assertEquals(Solution.solution(input), expected);
    }

    @Test
    void testPermutationCorrectnessWithDuplicates() {
        String input = "112";
        String expected = "211,121,112";
        assertEquals(Solution.solution(input), expected);
    }

    @Test
    void testPermutationsWithNoDuplicates() {
        String input = "325"; // 3!
        int numberOfCombinations = 6;
        assertEquals(Solution.solution(input).split(",").length, numberOfCombinations);
    }

    @Test
    void testPermutationsWithDuplicates() {
        String input = "3325";
        int numberOfCombinations = 12; // 4!/2!
        assertEquals(Solution.solution(input).split(",").length, numberOfCombinations);
    }

    @Test
    void testPermutationOrder() {
        String input = "236";
        String[] combs = Solution.solution(input).split(",");
        for (int i = 0; i < combs.length - 1; i++) {
            assertTrue(Integer.parseInt(combs[i]) > Integer.parseInt(combs[i + 1]));
        }
    }

    @Test
    void testPermutationOrderWithDuplicates() {
        String input = "3325";
        String[] combs = Solution.solution(input).split(",");
        for (int i = 0; i < combs.length - 1; i++) {
            assertTrue(Integer.parseInt(combs[i]) > Integer.parseInt(combs[i + 1]));
        }
    }

    @Test
    void testWithNoIntegers() {
        String input = "no integers";
        assertThrows(NumberFormatException.class, ()->{
            Solution.solution(input);
        });
    }


}

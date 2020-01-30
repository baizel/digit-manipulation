package com.and.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPermutations {
    @Test
    void testPermutationsWithNoDuplicates() {
        String input = "325"; // 3!
        int numberOfCombinations = 6;
        assertEquals(Solution.solution(input).split(",").length,numberOfCombinations);
    }

    @Test
    void testPermutationsWithDuplicates() {
        String input = "3325";
        int numberOfCombinations = 12; // 4!/2!
        assertEquals(Solution.solution(input).split(",").length,numberOfCombinations);
    }
    @Test
    void testPermutationOrder() {
        String input = "236";
        String[] combs = Solution.solution(input).split(",");
        for (int i=0; i< combs.length-1;i++){
            assertTrue(Integer.parseInt(combs[i]) > Integer.parseInt(combs[i+1]));
        }
    }

    @Test
    void testPermutationOrderWithDuplicates() {
        String input = "3325";
        String[] combs = Solution.solution(input).split(",");
        for (int i=0; i< combs.length-1;i++){
            assertTrue(Integer.parseInt(combs[i]) > Integer.parseInt(combs[i+1]));
        }
    }
}

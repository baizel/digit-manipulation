package com.and.test;

import java.util.*;

public class Solution {
    /**
     * Helper method to sum up integers in a given list of Integers
     *
     * @param list of Integers
     * @return the sum as int
     */
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * The following is the method where the solution shall be written
     */

    public static String solution(String input) throws NumberFormatException {
        Map<Integer, Integer> intLookUp = getIntAndCount(input);
        List<Integer> digit = new ArrayList<>(intLookUp.keySet());

        if (digit.size() == 0) {
            throw new NumberFormatException("No integers in given input");
        }
        digit.sort(Collections.reverseOrder());
        int siblingSize = sum(new ArrayList<>(intLookUp.values()));
        StringBuilder allSiblings = new StringBuilder();

        permutation(digit, intLookUp, new char[siblingSize], 0, allSiblings);
        allSiblings.deleteCharAt(allSiblings.length() - 1); //delete the trailing comma

        return allSiblings.toString();
    }

    /**
     * Method to find all the permutations of a given input of digit
     *
     * @param digits            list of all digits that are available for manipulation
     * @param occurrencesLookUp the number of occurrences for each of the digit
     * @param combinationResult the result of a combination from each round
     * @param recursionLevel    the depth of the recursion the che call is at
     * @param allSiblings       all of the possible combinations
     */
    public static void permutation(List<Integer> digits, Map<Integer, Integer> occurrencesLookUp, char[] combinationResult, int recursionLevel, StringBuilder allSiblings) {
        //base case for recursion
        if (recursionLevel == combinationResult.length) {
            allSiblings.append(new String(combinationResult));
            allSiblings.append(","); //add a trailing comma to match the specification of the pdf
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            // Move on to the next digit if the current once is already used up
            if (occurrencesLookUp.get(digits.get(i)) == 0) {
                continue;
            }
            //Add the current digit to the index of the result
            combinationResult[recursionLevel] = digits.get(i).toString().charAt(0);
            //Decrement the counter
            occurrencesLookUp.put(digits.get(i), occurrencesLookUp.get(digits.get(i)) - 1);
            //Recursively find the other combinations
            permutation(digits, occurrencesLookUp, combinationResult, recursionLevel + 1, allSiblings);
            //Reset count
            occurrencesLookUp.put(digits.get(i), occurrencesLookUp.get(digits.get(i)) + 1);
        }

    }

    /**
     * Extract and map the digit from a given input, ignores negative numbers
     * Maps the digit to the number of times it was seen
     *
     * @param input any string that may or may no contain integers
     * @return
     */
    static Map<Integer, Integer> getIntAndCount(String input) {
        Map<Integer, Integer> intAndCount = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char charToTest = input.charAt(i);
            if (Character.isDigit(charToTest)) {
                int key = Character.getNumericValue(charToTest);
                if (intAndCount.containsKey(key)) {
                    intAndCount.put(key, intAndCount.get(key) + 1);
                } else {
                    intAndCount.put(key, 1);
                }
            }
        }
        return intAndCount;
    }


    public static void main(String args[]) {
        solution("632");
    }

}

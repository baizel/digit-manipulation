package com.and.test;

import java.util.*;

public class Solution {

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

        StringBuilder allSiblings = new StringBuilder();

        permutation(digit, intLookUp,new char[digit.size()],0,allSiblings);
        allSiblings.deleteCharAt(allSiblings.length()-1); //delete the trailing comma

        return allSiblings.toString();
    }

    public static void permutation(List<Integer> digits, Map<Integer, Integer> occurrencesLookUp, char[] combinationResult, int recursionLevel, StringBuilder allSiblings) {
        if (recursionLevel == combinationResult.length) {
            allSiblings.append(new String(combinationResult));
            allSiblings.append(",");
            return;
        }

        for (int i = 0; i < digits.size(); i++) {
            if (occurrencesLookUp.get(digits.get(i)) == 0) {
                continue;
            }
            combinationResult[recursionLevel] = digits.get(i).toString().charAt(0);
            occurrencesLookUp.put(digits.get(i), occurrencesLookUp.get(digits.get(i)) - 1);
            permutation(digits, occurrencesLookUp, combinationResult, recursionLevel+1,allSiblings);
            occurrencesLookUp.put(digits.get(i), occurrencesLookUp.get(digits.get(i)) + 1);
        }

    }

    private static Map<Integer, Integer> getIntAndCount(String input) {
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

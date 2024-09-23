package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-22
 */
@LeetCode(
        id = 3297,
        name = "Count Substrings That Can Be Rearranged to Contain a String I",
        url = "https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class CountSubstringsThatCanBeRearrangedToContainStringI {
    public long validSubstringCount(String word1, String word2) {
        int[] frequencyTable = createCharFrequencyTable(word2);
        int left = 0;
        int right = 0;
        long result = 0;
        while (right < word1.length()) {
            frequencyTable[word1.charAt(right) - 'a']--;
            while (match(frequencyTable)) {
                result += word1.length() - right;
                frequencyTable[word1.charAt(left++) - 'a']++;
            }
            right++;
        }
        return result;
    }

    public int[] createCharFrequencyTable(String word) {
        int[] pattern = new int[26];
        for (char ch : word.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                pattern[Character.toLowerCase(ch) - 'a']++;
            }
        }

        return pattern;
    }

    private boolean match(int[] frequencyTable) {
        for (int j : frequencyTable) {
            if (j > 0) {
                return false;
            }
        }
        return true;
    }
}
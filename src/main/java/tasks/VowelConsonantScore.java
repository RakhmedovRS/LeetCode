package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-01-17
 */
@LeetCode(
        id = 3813,
        name = "Vowel-Consonant Score",
        url = "https://leetcode.com/problems/vowel-consonant-score/description/",
        difficulty = Difficulty.EASY
)
public class VowelConsonantScore {
    public int vowelConsonantScore(String s) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int V = 0;
        int C = 0;
        for (char ch : s.toCharArray()) {
            if (vowelsSet.contains(ch)) {
                V++;
            } else if (Character.isAlphabetic(ch)) {
                C++;
            }
        }

        if (C > 0) {
            return V / C;
        }
        return 0;
    }
}
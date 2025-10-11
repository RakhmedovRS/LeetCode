package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-11
 */
@LeetCode(
        id = 3707,
        name = "Equal Score Substrings",
        url = "https://leetcode.com/problems/equal-score-substrings/description/",
        difficulty = Difficulty.EASY
)
public class EqualScoreSubstrings {
    public boolean scoreBalance(String s) {
        long total = 0;
        for (char ch : s.toCharArray()) {
            total += (ch - 'a') + 1;
        }

        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - 'a') + 1;
            total -= (s.charAt(i) - 'a') + 1;

            if (sum == total) {
                return true;
            }
        }

        return false;
    }
}
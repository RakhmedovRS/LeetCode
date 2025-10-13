package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-13
 */
@LeetCode(
        id = 3713,
        name = "Longest Balanced Substring I",
        url = "https://leetcode.com/problems/longest-balanced-substring-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class LongestBalancedSubstringI {
    public int longestBalanced(String s) {
        int ans = 0;
        for (int left = 0; left < s.length(); left++) {
            int[] memo = new int[26];
            outer:
            for (int right = left; right < s.length(); right++) {
                memo[s.charAt(right) - 'a']++;
                int nonZero = 0;
                for (int f : memo) {
                    if (f > 0) {
                        if (nonZero == 0) {
                            nonZero = f;
                        } else if (f != nonZero) {
                            continue outer;
                        }
                    }
                }
                ans = Math.max(ans, 1 + right - left);
            }
        }
        return ans;
    }
}
package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-06
 */
@LeetCode(
        id = 3675,
        name = "Minimum Operations to Transform String",
        url = "https://leetcode.com/problems/minimum-operations-to-transform-string/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToTransformString {
    public int minOperations(String s) {
        int ans = 0;
        int[] memo = new int[26];
        for (char ch : s.toCharArray()) {
            memo[ch - 'a']++;
        }

        for (int i = 1; i < memo.length; i++) {
            if (memo[i] > 0) {
                ans++;
                if (i + 1 < memo.length) {
                    memo[i + 1] += memo[i];
                }
            }
        }

        return ans;
    }
}
package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-28
 */
@LeetCode(
        id = 1940,
        name = "Longest Common Subsequence Between Sorted Arrays",
        url = "https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/description/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class LongestCommonSubsequenceBetweenSortedArrays {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] memo = new int[101];
        for (int[] arr : arrays) {
            for (int num : arr) {
                memo[num]++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == arrays.length) {
                ans.add(i);
            }
        }

        return ans;
    }
}
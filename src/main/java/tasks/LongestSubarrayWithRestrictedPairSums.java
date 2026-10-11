package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-11
 */
@LeetCode(
        id = 4067,
        name = "Longest Subarray With Restricted Pair Sums",
        url = "https://leetcode.com/problems/longest-subarray-with-restricted-pair-sums/description/",
        difficulty = Difficulty.MEDIUM
)
public class LongestSubarrayWithRestrictedPairSums {
    public int maxSubarray(int[] nums) {
        int max = 0;
        outer:
        for (int start = 0; start < nums.length; start++) {
            boolean[] used = new boolean[501];
            boolean[] sums = new boolean[1002];
            int[] values = new int[501];
            int size = 0;
            for (int end = start; end < nums.length; end++) {
                int num = nums[end];

                if (sums[num]) {
                    continue outer;
                }

                for (int j = 0; j < size; j++) {
                    int v = values[j];

                    if (v + num <= 500 && used[v + num]) {
                        continue outer;
                    }
                }

                for (int j = 0; j < size; j++) {
                    sums[values[j] + num] = true;
                }

                if (!used[num]) {
                    values[size++] = num;
                }
                used[num] = true;

                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }
}
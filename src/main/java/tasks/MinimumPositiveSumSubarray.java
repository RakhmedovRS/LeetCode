package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-23
 */
@LeetCode(
        id = 3364,
        name = "Minimum Positive Sum Subarray",
        url = "https://leetcode.com/problems/minimum-positive-sum-subarray/",
        difficulty = Difficulty.EASY
)
public class MinimumPositiveSumSubarray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int currSum = 0;
            for (int j = i; j < nums.size(); j++) {
                currSum += nums.get(j);
                if (j - i >= l - 1 && j - i <= r - 1 && currSum > 0) {
                    min = Math.min(min, currSum);
                }
                if (j - i > r - 1) {
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-04-08
 */
@LeetCode(
        id = 3375,
        name = "Minimum Operations to Make Array Values Equal to K",
        url = "https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/",
        difficulty = Difficulty.EASY
)
public class MinimumOperationsToMakeArrayValuesEqualToK {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[0] < k) {
            return -1;
        }

        int ops = -1;
        int prev = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < prev) {
                prev = nums[i];
                ops++;
            }
        }

        if (k < nums[0]) {
            ops++;
        }

        return ops;
    }
}
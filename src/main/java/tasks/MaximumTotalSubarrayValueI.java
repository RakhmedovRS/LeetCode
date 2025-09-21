package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-20
 */
@LeetCode(
        id = 3689,
        name = "Maximum Total Subarray Value I",
        url = "https://leetcode.com/problems/maximum-total-subarray-value-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumTotalSubarrayValueI {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (long) k * (max - min);
    }
}
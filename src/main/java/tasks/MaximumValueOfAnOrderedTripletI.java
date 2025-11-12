package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-04-01
 */
@LeetCode(
        id = 2873,
        name = "Maximum Value of an Ordered Triplet I",
        url = "https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description",
        difficulty = Difficulty.EASY
)
public class MaximumValueOfAnOrderedTripletI {
    public long maximumTripletValue(int[] nums) {
        long max = Integer.MIN_VALUE;
        int[] memo = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            memo[i] = (int) max;
        }
        max = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                max = Math.max(max, (long) (nums[i] - nums[j]) * memo[j + 1]);
            }
        }
        return max;
    }
}
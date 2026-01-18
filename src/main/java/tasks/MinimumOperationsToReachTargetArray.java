package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-01-17
 */
@LeetCode(
        id = 3810,
        name = "Minimum Operations to Reach Target Array",
        url = "https://leetcode.com/problems/minimum-operations-to-reach-target-array/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToReachTargetArray {
    public int minOperations(int[] nums, int[] target) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target[i]) {
                memo.put(nums[i], memo.getOrDefault(nums[i], 0) + 1);
            }
        }
        return memo.size();
    }
}
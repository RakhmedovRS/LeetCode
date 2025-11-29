package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-28
 */
@LeetCode(
        id = 3512,
        name = "Minimum Operations to Make Array Sum Divisible by K",
        url = "https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/",
        difficulty = Difficulty.EASY
)
public class MinimumOperationsToMakeArraySumDivisibleByK {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
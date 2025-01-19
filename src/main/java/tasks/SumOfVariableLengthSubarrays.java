package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-01-18
 */
@LeetCode(
        id = 3427,
        name = "Sum of Variable Length Subarrays",
        url = "https://leetcode.com/problems/sum-of-variable-length-subarrays/description/",
        difficulty = Difficulty.EASY
)
public class SumOfVariableLengthSubarrays {
    public int subarraySum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = Math.max(0, i - nums[i]);
            while (start <= i) {
                sum += nums[start++];
            }
        }
        return sum;
    }
}
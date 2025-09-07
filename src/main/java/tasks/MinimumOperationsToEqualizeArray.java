package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-06
 */
@LeetCode(
        id = 3674,
        name = "Minimum Operations to Equalize Array",
        url = "https://leetcode.com/problems/minimum-operations-to-equalize-array/description/",
        difficulty = Difficulty.EASY
)
public class MinimumOperationsToEqualizeArray {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == nums[nums.length - 1]) {
            return 0;
        }
        return 1;
    }
}
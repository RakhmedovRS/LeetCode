package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-29
 */
@LeetCode(
        id = 3914,
        name = "Minimum Operations to Make Array Non Decreasing",
        url = "https://leetcode.com/problems/minimum-operations-to-make-array-non-decreasing/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeArrayNonDecreasing {
    public long minOperations(int[] nums) {
        int left = 0;
        int right = 0;
        long ans = 0;
        while (right < nums.length) {
            long add = 0;
            while (right < nums.length && nums[left] >= nums[right] + add) {
                add = Math.max(add, nums[left] - nums[right]);
                nums[right++] += (int) add;
            }

            ans += add;
            if (right < nums.length) {
                left = right;
            }
        }

        return ans;
    }
}
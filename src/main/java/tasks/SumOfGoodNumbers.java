package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-02-15
 */
@LeetCode(
        id = 3452,
        name = "Sum of Good Numbers",
        url = "https://leetcode.com/problems/sum-of-good-numbers/description/",
        difficulty = Difficulty.EASY
)
public class SumOfGoodNumbers {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int ans = 0;
        for (int m = 0; m < nums.length; m++) {
            if (m - k >= 0 && nums[m - k] >= nums[m]) {
                continue;
            }

            if (m + k < nums.length && nums[m + k] >= nums[m]) {
                continue;
            }

            ans += nums[m];
        }
        return ans;
    }
}
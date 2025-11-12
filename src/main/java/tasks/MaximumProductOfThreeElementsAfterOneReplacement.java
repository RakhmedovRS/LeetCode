package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-01
 */
@LeetCode(
        id = 3732,
        name = "Maximum Product of Three Elements After One Replacement",
        url = "https://leetcode.com/problems/maximum-product-of-three-elements-after-one-replacement/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumProductOfThreeElementsAfterOneReplacement {
    public long maxProduct(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }
        Arrays.sort(nums);
        long max;
        max = -100_000L * nums[nums.length - 1] * nums[nums.length - 2];
        max = Math.max(max, 100_000L * nums[nums.length - 1] * nums[nums.length - 2]);
        max = Math.max(max, -100_000L * nums[0] * nums[1]);
        return max;
    }
}
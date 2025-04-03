package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-04-02
 */
@LeetCode(
        id = 2874,
        name = "Maximum Value of an Ordered Triplet II",
        url = "https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description",
        difficulty = Difficulty.MEDIUM
)
public class MaximumValueOfAnOrderedTripletII {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int[] maxes = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            maxes[i] = max;
        }

        max = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (max - nums[i] > 0) {
                ans = Math.max(ans, (max - (long) nums[i]) * maxes[i + 1]);
            }
            max = Math.max(max, nums[i]);
        }

        return ans;
    }
}
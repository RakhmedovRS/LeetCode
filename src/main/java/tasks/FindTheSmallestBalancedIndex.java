package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-07
 */
@LeetCode(
        id = 3862,
        name = "Find the Smallest Balanced Index",
        url = "https://leetcode.com/problems/find-the-smallest-balanced-index/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindTheSmallestBalancedIndex {
    public int smallestBalancedIndex(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        long mult = 1;
        int ans = -1;
        for (int i = nums.length - 1; i >= 0 && sum >= mult && mult >= 0; i--) {
            sum -= nums[i];
            if (i + 1 < nums.length) {
                mult *= nums[i + 1];
            }

            if (sum == mult) {
                ans = i;
            }
        }

        return ans;
    }
}
package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-18
 */
@LeetCode(
        id = 3719,
        name = "Longest Balanced Subarray I",
        url = "https://leetcode.com/problems/longest-balanced-subarray-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class LongestBalancedSubarrayI {
    public int longestBalanced(int[] nums) {
        int max = 0;
        for (int left = 0; left < nums.length; left++) {
            Set<Integer> seenOnceOdd = new HashSet<>();
            Set<Integer> seenOnceEven = new HashSet<>();

            for (int right = left; right < nums.length; right++) {
                if (nums[right] % 2 == 0) {
                    seenOnceOdd.add(nums[right]);
                } else {
                    seenOnceEven.add(nums[right]);
                }

                if (seenOnceOdd.size() == seenOnceEven.size()) {
                    max = Math.max(max, 1 + right - left);
                }
            }
        }
        return max;
    }
}
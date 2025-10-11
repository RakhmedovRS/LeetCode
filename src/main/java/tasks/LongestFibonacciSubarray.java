package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-11
 */
@LeetCode(
        id = 3708,
        name = "Longest Fibonacci Subarray",
        url = "https://leetcode.com/problems/longest-fibonacci-subarray/description/",
        difficulty = Difficulty.MEDIUM
)
public class LongestFibonacciSubarray {
    public int longestSubarray(int[] nums) {
        int max = 2;
        for (int i = 0; i < nums.length - 2; i++) {
            int steps = 2;
            int curr = i;
            int next = i + 1;
            while (next + 1 < nums.length) {
                if (nums[curr] + nums[next] != nums[next + 1]) {
                    break;
                }
                curr = next;
                next++;
                steps++;
            }
            max = Math.max(max, steps);
        }
        return max;
    }
}
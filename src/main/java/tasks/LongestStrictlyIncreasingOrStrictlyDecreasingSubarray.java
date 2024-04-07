package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-04-06
 */
@LeetCode(
		id = 3105,
		name = "Longest Strictly Increasing or Strictly Decreasing Subarray",
		url = "https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/",
		difficulty = Difficulty.EASY
)
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
	public int longestMonotonicSubarray(int[] nums) {
		int max = 1;
		for (int a = 0; a < nums.length; a++) {
			for (int b = a; b < nums.length; b++) {
				int c = b + 1;
				int len = 1;
				while (c < nums.length && nums[c - 1] < nums[c]) {
					len++;
					c++;
					max = Math.max(max, len);
				}
			}
		}

		for (int a = 0; a < nums.length; a++) {
			for (int b = a; b < nums.length; b++) {
				int c = b + 1;
				int len = 1;
				while (c < nums.length && nums[c - 1] > nums[c]) {
					len++;
					c++;
					max = Math.max(max, len);
				}
			}
		}
		return max;
	}
}
package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/27/2022
 */
@LeetCode(
		id = 2419,
		name = "Longest Subarray With Maximum Bitwise AND",
		url = "https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/",
		difficulty = Difficulty.MEDIUM
)
public class LongestSubarrayWithMaximumBitwiseAND {
	public int longestSubarray(int[] nums) {
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
		}

		int maxLen = 0;
		int currentLen = 0;

		for (int num : nums) {
			if (max == num) {
				currentLen++;
			}
			else {
				currentLen = 0;
			}

			maxLen = Math.max(maxLen, currentLen);
		}

		return Math.max(maxLen, currentLen);
	}
}

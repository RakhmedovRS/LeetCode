package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-29
 */
@LeetCode(
		id = 3201,
		name = "Find the Maximum Length of Valid Subsequence I",
		url = "https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheMaximumLengthOfValidSubsequenceI {
	public int maximumLength(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] %= 2;
		}
		int zeroes = 0;
		int onces = 0;
		int alterZeroStart = 0;
		boolean zeroStart = true;
		int alterOneStart = 0;
		boolean oneStart = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroes++;
				if (zeroStart) {
					alterZeroStart++;
					zeroStart = false;
				}
				if (oneStart) {
					alterOneStart++;
					oneStart = false;
				}
			} else {
				onces++;
				if (!zeroStart) {
					alterZeroStart++;
					zeroStart = true;
				}
				if (!oneStart) {
					alterOneStart++;
					oneStart = true;
				}
			}
		}

		return Math.max(Math.max(zeroes, onces), Math.max(alterZeroStart, alterOneStart));
	}
}
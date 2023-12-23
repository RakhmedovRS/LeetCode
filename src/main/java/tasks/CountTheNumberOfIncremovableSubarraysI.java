package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/23/2023
 */
@LeetCode(
		id = 2970,
		name = "Count the Number of Incremovable Subarrays I",
		url = "https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/",
		difficulty = Difficulty.EASY
)
public class CountTheNumberOfIncremovableSubarraysI {
	public int incremovableSubarrayCount(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (isValidAfterRemoval(nums, i, j)) {
					res++;
				}
			}
		}

		return res;
	}

	private boolean isValidAfterRemoval(int[] nums, int i, int j) {
		Integer prev = null;

		for (int pos = 0; pos < nums.length; pos++) {
			if (pos < i || pos > j) {
				if (prev != null) {
					if (prev >= nums[pos]) {
						return false;
					}

				}
				prev = nums[pos];
			}
		}
		return true;
	}
}

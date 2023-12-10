package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/30/2023
 */
@LeetCode(
		id = 2971,
		name = "Split Array Into Maximum Number of Subarrays",
		url = "https://leetcode.com/problems/split-array-into-maximum-number-of-subarrays/description/",
		difficulty = Difficulty.MEDIUM
)
public class SplitArrayIntoMaximumNumberOfSubarrays {
	public int maxSubarrays(int[] nums) {
		int min = nums[0];
		for (int num : nums) {
			min &= num;
		}

		if (min != 0) {
			return 1;
		}

		int sub = 0;
		int current = Integer.MAX_VALUE;
		for (int num : nums) {
			current &= num;
			if (current == 0) {
				current = Integer.MAX_VALUE;
				sub++;
			}
		}

		return sub;
	}
}

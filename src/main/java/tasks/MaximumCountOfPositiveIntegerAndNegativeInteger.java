package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/8/2023
 */
@LeetCode(
		id = 2529,
		name = "Maximum Count of Positive Integer and Negative Integer",
		url = "https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/",
		difficulty = Difficulty.EASY
)
public class MaximumCountOfPositiveIntegerAndNegativeInteger {
	public int maximumCount(int[] nums) {
		int neg = 0;
		int pos = 0;
		for (int num : nums) {
			if (num < 0) {
				neg++;
			}
			else if (num > 0) {
				pos++;
			}
		}

		return Math.max(neg, pos);
	}
}

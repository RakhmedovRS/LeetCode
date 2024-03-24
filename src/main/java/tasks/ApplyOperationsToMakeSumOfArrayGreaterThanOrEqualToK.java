package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-03-23
 */
@LeetCode(
		id = 3091,
		name = "Apply Operations to Make Sum of Array Greater Than or Equal to k",
		url = "https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/description/",
		difficulty = Difficulty.MEDIUM
)
public class ApplyOperationsToMakeSumOfArrayGreaterThanOrEqualToK {
	public int minOperations(int k) {
		if (k == 1) {
			return 0;
		}

		int min = k - 1;
		k--;
		for (int i = 1; i < k; i++) {
			min = Math.min(min, (i - 1) + (k / i));
		}

		return min;
	}
}
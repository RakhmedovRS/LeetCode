package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/17/2024
 */
@LeetCode(
		id = 3038,
		name = "Maximum Number of Operations With the Same Score I",
		url = "https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfOperationsWithTheSameScoreI {
	public int maxOperations(int[] nums) {
		int ops = 0;
		if (nums.length == 1) {
			return ops;
		}

		int score = nums[0] + nums[1];
		for (int i = 1; i < nums.length; i += 2) {
			if (score == nums[i - 1] + nums[i]) {
				ops++;
			} else {
				break;
			}
		}

		return ops;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/29/2023
 */
@LeetCode(
		id = 2656,
		name = "Maximum Sum With Exactly K Elements",
		url = "https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/description/",
		difficulty = Difficulty.EASY
)
public class MaximumSumWithExactlyKElements {
	public int maximizeSum(int[] nums, int k) {
		int max = 0;
		for (int n : nums) {
			max = Math.max(max, n);
		}

		int sum = 0;
		while (k-- > 0) {
			sum += max;
			max++;
		}

		return sum;
	}
}

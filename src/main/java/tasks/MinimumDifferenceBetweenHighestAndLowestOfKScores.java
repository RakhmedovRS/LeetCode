package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 8/29/2021
 */
@LeetCode(
		id = 1984,
		name = "Minimum Difference Between Highest and Lowest of K Scores",
		url = "https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/",
		difficulty = Difficulty.EASY
)
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
	public int minimumDifference(int[] nums, int k) {
		if (nums.length == 1) {
			return 0;
		}

		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		for (int i = k - 1; i < nums.length; i++) {
			min = Math.min(min, nums[i] - nums[i - (k - 1)]);
		}

		return min;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/26/2021
 */
@LeetCode(
		id = 2016,
		name = "Maximum Difference Between Increasing Elements",
		url = "https://leetcode.com/problems/maximum-difference-between-increasing-elements/",
		difficulty = Difficulty.EASY
)
public class MaximumDifferenceBetweenIncreasingElements {
	public int maximumDifference(int[] nums) {
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					max = Math.max(max, nums[j] - nums[i]);
				}
			}
		}

		return max;
	}
}

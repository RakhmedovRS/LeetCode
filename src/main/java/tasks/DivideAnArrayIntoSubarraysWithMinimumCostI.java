package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-01-20
 */
@LeetCode(
		id = 3010,
		name = "Divide an Array Into Subarrays With Minimum Cost I",
		url = "https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/description/",
		difficulty = Difficulty.EASY
)
public class DivideAnArrayIntoSubarraysWithMinimumCostI {
	public int minimumCost(int[] nums) {
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < min1) {
				min2 = Math.min(min2, min1);
				min1 = nums[i];
			} else {
				min2 = Math.min(min2, nums[i]);
			}
		}

		return nums[0] + min1 + min2;
	}
}
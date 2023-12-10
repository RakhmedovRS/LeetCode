package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/8/2021
 */
@LeetCode(
		id = 1746,
		name = "Maximum Subarray Sum After One Operation",
		url = "https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumSubarraySumAfterOneOperation {
	public int maxSumAfterOperation(int[] nums) {
		int max = Integer.MIN_VALUE;
		int[][] memo = new int[nums.length][2];
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				memo[i][0] += Math.max(nums[i] + memo[i - 1][0], nums[i]);
				memo[i][1] = Math.max(nums[i] * nums[i], Math.max(memo[i - 1][1] + nums[i], memo[i - 1][0] + nums[i] * nums[i]));
			}
			else {
				memo[i][0] = nums[i];
				memo[i][1] = nums[i] * nums[i];
			}

			max = Math.max(max, nums[i] * nums[i]);
			max = Math.max(max, Math.max(memo[i][0], memo[i][1]));
		}

		return max;
	}
}

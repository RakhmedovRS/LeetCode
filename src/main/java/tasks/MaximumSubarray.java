package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Mar-20
 */
@LeetCode(
		id = 53,
		name = "Maximum Subarray",
		url = "https://leetcode.com/problems/maximum-subarray/",
		difficulty = Difficulty.EASY
)
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int pos = 0;
		int sum = 0;
		while (pos < nums.length) {
			sum += nums[pos++];
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}

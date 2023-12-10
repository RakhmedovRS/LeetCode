package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 31-May-20
 */
@LeetCode(id = 643, name = "Maximum Average Subarray I", url = "https://leetcode.com/problems/maximum-average-subarray-i/")
public class MaximumAverageSubarrayI {
	public double findMaxAverage(int[] nums, int k) {
		double max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i >= k) {
				sum -= nums[i - k];
			}

			if (i + 1 >= k) {
				max = Math.max(max, 1D * sum / k);
			}
		}
		return max;
	}
}

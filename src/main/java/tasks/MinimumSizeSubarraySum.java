package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-May-20
 */
@LeetCode(id = 209, name = "Minimum Size Subarray Sum", url = "https://leetcode.com/problems/minimum-size-subarray-sum/")
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int minLen = nums.length;
		int left = 0;
		int right = 0;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum < s) {
			return 0;
		}

		sum = 0;
		while (right < nums.length || sum >= s) {
			if (sum >= s) {
				minLen = Math.min(minLen, right - left);
				sum -= nums[left++];
			}
			else {
				if (right < nums.length) {
					sum += nums[right++];
				}
				else {
					break;
				}
			}
		}

		return minLen;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
	}
}

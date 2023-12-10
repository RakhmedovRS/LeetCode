package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/29/2023
 */
@LeetCode(
		id = 2918,
		name = "Minimum Equal Sum of Two Arrays After Replacing Zeros",
		url = "https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
	public long minSum(int[] nums1, int[] nums2) {
		long[] a = sumAndZeroes(nums1);
		long[] b = sumAndZeroes(nums2);
		if (a[1] == 0 && b[1] == 0) {
			if (a[0] == b[0]) {
				return a[0];
			}
			else {
				return -1;
			}
		}
		else if (a[1] == 0) {
			if (a[0] < b[0] + b[1]) {
				return -1;
			}
		}
		else if (b[1] == 0) {
			if (b[0] < a[0] + a[1]) {
				return -1;
			}
		}


		return Math.max(a[0] + a[1], b[0] + b[1]);
	}

	private long[] sumAndZeroes(int[] nums) {
		long zeroes = 0;
		long sum = 0;
		for (int num : nums) {
			sum += num;
			if (num == 0) {
				zeroes++;
			}
		}


		return new long[]{sum, zeroes};
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/20/2020
 */
@LeetCode(
		id = 1695,
		name = "Maximum Erasure Value",
		url = "https://leetcode.com/problems/maximum-erasure-value/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumErasureValue {
	public int maximumUniqueSubarray(int[] nums) {
		int max = 0;
		boolean[] used = new boolean[10_000];
		int left = 0;
		int right = 0;
		int sum = 0;
		while (right < nums.length) {
			while (used[nums[right]]) {
				used[nums[left]] = false;
				sum -= nums[left++];
			}

			used[nums[right]] = true;
			sum += nums[right++];

			max = Math.max(max, sum);
		}

		return max;
	}

	public static void main(String[] args) {
		MaximumErasureValue clazz = new MaximumErasureValue();

		System.out.println(clazz.maximumUniqueSubarray(new int[]{1, 2, 3, 4, 5}));
		System.out.println(clazz.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
		System.out.println(clazz.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
	}
}

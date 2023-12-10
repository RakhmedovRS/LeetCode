package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
@LeetCode(id = 167, name = "Two Sum II - Input array is sorted", url = "https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/")
public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		Integer[] memo = new Integer[2001];
		int index;
		for (int i = 0; i < numbers.length; i++) {
			index = target - numbers[i] + 1000;
			if (memo[index] != null) {
				return new int[]{memo[index] + 1, i + 1};
			}

			memo[numbers[i] + 1000] = i;
		}

		return new int[0];
	}
}

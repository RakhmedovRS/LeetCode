package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 5/1/2021
 */
@LeetCode(
		id = 1846,
		name = "Maximum Element After Decreasing and Rearranging",
		url = "https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumElementAfterDecreasingAndRearranging {
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		if (arr.length == 1) {
			return 1;
		}

		Arrays.sort(arr);
		arr[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1] && Math.abs(arr[i] - arr[i - 1]) > 1) {
				arr[i] = arr[i - 1] + 1;
			}
		}

		return arr[arr.length - 1];
	}
}

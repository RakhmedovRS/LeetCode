package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 7/22/2023
 */
@LeetCode(
		id = 2784,
		name = "Check if Array is Good",
		url = "https://leetcode.com/problems/check-if-array-is-good/",
		difficulty = Difficulty.EASY
)
public class CheckIfArrayIsGood {
	public boolean isGood(int[] nums) {
		if (nums.length == 1) {
			return false;
		}

		int[] arr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = i + 1;
		}

		arr[arr.length - 2] = arr[arr.length - 1] = arr.length - 1;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (arr[i] != nums[i]) {
				return false;
			}
		}

		return true;
	}
}

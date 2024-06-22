package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-22
 */
@LeetCode(
		id = 3191,
		name = "Minimum Operations to Make Binary Array Elements Equal to One I",
		url = "https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
	public int minOperations(int[] nums) {
		int[] copy = Arrays.copyOf(nums, nums.length);
		int one = minOperations(copy, 1);
		return one;
	}

	public int minOperations(int[] nums, int target) {
		int ops = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] != target) {
				nums[i] = (nums[i] + 1) % 2;
				nums[i + 1] = (nums[i + 1] + 1) % 2;
				nums[i + 2] = (nums[i + 2] + 1) % 2;
				ops++;
			}
		}

		if (allTarget(nums, target)) {
			return ops;
		}
		return -1;
	}

	private boolean allTarget(int[] nums, int target) {
		for (int num : nums) {
			if (num != target) {
				return false;
			}
		}
		return true;
	}
}
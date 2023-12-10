package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/12/2023
 */
@LeetCode(
		id = 2369,
		name = "Check if There is a Valid Partition For The Array",
		url = "https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/description/",
		difficulty = Difficulty.MEDIUM
)
public class CheckIfThereIsValidPartitionForTheArray {
	public boolean validPartition(int[] nums) {
		return validPartition(0, nums, new Boolean[nums.length]);
	}

	private boolean validPartition(int start, int[] nums, Boolean[] memo) {
		if (start >= nums.length) {
			return true;
		}

		if (memo[start] != null) {
			return memo[start];
		}

		if (start + 2 < nums.length) {
			return memo[start] = (nums[start] == nums[start + 1] && validPartition(start + 2, nums, memo))
					|| (nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2] && validPartition(start + 3, nums, memo))
					|| (nums[start] == nums[start + 1] - 1 && nums[start + 1] == nums[start + 2] - 1 && validPartition(start + 3, nums, memo));
		}
		else if (start + 1 < nums.length) {
			return memo[start] = nums[start] == nums[start + 1] && validPartition(start + 2, nums, memo);
		}

		return memo[start] = false;
	}
}

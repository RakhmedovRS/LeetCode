package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/22/2023
 */
@LeetCode(
		id = 2789,
		name = "Largest Element in an Array after Merge Operations",
		url = "https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations/",
		difficulty = Difficulty.MEDIUM
)
public class LargestElementInArrayAfterMergeOperations {
	public long maxArrayValue(int[] nums) {
		long max = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] <= max) {
				max += nums[i];
			}
			else {
				max = nums[i];
			}
		}

		return max;
	}
}

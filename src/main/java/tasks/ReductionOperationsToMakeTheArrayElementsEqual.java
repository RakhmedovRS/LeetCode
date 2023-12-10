package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 6/6/2021
 */
@LeetCode(
		id = 1887,
		name = "Reduction Operations to Make the Array Elements Equal",
		url = "https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/",
		difficulty = Difficulty.MEDIUM
)
public class ReductionOperationsToMakeTheArrayElementsEqual {
	public int reductionOperations(int[] nums) {
		int operations = 0;
		Arrays.sort(nums);
		for (int j = nums.length - 1; j > 0; j--) {
			if (nums[j - 1] != nums[j]) {
				operations += nums.length - j;
			}
		}

		return operations;
	}
}

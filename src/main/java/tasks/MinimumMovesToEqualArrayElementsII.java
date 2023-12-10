package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 9/24/2020
 */
@LeetCode(
		id = 462,
		name = "Minimum Moves to Equal Array Elements II",
		url = "https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumMovesToEqualArrayElementsII {
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int median;
		if (nums.length % 2 == 0) {
			median = (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
		}
		else {
			median = nums[nums.length / 2];
		}

		int steps = 0;
		for (int num : nums) {
			steps += Math.abs(median - num);
		}

		return steps;
	}
}

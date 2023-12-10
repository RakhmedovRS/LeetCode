package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11-Jul-20
 */
@LeetCode(id = 1509, name = "Minimum Difference Between Largest and Smallest Value in Three Moves", url = "https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/")
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
	public int minDifference(int[] nums) {
		if (nums.length <= 4) {
			return 0;
		}

		Arrays.sort(nums);
		int min = nums[nums.length - 1] - nums[0];
		for (int i = 0; i < 4; i++) {
			min = Math.min(min, nums[nums.length - (4 - i)] - nums[i]);
		}

		return min;
	}
}

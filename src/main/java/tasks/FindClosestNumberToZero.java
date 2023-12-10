package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 4/16/2022
 */
@LeetCode(
		id = 2239,
		name = "Find Closest Number to Zero",
		url = "https://leetcode.com/problems/find-closest-number-to-zero/",
		difficulty = Difficulty.EASY
)
public class FindClosestNumberToZero {
	public int findClosestNumber(int[] nums) {
		Arrays.sort(nums);
		int min = nums[0];
		int max = nums[nums.length - 1];
		for (int num : nums) {
			if (num < 0) {
				min = num;
			}
			if (num > 0) {
				max = num;
				break;
			}

			if (num == 0) {
				return 0;
			}
		}

		if (max <= Math.abs(min)) {
			return max;
		}
		return min;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @since 25.02.2021
 */
@LeetCode(
		id = 581,
		name = "Shortest Unsorted Continuous Subarray",
		url = "https://leetcode.com/problems/shortest-unsorted-continuous-subarray/",
		difficulty = Difficulty.MEDIUM
)
public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int[] sorted = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sorted);
		int left = 0;
		int right = nums.length - 1;
		boolean shifted = true;
		while (shifted && left <= right) {
			shifted = false;
			if (nums[left] == sorted[left]) {
				shifted = true;
				left++;
			}

			if (nums[right] == sorted[right]) {
				shifted = true;
				right--;
			}
		}

		return Math.max(0, 1 + right - left);
	}
}

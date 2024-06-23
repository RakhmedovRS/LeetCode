package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-22
 */
@LeetCode(
		id = 3194,
		name = "Minimum Average of Smallest and Largest Elements",
		url = "https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/",
		difficulty = Difficulty.EASY
)
public class MinimumAverageOfSmallestAndLargestElements {
	public double minimumAverage(int[] nums) {
		Arrays.sort(nums);
		double min = Double.MAX_VALUE;
		for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
			min = Math.min(min, (1d * nums[left] + nums[right]) / 2);
		}
		return min;
	}
}
package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/31/2021
 */
@LeetCode(
		id = 153,
		name = "Find Minimum in Rotated Sorted Array",
		url = "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/",
		difficulty = Difficulty.MEDIUM
)
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
		}
		return min;
	}
}

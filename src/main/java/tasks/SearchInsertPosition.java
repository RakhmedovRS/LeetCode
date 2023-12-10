package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Jun-20
 */
@LeetCode(
		id = 35,
		name = "Search Insert Position",
		url = "https://leetcode.com/problems/search-insert-position/",
		difficulty = Difficulty.EASY
)
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		int middle;
		while (left < right) {
			middle = left + (right - left) / 2;
			if (nums[middle] == target) {
				return middle;
			}
			else if (nums[middle] > target) {
				right = middle;
			}
			else {
				left = middle + 1;
			}
		}

		return left;
	}
}

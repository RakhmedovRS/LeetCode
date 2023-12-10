package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-May-20
 */
@LeetCode(id = 540, name = "Single Element in a Sorted Array", url = "https://leetcode.com/problems/single-element-in-a-sorted-array/")
public class SingleElementInSortedArray {
	public int singleNonDuplicate(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int middle;
		while (left < right) {
			middle = left + (right - left) / 2;
			boolean even = (right - middle) % 2 == 0;
			if (nums[middle] == nums[middle - 1]) {
				if (even) {
					right = middle - 2;
				}
				else {
					left = middle + 1;
				}
			}
			else if (nums[middle] == nums[middle + 1]) {
				if (even) {
					left = middle + 2;
				}
				else {
					right = middle - 1;
				}
			}
			else {
				return nums[middle];
			}
		}

		return nums[left];
	}
}

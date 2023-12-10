package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Jun-20
 */
@LeetCode(id = 1287, name = "Element Appearing More Than 25% In Sorted Array", url = "https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/")
public class ElementAppearingMoreThan25PercentInSortedArray {
	public int findSpecialInteger(int[] arr) {
		int window = arr.length / 4 + 1;
		for (int i = 0; i <= arr.length - window; i++) {
			if (arr[i] == arr[i + window - 1]) {
				return arr[i];
			}
		}

		return arr[0];
	}
}

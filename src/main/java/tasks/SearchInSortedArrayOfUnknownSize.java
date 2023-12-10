package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/15/2021
 */
@LeetCode(
		id = 702,
		name = "Search in a Sorted Array of Unknown Size",
		url = "https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class SearchInSortedArrayOfUnknownSize {
	interface ArrayReader {
		int get(int index);
	}

	public int search(ArrayReader reader, int target) {
		int left = 0;
		int right = 10_000;
		int mid;
		int val;
		while (left <= right) {
			mid = (left + right) / 2;
			val = reader.get(mid);
			if (val == target) {
				return mid;
			}
			else if (val > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}

		return -1;
	}
}

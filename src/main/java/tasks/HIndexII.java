package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18.06.2020
 */
@LeetCode(
		id = 275,
		name = "H-Index II",
		url = "https://leetcode.com/problems/h-index-ii/",
		difficulty = Difficulty.MEDIUM
)
public class HIndexII {
	public int hIndex(int[] citations) {
		int left = 0;
		int middle;
		int right = citations.length;
		int n = right;
		int x;
		while (left < right) {
			middle = left + (right - left) / 2;
			x = n - middle;
			if (x == citations[middle]) {
				return x;
			}
			else if (x > citations[middle]) {
				left = middle + 1;
			}
			else {
				right = middle;
			}
		}

		return n - left;
	}
}

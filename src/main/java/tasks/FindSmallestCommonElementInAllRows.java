package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/11/2021
 */
@LeetCode(
		id = 1198,
		name = "Find Smallest Common Element in All Rows",
		url = "https://leetcode.com/problems/find-smallest-common-element-in-all-rows/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class FindSmallestCommonElementInAllRows {
	public int smallestCommonElement(int[][] mat) {
		int min = Integer.MAX_VALUE;
		int[] map = new int[10_001];
		for (int[] row : mat) {
			for (int i = 0; i < row.length; i++) {
				if (i > 0 && row[i - 1] == row[i]) {
					continue;
				}

				map[row[i]]++;
				if (map[row[i]] >= mat.length) {
					min = Math.min(min, row[i]);
				}
			}
		}

		return min == Integer.MAX_VALUE ? -1 : min;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 5/7/2023
 */
@LeetCode(
		id = 2672,
		name = "Number of Adjacent Elements With the Same Color",
		url = "https://leetcode.com/problems/number-of-adjacent-elements-with-the-same-color/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfAdjacentElementsWithTheSameColor {
	public int[] colorTheArray(int n, int[][] queries) {
		int adj = 0;
		int[] arr = new int[n];
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int pos = queries[i][0];
			int col = queries[i][1];

			if (pos - 1 >= 0 && arr[pos - 1] == arr[pos] && arr[pos] != 0) {
				adj--;
			}

			if (pos + 1 < arr.length && arr[pos + 1] == arr[pos] && arr[pos] != 0) {
				adj--;
			}

			arr[pos] = col;

			if (pos - 1 >= 0 && arr[pos - 1] == arr[pos] && arr[pos] != 0) {
				adj++;
			}

			if (pos + 1 < arr.length && arr[pos + 1] == arr[pos] && arr[pos] != 0) {
				adj++;
			}

			ans[i] = adj;
		}

		return ans;
	}
}

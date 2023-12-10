package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Jun-20
 */
@LeetCode(id = 931, name = "Minimum Falling Path Sum", url = "https://leetcode.com/problems/minimum-falling-path-sum/")
public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] A) {
		int rows = A.length;
		int columns = A[0].length;
		for (int row = 1; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				int left = column - 1 < 0 ? Integer.MAX_VALUE : A[row - 1][column - 1];
				int middle = A[row - 1][column];
				int right = column + 1 == columns ? Integer.MAX_VALUE : A[row - 1][column + 1];
				A[row][column] += Math.min(middle, Math.min(left, right));
			}
		}

		int min = Integer.MAX_VALUE;
		for (int value : A[A.length - 1]) {
			min = Math.min(min, value);
		}

		return min;
	}
}

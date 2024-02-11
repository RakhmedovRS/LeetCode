package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-02-10
 */
@LeetCode(
		id = 3033,
		name = "Modify the Matrix",
		url = "https://leetcode.com/problems/modify-the-matrix/description/",
		difficulty = Difficulty.EASY
)
public class ModifyTheMatrix {
	public int[][] modifiedMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == -1) {
					matrix[row][column] = getMax(matrix, column);
				}
			}
		}

		return matrix;
	}

	private int getMax(int[][] matrix, int column) {
		int max = 0;
		for (int row = 0; row < matrix.length; row++) {
			max = Math.max(max, matrix[row][column]);
		}
		return max;
	}
}
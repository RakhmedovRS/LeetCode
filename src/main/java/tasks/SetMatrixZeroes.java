package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 01-Apr-20
 */
@LeetCode(
		id = 73,
		name = "Set Matrix Zeroes",
		url = "https://leetcode.com/problems/set-matrix-zeroes/",
		difficulty = Difficulty.MEDIUM
)
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;

		boolean[] rowState = new boolean[rows];
		boolean[] columnState = new boolean[columns];

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (matrix[row][column] == 0) {
					rowState[row] = true;
					columnState[column] = true;
				}
			}
		}

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (rowState[row] || columnState[column]) {
					matrix[row][column] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};

		new SetMatrixZeroes().setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));

		matrix = new int[][]{
				{0, 1}
		};

		new SetMatrixZeroes().setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}

package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18-May-20
 */
@LeetCode(id = 766, name = "Toeplitz Matrix", url = "https://leetcode.com/problems/toeplitz-matrix/")
public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;

		for (int row = 1; row < rows; row++) {
			for (int column = 1; column < columns; column++) {
				if (matrix[row][column] != matrix[row - 1][column - 1]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(new ToeplitzMatrix().isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
	}
}

package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-May-20
 */
@LeetCode(id = 867, name = "Transpose Matrix", url = "https://leetcode.com/problems/transpose-matrix/")
public class TransposeMatrix {
	public int[][] transpose(int[][] A) {
		int rows = A.length;
		int columns = A[0].length;
		int[][] matrix = new int[columns][rows];
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				matrix[column][row] = A[row][column];
			}
		}

		return matrix;
	}
}

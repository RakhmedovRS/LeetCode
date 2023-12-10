package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Jun-20
 */
@LeetCode(
		id = 566,
		name = "Reshape the Matrix",
		url = "https://leetcode.com/problems/reshape-the-matrix/",
		difficulty = Difficulty.EASY
)
public class ReshapeTheMatrix {
	public int[][] matrixReshape(int[][] mat, int r, int c) {
		int rows = mat.length;
		int columns = mat[0].length;
		if (rows * columns != r * c) {
			return mat;
		}

		int[][] newMat = new int[r][c];
		int newMatRow = 0;
		int newManColumn = 0;

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				newMat[newMatRow][newManColumn++] = mat[row][column];
				if (newManColumn == c) {
					newMatRow++;
					newManColumn = 0;
				}
			}
		}

		return newMat;
	}
}

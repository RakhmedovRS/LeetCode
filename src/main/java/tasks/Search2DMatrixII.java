package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(
		id = 240,
		name = "Search a 2D Matrix II",
		url = "https://leetcode.com/problems/search-a-2d-matrix-ii/",
		difficulty = Difficulty.MEDIUM
)
public class Search2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = 0;
		int column = matrix[row].length - 1;
		while (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length) {
			if (matrix[row][column] == target) {
				return true;
			}
			if (matrix[row][column] < target) {
				row++;
			}
			else {
				column--;
			}
		}

		return false;
	}
}

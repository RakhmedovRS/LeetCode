package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Jul-20
 */
@LeetCode(id = 1504, name = "Count Submatrices With All Ones", url = "https://leetcode.com/problems/count-submatrices-with-all-ones/")
public class CountSubmatricesWithAllOnes {
	public int numSubmat(int[][] mat) {
		int rows = mat.length;
		int columns = mat[0].length;
		for (int row = 0; row < rows; row++) {
			for (int column = 1; column < columns; column++) {
				mat[row][column] += mat[row][column] == 0 ? 0 : mat[row][column - 1];
			}
		}

		int result = 0;
		for (int row = 0; row < mat.length; row++) {
			for (int column = 0; column < mat[row].length; column++) {
				result += mat[row][column];
				int min = mat[row][column];
				for (int r = row + 1; r < mat.length; r++) {
					if (mat[r][column] == 0) {
						break;
					}
					min = Math.min(min, mat[r][column]);
					result += min;
				}
			}
		}
		return result;
	}
}

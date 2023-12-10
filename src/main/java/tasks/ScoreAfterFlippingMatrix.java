package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-Jul-20
 */
@LeetCode(
		id = 861,
		name = "Score After Flipping Matrix",
		url = "https://leetcode.com/problems/score-after-flipping-matrix/",
		difficulty = Difficulty.MEDIUM
)
public class ScoreAfterFlippingMatrix {
	public int matrixScore(int[][] matrix) {

		for (int[] row : matrix) {
			if (row[0] == 0) {
				flip(row);
			}
		}

		int minOnesCount = matrix.length % 2 == 0 ? matrix.length / 2 : (matrix.length + 1) / 2;
		for (int column = 1; column < matrix[0].length; column++) {
			int count = 0;
			for (int[] row : matrix) {
				count += row[column];
			}

			if (count < minOnesCount) {
				for (int[] row : matrix) {
					row[column] = (row[column] + 1) % 2;
				}
			}
		}

		int result = 0;
		for (int[] row : matrix) {
			int rowRes = 0;
			for (int value : row) {
				rowRes <<= 1;
				rowRes ^= value;
			}
			result += rowRes;
		}

		return result;
	}

	private void flip(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (arr[i] + 1) % 2;
		}
	}
}

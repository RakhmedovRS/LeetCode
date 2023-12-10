package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/6/2021
 */
@LeetCode(
		id = 1886,
		name = "Determine Whether Matrix Can Be Obtained By Rotation",
		url = "https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/",
		difficulty = Difficulty.EASY
)
public class DetermineWhetherMatrixCanBeObtainedByRotation {
	public boolean findRotation(int[][] mat, int[][] target) {
		outer:
		for (int i = 0; i < 4; i++) {
			rotate(mat);
			for (int row = 0; row < mat.length; row++) {
				for (int column = 0; column < mat[row].length; column++) {
					if (mat[row][column] != target[row][column]) {
						continue outer;
					}
				}
			}

			return true;
		}

		return false;
	}

	public void rotate(int[][] matrix) {
		int rows = matrix.length;
		if (rows <= 1) {
			return;
		}
		int columns = matrix[0].length;

		int temp;
		for (int[] row : matrix) {
			int left = 0;
			int right = columns - 1;
			while (left < right) {
				temp = row[left];
				row[left] = row[right];
				row[right] = temp;
				left++;
				right--;
			}
		}

		int[] left = new int[]{rows - 2, 0};
		int[] right = new int[]{rows - 1, 1};
		while (left[1] != right[1]) {
			for (int r1 = left[0], c1 = left[1], r2 = right[0], c2 = right[1]; r1 < r2 && c1 < c2; r1++, c1++, r2--, c2--) {

				temp = matrix[r1][c1];
				matrix[r1][c1] = matrix[r2][c2];
				matrix[r2][c2] = temp;
			}

			if (left[0] == 0) {
				left[1]++;
			}
			else {
				left[0]--;
			}

			if (right[1] == columns - 1) {
				right[0]--;
			}
			else {
				right[1]++;
			}
		}
	}
}

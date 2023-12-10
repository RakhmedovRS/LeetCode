package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/9/2023
 */
@LeetCode(
		id = 2850,
		name = "Minimum Moves to Spread Stones Over Grid",
		url = "https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumMovesToSpreadStonesOverGrid {
	public int minimumMoves(int[][] grid) {
		if (isValid(grid)) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == 0) {
					for (int a = 0; a < 3; a++) {
						for (int b = 0; b < 3; b++) {
							if (grid[a][b] > 1) {
								int d = manhattanDistance(new int[]{i, j}, new int[]{a, b});
								grid[a][b]--;
								grid[i][j]++;
								min = Math.min(min, d + minimumMoves(grid));
								grid[a][b]++;
								grid[i][j]--;
							}
						}
					}
				}
			}
		}

		return min;
	}

	public static int manhattanDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	private boolean isValid(int[][] grid) {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (grid[r][c] != 1) {
					return false;
				}
			}
		}

		return true;
	}
}

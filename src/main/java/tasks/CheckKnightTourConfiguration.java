package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/24/2023
 */
@LeetCode(
		id = 2596,
		name = "Check Knight Tour Configuration",
		url = "https://leetcode.com/problems/check-knight-tour-configuration/",
		difficulty = Difficulty.MEDIUM
)
public class CheckKnightTourConfiguration {
	public boolean checkValidGrid(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;

		int visited = 0;
		int row = 0;
		int column = 0;
		int[][] steps = new int[][]{
				{-1, -2},
				{-2, -1},
				{-2, 1},
				{-1, 2},
				{1, 2},
				{2, 1},
				{2, -1},
				{1, -2}
		};

		boolean[][] seen = new boolean[rows][columns];

		boolean hasNextStep = true;
		while (hasNextStep) {
			hasNextStep = false;
			for (int[] step : steps) {
				int r = row + step[0];
				int c = column + step[1];
				if (r >= 0 && r < rows && c >= 0 && c < columns && grid[r][c] == grid[row][column] + 1 && !seen[r][c]) {
					hasNextStep = true;
					visited++;
					row = r;
					column = c;
					seen[r][c] = true;
					break;
				}
			}
		}

		return visited == (rows * columns) - 1;
	}
}

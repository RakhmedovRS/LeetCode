package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/20/2021
 */
@LeetCode(
		id = 1254,
		name = "Number of Closed Islands",
		url = "https://leetcode.com/problems/number-of-closed-islands/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfClosedIslands {
	public int closedIsland(int[][] grid) {
		int count = 0;
		int rows = grid.length;
		if (rows == 0) {
			return count;
		}
		int columns = grid[0].length;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (grid[row][column] == 0) {
					count += isSurrounded(row, column, rows, columns, grid, new boolean[rows][columns]) ? 1 : 0;
				}
			}
		}

		return count;
	}

	private boolean isSurrounded(int row, int column, int rows, int columns, int[][] grid, boolean[][] visited) {
		if (row < 0 || row == rows || column < 0 || column == columns) {
			return false;
		}

		if (grid[row][column] == 1 || visited[row][column]) {
			return true;
		}

		visited[row][column] = true;

		grid[row][column] = -1;

		return isSurrounded(row - 1, column, rows, columns, grid, visited)
				&& isSurrounded(row + 1, column, rows, columns, grid, visited)
				&& isSurrounded(row, column - 1, rows, columns, grid, visited)
				&& isSurrounded(row, column + 1, rows, columns, grid, visited);
	}
}

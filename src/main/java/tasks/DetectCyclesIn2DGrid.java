package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Aug-20
 */
@LeetCode(id = 1559, name = "Detect Cycles in 2D Grid", url = "https://leetcode.com/problems/detect-cycles-in-2d-grid/")
public class DetectCyclesIn2DGrid {
	enum Step {
		UP,
		DOWN,
		LEFT,
		RIGHT,
		NONE
	}

	public boolean containsCycle(char[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (Character.isLowerCase(grid[row][column]) && dfs(grid, row, column, rows, columns, grid[row][column], 0, Step.NONE)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] grid, int row, int column, int rows, int columns, char ch, int step, Step cameFrom) {
		if (row < 0 || row == rows || column < 0 || column == columns) {
			return false;
		}

		if (grid[row][column] == Character.toUpperCase(ch)) {
			return step >= 4;
		}

		if (grid[row][column] != ch) {
			return false;
		}

		grid[row][column] = Character.toUpperCase(ch);

		if (cameFrom == Step.NONE) {
			return dfs(grid, row - 1, column, rows, columns, ch, step + 1, Step.DOWN)
					|| dfs(grid, row + 1, column, rows, columns, ch, step + 1, Step.UP)
					|| dfs(grid, row, column - 1, rows, columns, ch, step + 1, Step.RIGHT)
					|| dfs(grid, row, column + 1, rows, columns, ch, step + 1, Step.LEFT);
		}
		else if (cameFrom == Step.UP) {
			return dfs(grid, row + 1, column, rows, columns, ch, step + 1, Step.UP)
					|| dfs(grid, row, column - 1, rows, columns, ch, step + 1, Step.RIGHT)
					|| dfs(grid, row, column + 1, rows, columns, ch, step + 1, Step.LEFT);
		}
		else if (cameFrom == Step.DOWN) {
			return dfs(grid, row - 1, column, rows, columns, ch, step + 1, Step.DOWN)
					|| dfs(grid, row, column - 1, rows, columns, ch, step + 1, Step.RIGHT)
					|| dfs(grid, row, column + 1, rows, columns, ch, step + 1, Step.LEFT);
		}
		else if (cameFrom == Step.LEFT) {
			return dfs(grid, row - 1, column, rows, columns, ch, step + 1, Step.DOWN)
					|| dfs(grid, row + 1, column, rows, columns, ch, step + 1, Step.UP)
					|| dfs(grid, row, column + 1, rows, columns, ch, step + 1, Step.LEFT);
		}
		else {
			return dfs(grid, row - 1, column, rows, columns, ch, step + 1, Step.DOWN)
					|| dfs(grid, row + 1, column, rows, columns, ch, step + 1, Step.UP)
					|| dfs(grid, row, column - 1, rows, columns, ch, step + 1, Step.RIGHT);
		}
	}
}

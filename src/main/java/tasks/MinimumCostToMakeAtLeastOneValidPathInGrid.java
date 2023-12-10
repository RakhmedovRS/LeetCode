package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/21/2020
 */
@LeetCode(
		id = 1368,
		name = "Minimum Cost to Make at Least One Valid Path in a Grid",
		url = "https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/",
		difficulty = Difficulty.HARD
)
public class MinimumCostToMakeAtLeastOneValidPathInGrid {
	int[][] directions = new int[][]{{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public int minCost(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] changed = new boolean[rows][columns];
		int[][] memo = new int[rows][columns];
		for (int[] row : memo) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dfs(0, 0, rows, columns, grid, changed, memo, 0);

		return memo[rows - 1][columns - 1];
	}

	private void dfs(int row, int column, int rows, int columns, int[][] grid, boolean[][] changed, int[][] memo, int changedCells) {
		if (row < 0 || row == rows || column < 0 || column == columns || memo[row][column] <= changedCells) {
			return;
		}

		memo[row][column] = changedCells;
		if (row == rows - 1 && column == columns - 1) {
			return;
		}

		int current = grid[row][column];
		dfs(row + directions[current][0], column + directions[current][1], rows, columns, grid, changed, memo, changedCells);
		if (!changed[row][column]) {
			changed[row][column] = true;
			for (int i = 1; i <= 4; i++) {
				if (current != i) {
					grid[row][column] = i;
					dfs(row + directions[i][0], column + directions[i][1], rows, columns, grid, changed, memo, changedCells + 1);
					grid[row][column] = current;
				}
			}

			changed[row][column] = false;
		}
	}
}

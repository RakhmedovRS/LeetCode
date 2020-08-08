import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 08-Aug-20
 */
@LeetCode(id = 576, name = "Out of Boundary Paths", url = "https://leetcode.com/problems/out-of-boundary-paths/")
public class OutOfBoundaryPaths
{
	public int findPaths(int rows, int columns, int steps, int row, int column)
	{
		int[][][] grid = new int[rows][columns][steps + 1];
		for (int[][] gridRow : grid)
		{
			for (int[] gridSubRow : gridRow)
			{
				Arrays.fill(gridSubRow, -1);
			}
		}
		return dfs(grid, row, column, rows, columns, steps) % (int) (1e9 + 7);
	}

	private int dfs(int[][][] grid, int row, int column, int rows, int columns, int steps)
	{
		if (row < 0 || row == rows || column < 0 || column == columns)
		{
			return 1;
		}

		if (steps == 0)
		{
			return 0;
		}

		if (grid[row][column][steps] >= 0)
		{
			return grid[row][column][steps];
		}

		int left = dfs(grid, row, column - 1, rows, columns, steps - 1) % (int) (1e9 + 7);
		int right = dfs(grid, row, column + 1, rows, columns, steps - 1) % (int) (1e9 + 7);
		int up = dfs(grid, row - 1, column, rows, columns, steps - 1) % (int) (1e9 + 7);
		int down = dfs(grid, row + 1, column, rows, columns, steps - 1) % (int) (1e9 + 7);

		int ways = left;
		ways = (ways + right) % (int) (1e9 + 7);
		ways = (ways + up) % (int) (1e9 + 7);
		ways = (ways + down) % (int) (1e9 + 7);
		grid[row][column][steps] = ways;

		return grid[row][column][steps];
	}
}

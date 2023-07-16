package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Jun-20
 */
@LeetCode(
		id = 695,
		name = "Max Area of Island",
		url = "https://leetcode.com/problems/max-area-of-island/",
		difficulty = Difficulty.MEDIUM
)
public class MaxAreaOfIsland
{
	public int maxAreaOfIsland(int[][] grid)
	{
		int rows = grid.length;
		if (rows == 0)
		{
			return 0;
		}
		int columns = grid[0].length;

		int max = 0;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 1)
				{
					max = Math.max(max, dfs(row, column, rows, columns, grid));
				}
			}
		}

		return max;
	}

	private int dfs(int row, int column, int rows, int columns, int[][] grid)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || grid[row][column] == 0)
		{
			return 0;
		}

		grid[row][column] = 0;

		return 1 + dfs(row - 1, column, rows, columns, grid)
				+ dfs(row + 1, column, rows, columns, grid)
				+ dfs(row, column - 1, rows, columns, grid)
				+ dfs(row, column + 1, rows, columns, grid);
	}
}

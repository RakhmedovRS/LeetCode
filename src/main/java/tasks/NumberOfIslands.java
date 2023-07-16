package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-Mar-20
 */
@LeetCode(
		id = 200,
		name = "Number of Islands",
		url = "https://leetcode.com/problems/number-of-islands/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfIslands
{
	public int numIslands(char[][] grid)
	{
		if (grid == null || grid.length == 0)
		{
			return 0;
		}

		int islands = 0;
		for (int row = 0; row < grid.length; row++)
		{
			for (int column = 0; column < grid[row].length; column++)
			{
				if (grid[row][column] == '1')
				{
					islands += dfs(grid, row, column);
				}
			}
		}

		return islands;
	}

	private int dfs(char[][] grid, int row, int column)
	{
		if (row < 0 || column < 0 || row >= grid.length || column >= grid[row].length || grid[row][column] == '0')
		{
			return 0;
		}

		grid[row][column] = '0';

		dfs(grid, row - 1, column);
		dfs(grid, row + 1, column);
		dfs(grid, row, column - 1);
		dfs(grid, row, column + 1);

		return 1;
	}
}

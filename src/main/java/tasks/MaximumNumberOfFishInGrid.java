package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/30/2023
 */
@LeetCode(
		id = 2658,
		name = "Maximum Number of Fish in a Grid",
		url = "https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfFishInGrid
{
	public int findMaxFish(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] visited = new boolean[rows][columns];
		int max = 0;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (visited[row][column])
				{
					continue;
				}

				max = Math.max(max, dfs(grid, row, column, visited, rows, columns));
			}
		}

		return max;
	}

	private int dfs(int[][] grid, int row, int column, boolean[][] visited, int rows, int columns)
	{
		if (row < 0 || row >= rows || column < 0 || column >= columns || visited[row][column] || grid[row][column] == 0)
		{
			return 0;
		}

		visited[row][column] = true;
		int sum = grid[row][column];
		sum += dfs(grid, row - 1, column, visited, rows, columns);
		sum += dfs(grid, row + 1, column, visited, rows, columns);
		sum += dfs(grid, row, column - 1, visited, rows, columns);
		sum += dfs(grid, row, column + 1, visited, rows, columns);

		return sum;
	}
}

package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Jun-20
 */
@LeetCode(id = 695, name = "Max Area of Island", url = "https://leetcode.com/problems/max-area-of-island/")
public class MaxAreaOfIsland
{
	public int maxAreaOfIsland(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;

		int max = 0;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 1)
				{
					max = Math.max(max, traverse(grid, row, column, rows, columns));
				}
			}
		}

		return max;
	}

	private int traverse(int[][] grid, int row, int column, int rows, int columns)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || grid[row][column] == 0)
		{
			return 0;
		}

		grid[row][column] = 0;

		return 1
			+ traverse(grid, row - 1, column, rows, columns)
			+ traverse(grid, row + 1, column, rows, columns)
			+ traverse(grid, row, column - 1, rows, columns)
			+ traverse(grid, row, column + 1, rows, columns);
	}
}

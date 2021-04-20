package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-May-20
 */
@LeetCode(id = 1219, name = "Path with Maximum Gold", url = "https://leetcode.com/problems/path-with-maximum-gold/")
public class PathWithMaximumGold
{
	public int getMaximumGold(int[][] grid)
	{
		int max = 0;
		for (int row = 0; row < grid.length; row++)
		{
			for (int column = 0; column < grid[row].length; column++)
			{
				int currentMax = getMaximumGold(grid, row, column);
				if (currentMax > max)
				{
					max = currentMax;
				}
			}
		}

		return max;
	}

	private int getMaximumGold(int[][] grid, int row, int column)
	{
		if (row < 0 || row == grid.length || column < 0 || column == grid[row].length || grid[row][column] == 0)
		{
			return 0;
		}

		int current = grid[row][column];
		grid[row][column] = 0;
		int left = getMaximumGold(grid, row, column - 1);
		int right = getMaximumGold(grid, row, column + 1);
		int up = getMaximumGold(grid, row - 1, column);
		int bottom = getMaximumGold(grid, row + 1, column);
		grid[row][column] = current;

		return current + Math.max(Math.max(left, right), Math.max(up, bottom));
	}
}

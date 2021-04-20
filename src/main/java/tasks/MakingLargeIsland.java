package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/20/2020
 */
@LeetCode(id = 827, name = "Making A Large Island", url = "https://leetcode.com/problems/making-a-large-island/")
public class MakingLargeIsland
{
	public int largestIsland(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		int max = 0;
		int count;

		Integer[][] indices = new Integer[rows][columns];
		int id = 0;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 1)
				{
					count = countSizeAndEraseIsland(row, column, rows, columns, grid, indices, id++);
					setIslandSize(row, column, rows, columns, grid, count);
					max = Math.max(max, count);
				}
			}
		}

		int x;
		int y;
		Set<Integer> ids;
		int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				ids = new HashSet<>();
				count = 0;
				if (grid[row][column] == 0)
				{
					for (int[] direction : directions)
					{
						x = row + direction[0];
						y = column + direction[1];
						if (x < 0
							|| x == rows
							|| y < 0
							|| y == columns
							|| grid[x][y] == 0)
						{
							continue;
						}

						if (ids.add(indices[x][y]))
						{
							count += grid[x][y];
						}
					}

					max = Math.max(max, count + 1);
				}
			}
		}

		return max;
	}

	private int countSizeAndEraseIsland(int row, int column, int rows, int columns, int[][] grid, Integer[][] indices, int id)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || grid[row][column] != 1)
		{
			return 0;
		}

		grid[row][column] = -1;
		indices[row][column] = id;
		return 1
			+ countSizeAndEraseIsland(row - 1, column, rows, columns, grid, indices, id)
			+ countSizeAndEraseIsland(row + 1, column, rows, columns, grid, indices, id)
			+ countSizeAndEraseIsland(row, column - 1, rows, columns, grid, indices, id)
			+ countSizeAndEraseIsland(row, column + 1, rows, columns, grid, indices, id);
	}

	private void setIslandSize(int row, int column, int rows, int columns, int[][] grid, int size)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || grid[row][column] != -1)
		{
			return;
		}

		grid[row][column] = size;

		setIslandSize(row - 1, column, rows, columns, grid, size);
		setIslandSize(row + 1, column, rows, columns, grid, size);
		setIslandSize(row, column - 1, rows, columns, grid, size);
		setIslandSize(row, column + 1, rows, columns, grid, size);
	}
}

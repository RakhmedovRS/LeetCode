package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/20/2020
 */
@LeetCode(
	id = 827,
	name = "Making A Large Island",
	url = "https://leetcode.com/problems/making-a-large-island/",
	difficulty = Difficulty.HARD
)
public class MakingLargeIsland
{
	public int largestIsland(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;

		int max = 0;
		boolean[][] visited = new boolean[rows][columns];
		int[][] ids = new int[rows][columns];
		int id = 1;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 1)
				{
					int count = dfs(row, column, rows, columns, grid, visited);
					setArea(row, column, rows, columns, grid, count, id++, ids);
					max = Math.max(max, count);
				}
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 0)
				{
					int sum = 1;
					Set<Integer> usedIds = new HashSet<>();
					if (row - 1 >= 0 && usedIds.add(ids[row - 1][column]))
					{
						sum += grid[row - 1][column];
					}

					if (row + 1 < rows && usedIds.add(ids[row + 1][column]))
					{
						sum += grid[row + 1][column];
					}

					if (column - 1 >= 0 && usedIds.add(ids[row][column - 1]))
					{
						sum += grid[row][column - 1];
					}

					if (column + 1 < columns && usedIds.add(ids[row][column + 1]))
					{
						sum += grid[row][column + 1];
					}

					max = Math.max(max, sum);
				}
			}
		}

		return max;
	}

	private int dfs(int row, int column, int rows, int columns, int[][] grid, boolean[][] visited)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || visited[row][column] || grid[row][column] != 1)
		{
			return 0;
		}

		visited[row][column] = true;
		return 1 + dfs(row - 1, column, rows, columns, grid, visited)
			+ dfs(row + 1, column, rows, columns, grid, visited)
			+ dfs(row, column - 1, rows, columns, grid, visited)
			+ dfs(row, column + 1, rows, columns, grid, visited);
	}

	private void setArea(int row, int column, int rows, int columns, int[][] grid, int count, int id, int[][] ids)
	{
		if (row < 0 || row == rows || column < 0 || column == columns || grid[row][column] != 1)
		{
			return;
		}

		grid[row][column] = count;
		ids[row][column] = id;

		setArea(row - 1, column, rows, columns, grid, count, id, ids);
		setArea(row + 1, column, rows, columns, grid, count, id, ids);
		setArea(row, column - 1, rows, columns, grid, count, id, ids);
		setArea(row, column + 1, rows, columns, grid, count, id, ids);
	}
}

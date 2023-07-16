package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Sep-20
 */
@LeetCode(id = 749, name = "Contain Virus", url = "https://leetcode.com/problems/contain-virus/")
public class ContainVirus
{
	int[][] grid;
	int rows;
	int columns;

	public int containVirus(int[][] grid)
	{
		this.grid = grid;
		rows = grid.length;
		columns = grid[0].length;
		int walls = 0;
		while (true)
		{
			int val = 2;
			int maxCount = 0;
			int x = 0;
			int y = 0;
			for (int row = 0; row < rows; row++)
			{
				for (int column = 0; column < columns; column++)
				{
					if (grid[row][column] != 1)
					{
						continue;
					}

					int cnt = dfs(row, column, 2, val++);

					if (cnt > maxCount)
					{
						x = row;
						y = column;
						maxCount = cnt;
					}
				}
			}
			if (maxCount == 0)
			{
				return walls;
			}
			for (int row = 0; row < rows; row++)
			{
				for (int column = 0; column < columns; column++)
				{
					if (grid[row][column] < -1)
					{
						grid[row][column] = 0;
					}
				}
			}

			walls += buildWalls(x, y, -1);

			for (int row = 0; row < rows; row++)
			{
				for (int column = 0; column < columns; column++)
				{
					if (grid[row][column] != 2)
					{
						continue;
					}
					infect(row, column, 1);
				}
			}
		}
	}

	int dfs(int row, int column, int target, int col)
	{
		if (row < 0 || column < 0 || row == rows || column == columns || grid[row][column] == target)
		{
			return 0;
		}
		if (grid[row][column] < -1 || grid[row][column] == 0)
		{
			if (grid[row][column] == -col)
			{
				return 0;
			}
			grid[row][column] = -col;
			return 1;
		}
		if (grid[row][column] != 1)
		{
			return 0;
		}
		grid[row][column] = target;
		return dfs(row + 1, column, target, col) + dfs(row - 1, column, target, col) +
				dfs(row, column + 1, target, col) + dfs(row, column - 1, target, col);
	}

	int buildWalls(int row, int column, int target)
	{
		if (row < 0 || column < 0 || row == rows || column == columns)
		{
			return 0;
		}
		if (grid[row][column] == 0)
		{
			return 1;
		}
		if (grid[row][column] != 2)
		{
			return 0;
		}
		grid[row][column] = target;
		return buildWalls(row + 1, column, target) + buildWalls(row, column + 1, target)
				+ buildWalls(row - 1, column, target) + buildWalls(row, column - 1, target);
	}

	void infect(int row, int column, int target)
	{
		if (row < 0 || column < 0 || row == rows || column == columns || grid[row][column] == target)
		{
			return;
		}
		if (grid[row][column] == 0)
		{
			grid[row][column] = target;
			return;
		}
		if (grid[row][column] != 2)
		{
			return;
		}
		grid[row][column] = target;
		infect(row + 1, column, target);
		infect(row, column + 1, target);
		infect(row - 1, column, target);
		infect(row, column - 1, target);
	}
}

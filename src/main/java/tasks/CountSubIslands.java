package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 6/20/2021
 */
@LeetCode(
	id = 1905,
	name = "Count Sub Islands",
	url = "https://leetcode.com/problems/count-sub-islands/",
	difficulty = Difficulty.MEDIUM
)
public class CountSubIslands
{
	public int countSubIslands(int[][] grid1, int[][] grid2)
	{
		int count = 0;
		int rows = grid1.length;
		int columns = grid1[0].length;
		boolean[][] visited = new boolean[rows][columns];

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid1[row][column] == 1 && grid2[row][column] == 1)
				{
					LinkedList<int[]> land = new LinkedList<>();
					explore(row, column, rows, columns, grid2, visited, land);
					count += dfs(row, column, rows, columns, grid1, grid2) ? 1 : 0;

					while (!land.isEmpty())
					{
						grid2[land.peek()[0]][land.peek()[1]] = 0;
						land.pop();
					}
				}
			}
		}

		return count;
	}

	private boolean dfs(int row, int column, int rows, int columns, int[][] grid1, int[][] grid2)
	{
		if (row < 0 || row == rows || column < 0 || column == columns)
		{
			return true;
		}

		if (grid2[row][column] == 1 && grid1[row][column] == 0)
		{
			return false;
		}

		if (grid2[row][column] == 0)
		{
			return true;
		}

		grid2[row][column] = 0;

		return dfs(row - 1, column, rows, columns, grid1, grid2)
			&& dfs(row + 1, column, rows, columns, grid1, grid2)
			&& dfs(row, column - 1, rows, columns, grid1, grid2)
			&& dfs(row, column + 1, rows, columns, grid1, grid2);
	}

	private void explore(int row, int column, int rows, int columns, int[][] grid, boolean[][] visited, List<int[]> land)
	{
		if (row < 0 || row == rows || column < 0 || column == columns)
		{
			return;
		}

		if (grid[row][column] == 0 || visited[row][column])
		{
			return;
		}

		visited[row][column] = true;

		land.add(new int[]{row, column});

		explore(row - 1, column, rows, columns, grid, visited, land);
		explore(row + 1, column, rows, columns, grid, visited, land);
		explore(row, column - 1, rows, columns, grid, visited, land);
		explore(row, column + 1, rows, columns, grid, visited, land);
	}
}

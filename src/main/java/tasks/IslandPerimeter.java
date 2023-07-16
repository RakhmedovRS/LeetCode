package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@LeetCode(
		id = 463,
		name = "Island Perimeter",
		url = "https://leetcode.com/problems/island-perimeter/",
		difficulty = Difficulty.EASY
)
public class IslandPerimeter
{
	public int islandPerimeter(int[][] grid)
	{
		if (grid == null || grid.length == 0)
		{
			return 0;
		}

		int perimeter = 0;
		for (int row = 0; row < grid.length; row++)
		{
			for (int column = 0; column < grid[row].length; column++)
			{
				if (grid[row][column] == 1)
				{
					perimeter = islandPerimeter(grid, row, column);
				}
			}
		}

		return perimeter;
	}

	private int islandPerimeter(int[][] grid, int row, int column)
	{
		if (row < 0 || row == grid.length || column < 0 || column == grid[row].length || grid[row][column] == 0)
		{
			return 1;
		}

		if (grid[row][column] == -1)
		{
			return 0;
		}

		grid[row][column] = -1;

		return islandPerimeter(grid, row - 1, column)
				+ islandPerimeter(grid, row + 1, column)
				+ islandPerimeter(grid, row, column - 1)
				+ islandPerimeter(grid, row, column + 1);
	}

	public static void main(String[] args)
	{
		int[][] grid = new int[][]
				{
						{0, 1, 0, 0},
						{1, 1, 1, 0},
						{0, 1, 0, 0},
						{1, 1, 0, 0},
				};

		System.out.println(new IslandPerimeter().islandPerimeter(grid));
	}
}

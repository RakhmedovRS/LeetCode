package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/27/2022
 */
@LeetCode(
	id = 2319,
	name = "Check if Matrix Is X-Matrix",
	url = "https://leetcode.com/problems/check-if-matrix-is-x-matrix/",
	difficulty = Difficulty.EASY
)
public class CheckIfMatrixIsXMatrix
{
	public boolean checkXMatrix(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		boolean[][] x = new boolean[rows][columns];
		int row = 0;
		int column = 0;
		while (row < rows && column < columns)
		{
			x[row++][column++] = true;
		}

		row = 0;
		column = columns - 1;
		while (row < rows && column >= 0)
		{
			x[row++][column--] = true;
		}

		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < columns; c++)
			{
				if (x[r][c] && grid[r][c] == 0)
				{
					return false;
				}

				if (!x[r][c] && grid[r][c] != 0)
				{
					return false;
				}
			}
		}

		return true;
	}
}

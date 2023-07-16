package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/15/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2373,
		name = "Largest Local Values in a Matrix",
		url = "https://leetcode.com/problems/largest-local-values-in-a-matrix/",
		difficulty = Difficulty.EASY
)
public class LargestLocalValuesInMatrix
{
	public int[][] largestLocal(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;

		int r = 0;
		int c = 0;
		int[][] output = new int[rows - 2][columns - 2];

		for (int row = 1; row < rows - 1; row++)
		{
			for (int column = 1; column < columns - 1; column++)
			{
				int max = grid[row][column];
				max = Math.max(max, grid[row - 1][column]);
				max = Math.max(max, grid[row + 1][column]);
				max = Math.max(max, grid[row][column - 1]);
				max = Math.max(max, grid[row][column + 1]);
				max = Math.max(max, grid[row - 1][column - 1]);
				max = Math.max(max, grid[row - 1][column + 1]);
				max = Math.max(max, grid[row + 1][column - 1]);
				max = Math.max(max, grid[row + 1][column + 1]);

				output[r][c++] = max;
				if (c == output[r].length)
				{
					r++;
					c = 0;
				}
			}
		}

		return output;
	}
}

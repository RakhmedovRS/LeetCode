package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 6/18/2022
 */
@LeetCode(
		id = 2304,
		name = "Minimum Path Cost in a Grid",
		url = "https://leetcode.com/problems/minimum-path-cost-in-a-grid/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumPathCostInGrid
{
	public int minPathCost(int[][] grid, int[][] moveCost)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		int[][] memo = new int[rows][columns];
		for (int[] row : memo)
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		memo[0] = Arrays.copyOf(grid[0], columns);

		for (int row = 0; row < rows - 1; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				for (int c = 0; c < columns; c++)
				{
					memo[row + 1][c] = Math.min(memo[row + 1][c], memo[row][column] + moveCost[grid[row][column]][c] + grid[row + 1][c]);
				}
			}
		}

		int min = Integer.MAX_VALUE;

		for (int cost : memo[rows - 1])
		{
			min = Math.min(min, cost);
		}

		return min;
	}
}

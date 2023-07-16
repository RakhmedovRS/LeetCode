package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 5/13/2023
 */
@LeetCode(
		id = 2684,
		name = "Maximum Number of Moves in a Grid",
		url = "https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfMovesInGrid
{
	public int maxMoves(int[][] grid)
	{
		LinkedList<int[]> queue = new LinkedList<>();
		int rows = grid.length;
		int columns = grid[0].length;
		for (int r = 0; r < rows; r++)
		{
			queue.add(new int[]{r, 0, 0});
		}

		int[][] memo = new int[rows][columns];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}

		int globalMax = 0;
		while (!queue.isEmpty())
		{
			int[] c = queue.removeFirst();
			int row = c[0];
			int column = c[1];
			int max = c[2];

			globalMax = Math.max(globalMax, max);
			if (memo[row][column] >= max)
			{
				continue;
			}

			memo[row][column] = max;

			if (row - 1 >= 0 && column + 1 < columns && grid[row][column] < grid[row - 1][column + 1])
			{
				queue.add(new int[]{row - 1, column + 1, max + 1});
			}

			if (column + 1 < columns && grid[row][column] < grid[row][column + 1])
			{
				queue.add(new int[]{row, column + 1, max + 1});
			}

			if (row + 1 < rows && column + 1 < columns && grid[row][column] < grid[row + 1][column + 1])
			{
				queue.add(new int[]{row + 1, column + 1, max + 1});
			}
		}

		return globalMax;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 10/12/2022
 */
@LeetCode(
		id = 2435,
		name = "Paths in Matrix Whose Sum Is Divisible by K",
		url = "https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/",
		difficulty = Difficulty.HARD
)
public class PathsInMatrixWhoseSumIsDivisibleByK
{
	int MOD = 1_000_000_007;

	public int numberOfPaths(int[][] grid, int k)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		Map<Integer, Long>[][] memo = new HashMap[rows][columns];
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				memo[row][column] = new HashMap<>();
			}
		}

		memo[0][0].put(grid[0][0] % k, 1L);
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (row + 1 < rows)
				{
					for (Map.Entry<Integer, Long> entry : memo[row][column].entrySet())
					{
						int key = (entry.getKey() + grid[row + 1][column]) % k;
						memo[row + 1][column].put(key, (memo[row + 1][column].getOrDefault(key, 0L) + entry.getValue()) % MOD);
					}
				}

				if (column + 1 < columns)
				{
					for (Map.Entry<Integer, Long> entry : memo[row][column].entrySet())
					{
						int key = (entry.getKey() + grid[row][column + 1]) % k;
						memo[row][column + 1].put(key, (memo[row][column + 1].getOrDefault(key, 0L) + entry.getValue()) % MOD);
					}
				}
			}
		}

		return memo[rows - 1][columns - 1].getOrDefault(0, 0L).intValue();
	}
}

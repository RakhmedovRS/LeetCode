package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 12/14/2022
 */
@LeetCode(
		id = 2500,
		name = "Delete Greatest Value in Each Row",
		url = "https://leetcode.com/problems/delete-greatest-value-in-each-row/",
		difficulty = Difficulty.EASY
)
public class DeleteGreatestValueInEachRow
{
	public int deleteGreatestValue(int[][] grid)
	{
		int res = 0;
		for (int[] row : grid)
		{
			Arrays.sort(row);
		}

		for (int column = grid[0].length - 1; column >= 0; column--)
		{
			int max = 0;
			for (int row = 0; row < grid.length; row++)
			{
				max = Math.max(max, grid[row][column]);
			}

			res += max;
		}

		return res;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 6/20/2021
 */
@LeetCode(
	id = 778,
	name = "Swim in Rising Water",
	url = "https://leetcode.com/problems/swim-in-rising-water/",
	difficulty = Difficulty.HARD
)
public class SwimInRisingWater
{
	public int swimInWater(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		int[][] memo = new int[rows][columns];
		for (int[] row : memo)
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0, grid[0][0]});

		int[] current;
		int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		while (!queue.isEmpty())
		{
			current = queue.remove();
			int row = current[0];
			int column = current[1];
			current[2] = Math.max(current[2], grid[row][column]);
			if (memo[row][column] <= current[2])
			{
				continue;
			}

			memo[row][column] = current[2];

			for (int[] step : steps)
			{
				int nextRow = row + step[0];
				int nextColumn = column + step[1];
				if (nextRow < 0 || nextRow == rows || nextColumn < 0 || nextColumn == columns)
				{
					continue;
				}

				queue.add(new int[]{nextRow, nextColumn, current[2]});
			}
		}

		return memo[rows - 1][columns - 1];
	}
}

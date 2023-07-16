package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/19/2020
 */
@LeetCode(
		id = 1463,
		name = "Cherry Pickup II",
		url = "https://leetcode.com/problems/cherry-pickup-ii/",
		difficulty = Difficulty.HARD
)
public class CherryPickupII
{
	public int cherryPickup(int[][] grid)
	{
		int rows = grid.length;
		if (rows == 0)
		{
			return 0;
		}
		int columns = grid[0].length;
		Integer[][][] memo = new Integer[rows][columns][columns];
		return dfs(0, 0, columns - 1, rows, columns, grid, memo);
	}

	private int dfs(int robotsRow, int robot1Column, int robot2Column, int rows, int columns, int[][] grid, Integer[][][] memo)
	{
		if (robotsRow == rows)
		{
			return 0;
		}

		if (memo[robotsRow][robot1Column][robot2Column] != null)
		{
			return memo[robotsRow][robot1Column][robot2Column];
		}

		int sum = 0;
		int nextRobot1Column;
		int nextRobot2Column;
		for (int c1 = -1; c1 <= 1; c1++)
		{
			nextRobot1Column = robot1Column + c1;
			for (int c2 = -1; c2 <= 1; c2++)
			{
				nextRobot2Column = robot2Column + c2;
				if (nextRobot1Column >= 0 && nextRobot1Column < columns && nextRobot2Column >= 0 && nextRobot2Column < columns)
				{
					sum = Math.max(sum, dfs(robotsRow + 1, nextRobot1Column, nextRobot2Column, rows, columns, grid, memo));
				}
			}
		}

		int cherries = robot1Column == robot2Column ? grid[robotsRow][robot1Column] : grid[robotsRow][robot1Column] + grid[robotsRow][robot2Column];

		memo[robotsRow][robot1Column][robot2Column] = sum + cherries;

		return memo[robotsRow][robot1Column][robot2Column];
	}
}

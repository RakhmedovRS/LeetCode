package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/12/2021
 */
@LeetCode(
		id = 505,
		name = "The Maze II",
		url = "https://leetcode.com/problems/the-maze-ii/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class TheMazeII
{
	public int shortestDistance(int[][] maze, int[] start, int[] destination)
	{
		int rows = maze.length;
		if (rows == 0)
		{
			return -1;
		}
		int columns = maze[0].length;
		//0 - left, 1 - right, 2 - up, 3 - down
		Integer[][][] memo = new Integer[rows][columns][4];

		int distance = dfs(start[0], start[1], rows, columns, maze, memo, destination[0], destination[1], 0);
		return distance == Integer.MAX_VALUE ? -1 : distance;
	}

	private int dfs(int row, int column, int rows, int columns, int[][] maze, Integer[][][] memo, int targetRow, int targetColumn, int runDistance)
	{
		if (row == targetRow && column == targetColumn)
		{
			return runDistance;
		}

		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		int up = Integer.MAX_VALUE;
		int down = Integer.MAX_VALUE;

		int additionalDistance;

		//left
		if (memo[row][column][0] == null || memo[row][column][0] > runDistance)
		{
			memo[row][column][0] = runDistance;
			additionalDistance = 0;
			int c = column;
			while (c - 1 >= 0 && maze[row][c - 1] != 1)
			{
				c--;
				additionalDistance++;
			}

			left = dfs(row, c, rows, columns, maze, memo, targetRow, targetColumn, runDistance + additionalDistance);
		}

		//right
		if (memo[row][column][1] == null || memo[row][column][1] > runDistance)
		{
			memo[row][column][1] = runDistance;
			additionalDistance = 0;
			int c = column;
			while (c + 1 < columns && maze[row][c + 1] != 1)
			{
				c++;
				additionalDistance++;
			}

			right = dfs(row, c, rows, columns, maze, memo, targetRow, targetColumn, runDistance + additionalDistance);
		}

		//up
		if (memo[row][column][2] == null || memo[row][column][2] > runDistance)
		{
			memo[row][column][2] = runDistance;
			additionalDistance = 0;
			int r = row;
			while (r - 1 >= 0 && maze[r - 1][column] != 1)
			{
				r--;
				additionalDistance++;
			}

			up = dfs(r, column, rows, columns, maze, memo, targetRow, targetColumn, runDistance + additionalDistance);
		}

		//down
		if (memo[row][column][3] == null || memo[row][column][3] > runDistance)
		{
			memo[row][column][3] = runDistance;
			additionalDistance = 0;
			int r = row;
			while (r + 1 < rows && maze[r + 1][column] != 1)
			{
				r++;
				additionalDistance++;
			}

			down = dfs(r, column, rows, columns, maze, memo, targetRow, targetColumn, runDistance + additionalDistance);
		}

		return Math.min(left, Math.min(right, Math.min(up, down)));
	}
}

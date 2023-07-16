package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/12/2021
 */
@LeetCode(
		id = 499,
		name = "The Maze III",
		url = "https://leetcode.com/problems/the-maze-iii/",
		difficulty = Difficulty.HARD,
		premium = true
)
public class TheMazeIII
{
	public String findShortestWay(int[][] maze, int[] ball, int[] hole)
	{
		int rows = maze.length;
		if (rows == 0)
		{
			return "impossible";
		}
		int columns = maze[0].length;
		//0 - left, 1 - right, 2 - up, 3 - down
		Map.Entry<Integer, String>[][][] memo = new java.util.AbstractMap.SimpleEntry[rows][columns][4];
		Map.Entry<Integer, String>[] min = new java.util.AbstractMap.SimpleEntry[1];

		dfs(ball[0], ball[1], rows, columns, maze, memo, hole[0], hole[1], "", 0, min);
		return min[0] == null ? "impossible" : min[0].getValue();
	}

	private void dfs(int row, int column, int rows, int columns,
					 int[][] maze, Map.Entry<Integer, String>[][][] memo,
					 int targetRow, int targetColumn, String way, int steps,
					 Map.Entry<Integer, String>[] min)
	{
		String left;
		String right;
		String up;
		String down;

		int additionalSteps;
		boolean found;

		//left
		if (memo[row][column][0] == null
				|| memo[row][column][0].getKey() > steps
				|| (memo[row][column][0].getKey() == steps && memo[row][column][0].getValue().compareTo(way) > 0))
		{
			found = false;
			additionalSteps = 0;
			memo[row][column][0] = new java.util.AbstractMap.SimpleEntry<>(steps, way);
			int c = column;
			while (c - 1 >= 0 && maze[row][c - 1] != 1)
			{
				c--;
				additionalSteps++;
				if (row == targetRow && c == targetColumn)
				{
					found = true;
					left = way + "l";
					tryUpdateMin(left, steps + additionalSteps, min);
					break;
				}
			}

			if (!found && additionalSteps > 0)
			{
				dfs(row, c, rows, columns, maze, memo, targetRow, targetColumn, way + "l", steps + additionalSteps, min);
			}
		}

		//right
		if (memo[row][column][1] == null
				|| memo[row][column][1].getKey() > steps
				|| (memo[row][column][1].getKey() == steps && memo[row][column][1].getValue().compareTo(way) > 0))
		{
			found = false;
			additionalSteps = 0;
			memo[row][column][1] = new java.util.AbstractMap.SimpleEntry<>(steps, way);
			int c = column;
			while (c + 1 < columns && maze[row][c + 1] != 1)
			{
				c++;
				additionalSteps++;
				if (row == targetRow && c == targetColumn)
				{
					found = true;
					right = way + "r";
					tryUpdateMin(right, steps + additionalSteps, min);
					break;
				}
			}

			if (!found && additionalSteps > 0)
			{
				dfs(row, c, rows, columns, maze, memo, targetRow, targetColumn, way + "r", steps + additionalSteps, min);
			}
		}

		//up
		if (memo[row][column][2] == null
				|| memo[row][column][2].getKey() > steps
				|| (memo[row][column][2].getKey() == steps && memo[row][column][2].getValue().compareTo(way) > 0))
		{
			found = false;
			additionalSteps = 0;
			memo[row][column][2] = new java.util.AbstractMap.SimpleEntry<>(steps, way);
			int r = row;
			while (r - 1 >= 0 && maze[r - 1][column] != 1)
			{
				r--;
				additionalSteps++;
				if (r == targetRow && column == targetColumn)
				{
					found = true;
					up = way + "u";
					tryUpdateMin(up, steps + additionalSteps, min);
					break;
				}
			}

			if (!found && additionalSteps > 0)
			{
				dfs(r, column, rows, columns, maze, memo, targetRow, targetColumn, way + "u", steps + additionalSteps, min);
			}
		}

		//down
		if (memo[row][column][3] == null
				|| memo[row][column][3].getKey() > steps
				|| (memo[row][column][3].getKey() == steps && memo[row][column][3].getValue().compareTo(way) > 0))
		{
			found = false;
			additionalSteps = 0;
			memo[row][column][3] = new java.util.AbstractMap.SimpleEntry<>(steps, way);
			int r = row;
			while (r + 1 < rows && maze[r + 1][column] != 1)
			{
				r++;
				additionalSteps++;
				if (r == targetRow && column == targetColumn)
				{
					found = true;
					down = way + "d";
					tryUpdateMin(down, steps + additionalSteps, min);
					break;
				}
			}

			if (!found && additionalSteps > 0)
			{
				dfs(r, column, rows, columns, maze, memo, targetRow, targetColumn, way + "d", steps + additionalSteps, min);
			}
		}
	}

	private void tryUpdateMin(String currentWay, int steps, Map.Entry<Integer, String>[] min)
	{
		if (min[0] == null || min[0].getKey() > steps || (min[0].getKey() == steps && min[0].getValue().compareTo(currentWay) > 0))
		{
			min[0] = new java.util.AbstractMap.SimpleEntry<>(steps, currentWay);
		}
	}
}

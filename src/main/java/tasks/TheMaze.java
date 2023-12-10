package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/10/2020
 */
@LeetCode(
		id = 490,
		name = "The Maze",
		url = "https://leetcode.com/problems/the-maze/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class TheMaze {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		int rows = maze.length;
		int columns = maze[0].length;
		Boolean[][][] memo = new Boolean[rows][columns][4];
		return dfs(start[0], start[1], maze, destination, memo, new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}});
	}

	//0 - up, 1 - down, 2 - left, 3 - right
	private boolean dfs(int row, int column, int[][] maze, int[] destination, Boolean[][][] memo, int[][] directions) {
		if (row == destination[0] && column == destination[1]) {
			return true;
		}

		int x;
		int y;
		for (int i = 0; i < directions.length; i++) {
			if (memo[row][column][i] != null) {
				continue;
			}
			memo[row][column][i] = false;
			x = row;
			y = column;
			int xStep = directions[i][0];
			int yStep = directions[i][1];
			while (x + xStep >= 0 && x + xStep < maze.length
					&& y + yStep >= 0 && y + yStep < maze[x].length
					&& maze[x + xStep][y + yStep] == 0) {
				x += xStep;
				y += yStep;
			}

			memo[row][column][i] = dfs(x, y, maze, destination, memo, directions);
			if (memo[row][column][i]) {
				return true;
			}
		}

		return false;
	}
}

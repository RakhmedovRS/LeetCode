package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 7/10/2021
 */
@LeetCode(
	id = 1926,
	name = "Nearest Exit from Entrance in Maze",
	url = "https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/",
	difficulty = Difficulty.MEDIUM
)
public class NearestExitFromEntranceInMaze
{
	public int nearestExit(char[][] maze, int[] entrance)
	{
		int rows = maze.length;
		int columns = maze[0].length;
		boolean[][] visited = new boolean[rows][columns];
		Queue<int[]> queue = new LinkedList<>();
		int size;
		int[] current;
		int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int rounds = 0;

		queue.add(new int[]{entrance[0], entrance[1]});
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				int row = current[0];
				int column = current[1];
				if (visited[row][column])
				{
					continue;
				}

				visited[row][column] = true;
				if (row == 0 || row == rows - 1 || column == 0 || column == columns - 1)
				{
					if (row != entrance[0] || column != entrance[1])
					{
						return rounds;
					}
				}

				for (int[] step : steps)
				{
					int nextRow = row + step[0];
					int nextColumn = column + step[1];
					if (nextRow < 0 || nextRow == rows || nextColumn < 0 || nextColumn == columns || visited[nextRow][nextColumn] || maze[nextRow][nextColumn] == '+')
					{
						continue;
					}
					queue.add(new int[]{nextRow, nextColumn});
				}
			}
			rounds++;
		}

		return -1;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 3/19/2021
 */
@LeetCode(
		id = 1778,
		name = "Shortest Path in a Hidden Grid",
		url = "https://leetcode.com/problems/shortest-path-in-a-hidden-grid/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ShortestPathInHiddenGrid
{
	interface GridMaster
	{
		boolean canMove(char direction);

		void move(char direction);

		boolean isTarget();
	}

	public int findShortestPath(GridMaster master)
	{
		Boolean[][] grid = new Boolean[1002][1002];
		Integer[] targetPos = new Integer[2];
		dfs(grid, 500, 500, master, targetPos);
		if (targetPos[0] == null)
		{
			return -1;
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{500, 500});

		int size;
		int steps = 0;
		int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		int row;
		int column;
		int nextRow;
		int nextColumn;
		boolean[][] visited = new boolean[1002][1002];
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				row = queue.peek()[0];
				column = queue.remove()[1];

				if (grid[row][column])
				{
					return steps;
				}

				if (visited[row][column])
				{
					continue;
				}

				visited[row][column] = true;

				for (int[] direction : directions)
				{
					nextRow = row + direction[0];
					nextColumn = column + direction[1];

					if (grid[nextRow][nextColumn] != null)
					{
						queue.add(new int[]{nextRow, nextColumn});
					}
				}
			}

			steps++;
		}

		return -1;
	}

	private void dfs(Boolean[][] grid, int row, int column, GridMaster master, Integer[] targetPos)
	{
		if (master.isTarget())
		{
			targetPos[0] = row;
			targetPos[1] = column;
			grid[row][column] = true;
			return;
		}

		if (grid[row][column] != null)
		{
			return;
		}

		grid[row][column] = false;

		if (master.canMove('D'))
		{
			master.move('D');
			dfs(grid, row + 1, column, master, targetPos);
			master.move('U');
		}

		if (master.canMove('U'))
		{
			master.move('U');
			dfs(grid, row - 1, column, master, targetPos);
			master.move('D');
		}

		if (master.canMove('L'))
		{
			master.move('L');
			dfs(grid, row, column - 1, master, targetPos);
			master.move('R');
		}

		if (master.canMove('R'))
		{
			master.move('R');
			dfs(grid, row, column + 1, master, targetPos);
			master.move('L');
		}
	}
}

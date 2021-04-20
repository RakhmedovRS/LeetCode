package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 4/7/2021
 */
@LeetCode(
	id = 1810,
	name = "Minimum Path Cost in a Hidden Grid",
	url = "https://leetcode.com/problems/minimum-path-cost-in-a-hidden-grid/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class MinimumPathCostInHiddenGrid
{
	interface GridMaster
	{
		boolean canMove(char direction);

		int move(char direction);

		boolean isTarget();
	}

	public int findShortestPath(GridMaster master)
	{
		Integer[][] memo = new Integer[202][202];
		boolean[][] visited = new boolean[202][202];
		Integer[] target = new Integer[2];
		dfs(100, 100, memo, visited, master, target);

		if (target[0] == null)
		{
			return -1;
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{100, 100, 0});

		int[] current;
		int row;
		int column;
		int cost;

		Integer[][] result = new Integer[202][202];
		while (!queue.isEmpty())
		{
			current = queue.remove();
			row = current[0];
			column = current[1];
			cost = current[2];

			if (result[row][column] != null && cost >= result[row][column])
			{
				continue;
			}

			result[row][column] = cost;

			if (row == target[0] && column == target[1])
			{
				continue;
			}

			if (memo[row - 1][column] != null)
			{
				queue.add(new int[]{row - 1, column, cost + memo[row - 1][column]});
			}

			if (memo[row + 1][column] != null)
			{
				queue.add(new int[]{row + 1, column, cost + memo[row + 1][column]});
			}

			if (memo[row][column - 1] != null)
			{
				queue.add(new int[]{row, column - 1, cost + memo[row][column - 1]});
			}

			if (memo[row][column + 1] != null)
			{
				queue.add(new int[]{row, column + 1, cost + memo[row][column + 1]});
			}
		}

		return result[target[0]][target[1]];
	}

	private void dfs(int row, int column, Integer[][] memo, boolean[][] visited, GridMaster master, Integer[] target)
	{
		if (master.isTarget())
		{
			target[0] = row;
			target[1] = column;
			return;
		}

		if (visited[row][column])
		{
			return;
		}

		visited[row][column] = true;

		if (master.canMove('U'))
		{
			memo[row - 1][column] = master.move('U');
			dfs(row - 1, column, memo, visited, master, target);
			master.move('D');
		}

		if (master.canMove('D'))
		{
			memo[row + 1][column] = master.move('D');
			dfs(row + 1, column, memo, visited, master, target);
			master.move('U');
		}

		if (master.canMove('L'))
		{
			memo[row][column - 1] = master.move('L');
			dfs(row, column - 1, memo, visited, master, target);
			master.move('R');
		}

		if (master.canMove('R'))
		{
			memo[row][column + 1] = master.move('R');
			dfs(row, column + 1, memo, visited, master, target);
			master.move('L');
		}
	}
}

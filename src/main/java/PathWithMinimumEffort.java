import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 10/25/2020
 */
@LeetCode(id = 1631, name = "Path With Minimum Effort", url = "https://leetcode.com/problems/path-with-minimum-effort/")
public class PathWithMinimumEffort
{
	public int minimumEffortPath(int[][] heights)
	{
		int rows = heights.length;
		int columns = heights[0].length;
		int[][] memo = new int[rows][columns];
		for (int[] row : memo)
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0, heights[0][0], 0});
		int[] current;
		int row;
		int column;
		int prev;
		int max;
		while (!queue.isEmpty())
		{
			current = queue.remove();
			row = current[0];
			column = current[1];
			prev = current[2];
			max = current[3];
			max = Math.max(max, Math.abs(prev - heights[row][column]));

			if (max >= memo[row][column])
			{
				continue;
			}

			memo[row][column] = max;

			if (row - 1 >= 0)
			{
				queue.add(new int[]{row - 1, column, heights[row][column], max});
			}

			if (row + 1 < rows)
			{
				queue.add(new int[]{row + 1, column, heights[row][column], max});
			}

			if (column - 1 >= 0)
			{
				queue.add(new int[]{row, column - 1, heights[row][column], max});
			}

			if (column + 1 < columns)
			{
				queue.add(new int[]{row, column + 1, heights[row][column], max});
			}
		}

		return memo[rows - 1][columns - 1];
	}
}

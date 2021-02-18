import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 10/25/2020
 */
@LeetCode(
		id = 1631,
		name = "Path With Minimum Effort",
		url = "https://leetcode.com/problems/path-with-minimum-effort/",
		difficulty = Difficulty.MEDIUM
)
public class PathWithMinimumEffort
{
	public int minimumEffortPath(int[][] heights)
	{
		int rows = heights.length;
		int columns = heights[0].length;

		Integer[][] matrix = new Integer[rows][columns];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0, 0});

		int[] current;
		int row;
		int column;
		int diff;
		int[][] ways = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		int nextRow;
		int nextColumn;
		while (!queue.isEmpty())
		{
			current = queue.remove();
			row = current[0];
			column = current[1];
			diff = current[2];
			if (matrix[row][column] != null && diff >= matrix[row][column])
			{
				continue;
			}

			matrix[row][column] = diff;

			for (int[] way : ways)
			{
				nextRow = row + way[0];
				nextColumn = column + way[1];
				if (nextRow < 0 || nextRow == rows || nextColumn < 0 || nextColumn == columns)
				{
					continue;
				}

				queue.add(new int[]{nextRow, nextColumn,
						Math.max(diff, Math.abs(heights[row][column] - heights[nextRow][nextColumn]))});
			}
		}

		return matrix[rows - 1][columns - 1];
	}
}

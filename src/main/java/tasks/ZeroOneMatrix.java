package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 21-May-20
 */
@LeetCode(
	id = 542,
	name = "01 Matrix",
	url = "https://leetcode.com/problems/01-matrix/",
	difficulty = Difficulty.MEDIUM
)
public class ZeroOneMatrix
{
	public int[][] updateMatrix(int[][] mat)
	{
		int rows = mat.length;
		int columns = mat[0].length;

		int[][] answer = new int[rows][columns];
		for (int[] row : answer)
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		Queue<int[]> queue = new LinkedList<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (mat[row][column] == 0)
				{
					queue.add(new int[]{row, column, 0});
				}
			}
		}

		int[] current;
		int[][] steps = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		while (!queue.isEmpty())
		{
			current = queue.remove();
			int row = current[0];
			int column = current[1];
			int distance = current[2];

			if (answer[row][column] <= distance)
			{
				continue;
			}

			answer[row][column] = distance;
			for (int[] step : steps)
			{
				int nextRow = step[0] + row;
				int nextColumn = step[1] + column;
				if (nextRow >= 0 && nextRow < rows && nextColumn >= 0 && nextColumn < columns)
				{
					queue.add(new int[]{nextRow, nextColumn, distance + 1});
				}
			}
		}

		return answer;
	}
}

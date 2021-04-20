package tasks;

import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 29-Jun-20
 */
@LeetCode(id = 1030, name = "Matrix Cells in Distance Order", url = "https://leetcode.com/problems/matrix-cells-in-distance-order/")
public class MatrixCellsInDistanceOrder
{
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0)
	{
		int[][] answer = new int[R * C][];
		boolean[][] visited = new boolean[R][C];
		int pos = 0;
		Queue<int[]> positions = new LinkedList<>();
		int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
		positions.add(new int[]{r0, c0});
		while (!positions.isEmpty())
		{
			int[] position = positions.poll();

			if (visited[position[0]][position[1]])
			{
				continue;
			}

			visited[position[0]][position[1]] = true;
			answer[pos++] = position;
			for (int[] direction : directions)
			{
				int row = position[0] + direction[0];
				int column = position[1] + direction[1];
				if (correctPosition(row, column, R, C) && !visited[row][column])
				{
					positions.add(new int[]{row, column});
				}
			}
		}

		return answer;
	}

	private boolean correctPosition(int row, int column, int rows, int columns)
	{
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
}

import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
@LeetCode(id = 1091, name = "Shortest Path in Binary Matrix", url = "https://leetcode.com/problems/shortest-path-in-binary-matrix/")
public class ShortestPathInBinaryMatrix
{
	private int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

	public int shortestPathBinaryMatrix(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		if (grid[0][0] == 1 || grid[rows - 1][columns - 1] == 1)
		{
			return -1;
		}

		boolean[][] visited = new boolean[rows][columns];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});
		int steps = 0;
		while (!queue.isEmpty())
		{
			int size = queue.size();
			while (size-- > 0)
			{
				int[] vertex = queue.poll();
				if (vertex[0] == rows - 1 && vertex[1] == columns - 1)
				{
					return steps + 1;
				}

				for (int[] direction : directions)
				{
					int x = vertex[0] + direction[0];
					int y = vertex[1] + direction[1];

					if (x >= 0 && x < rows && y >= 0 && y < columns && !visited[x][y] && grid[x][y] == 0)
					{
						visited[x][y] = true;
						queue.add(new int[]{x, y});
					}
				}
			}
			steps++;
		}

		return -1;
	}
}

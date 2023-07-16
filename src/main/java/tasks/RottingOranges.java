package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 21-Jul-20
 */
@LeetCode(
		id = 994,
		name = "Rotting Oranges",
		url = "https://leetcode.com/problems/rotting-oranges/",
		difficulty = Difficulty.MEDIUM
)
public class RottingOranges
{
	public int orangesRotting(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;

		int goodOranges = 0;
		Queue<int[]> rotted = new LinkedList<>();
		boolean[][] visited = new boolean[rows][columns];
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 2)
				{
					rotted.add(new int[]{row, column});
				}
				else if (grid[row][column] == 1)
				{
					goodOranges++;
				}
			}
		}

		if (goodOranges == 0)
		{
			return 0;
		}

		int minutes = 0;
		int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
		while (!rotted.isEmpty())
		{
			int size = rotted.size();
			while (size-- > 0)
			{
				int[] pos = rotted.remove();
				if (visited[pos[0]][pos[1]])
				{
					continue;
				}
				visited[pos[0]][pos[1]] = true;
				for (int[] direction : directions)
				{
					int x = pos[0] + direction[0];
					int y = pos[1] + direction[1];
					if (x < 0 || x == rows || y < 0 || y == columns)
					{
						continue;
					}
					if (grid[x][y] == 1)
					{
						grid[x][y] = 2;
						goodOranges--;
						rotted.add(new int[]{x, y});
						if (goodOranges == 0)
						{
							return minutes + 1;
						}
					}
				}
			}
			minutes++;
		}

		return -1;
	}
}

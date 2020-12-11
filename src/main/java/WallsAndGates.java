import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 12/11/2020
 */
@LeetCode(
	id = 286,
	name = "Walls and Gates",
	url = "https://leetcode.com/problems/walls-and-gates/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class WallsAndGates
{
	public void wallsAndGates(int[][] rooms)
	{
		int rows = rooms.length;
		if (rows == 0)
		{
			return;
		}
		int columns = rooms[0].length;
		Queue<int[]> queue = new LinkedList<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (rooms[row][column] == 0)
				{
					queue.add(new int[]{row, column, 0});
				}
			}
		}

		int[] current;
		int size;
		int x;
		int y;
		int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				for (int[] direction : directions)
				{
					x = current[0] + direction[0];
					y = current[1] + direction[1];
					if (x < 0 || x == rows || y < 0 || y == columns || rooms[x][y] == -1 || rooms[x][y] <= current[2] + 1)
					{
						continue;
					}

					rooms[x][y] = current[2] + 1;
					queue.add(new int[]{x, y, current[2] + 1});
				}
			}
		}
	}
}

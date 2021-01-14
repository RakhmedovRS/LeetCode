import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/14/2021
 */
@LeetCode(
	id = 361,
	name = "Bomb Enemy",
	url = "https://leetcode.com/problems/bomb-enemy/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class BombEnemy
{
	public int maxKilledEnemies(char[][] grid)
	{
		int rows = grid.length;
		if (rows == 0)
		{
			return 0;
		}
		int columns = grid[0].length;

		int[][] left = new int[rows][columns];
		int[][] right = new int[rows][columns];
		int[][] up = new int[rows][columns];
		int[][] down = new int[rows][columns];

		for (int row = 0; row < rows; row++)
		{
			int count = 0;
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 'W')
				{
					count = 0;
				}
				else if (grid[row][column] == 'E')
				{
					count++;
				}

				left[row][column] = count;
			}

			count = 0;
			for (int column = columns - 1; column >= 0; column--)
			{
				if (grid[row][column] == 'W')
				{
					count = 0;
				}
				else if (grid[row][column] == 'E')
				{
					count++;
				}

				right[row][column] = count;
			}
		}

		for (int column = 0; column < columns; column++)
		{
			int count = 0;
			for (int row = 0; row < rows; row++)
			{
				if (grid[row][column] == 'W')
				{
					count = 0;
				}
				else if (grid[row][column] == 'E')
				{
					count++;
				}

				up[row][column] = count;
			}

			count = 0;
			for (int row = rows - 1; row >= 0; row--)
			{
				if (grid[row][column] == 'W')
				{
					count = 0;
				}
				else if (grid[row][column] == 'E')
				{
					count++;
				}

				down[row][column] = count;
			}
		}

		int max = 0;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == '0')
				{
					max = Math.max(max, left[row][column]
						+ right[row][column]
						+ up[row][column]
						+ down[row][column]
					);
				}
			}
		}

		return max;
	}
}

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@LeetCode(id = 840, name = "Magic Squares In Grid", url = "https://leetcode.com/problems/magic-squares-in-grid/")
public class MagicSquaresInGrid
{
	private int[][] directions = new int[][]{{-1, -1}, {0, -1}, {-1, 0}, {0, 0}, {1, 0}, {0, 1}, {-1, 1}, {1, -1}, {1, 1}};

	public int numMagicSquaresInside(int[][] grid)
	{
		int answer = 0;

		Set<Integer> set = new HashSet<>();
		for (int row = 1; row < grid.length - 1; row++)
		{
			set.clear();
			for (int column = 1; column < grid[row].length - 1; column++)
			{
				boolean valid = grid[row][column] == 5;
				if (valid)
				{
					for (int[] direction : directions)
					{
						if (grid[row + direction[0]][column + direction[1]] <= 0
							|| grid[row + direction[0]][column + direction[1]] > 10
							|| !set.add(grid[row + direction[0]][column + direction[1]]))
						{
							valid = false;
							break;
						}
					}
				}

				if (!valid)
				{
					set.clear();
					continue;
				}

				int r1 = grid[row - 1][column - 1] + grid[row - 1][column] + grid[row - 1][column + 1];
				int r2 = grid[row][column - 1] + grid[row][column] + grid[row][column + 1];
				int r3 = grid[row + 1][column - 1] + grid[row + 1][column] + grid[row + 1][column + 1];
				int ld = grid[row - 1][column - 1] + grid[row][column] + grid[row + 1][column + 1];
				int rd = grid[row - 1][column + 1] + grid[row][column] + grid[row + 1][column - 1];
				int c1 = grid[row - 1][column - 1] + grid[row][column - 1] + grid[row + 1][column - 1];
				int c2 = grid[row - 1][column] + grid[row][column] + grid[row + 1][column];
				int c3 = grid[row - 1][column + 1] + grid[row][column + 1] + grid[row + 1][column + 1];

				valid = (r1 == r2 && r2 == r3 && c1 == c2 && c2 == c3 && c3 == ld && ld == rd);

				answer += valid ? 1 : 0;
			}
		}
		return answer;
	}

	public static void main(String[] args)
	{
		int[][] matrix = new int[][]{{4, 7, 8}, {9, 5, 1}, {2, 3, 6}};
		System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(matrix));

		matrix = new int[][]{{10, 3, 5}, {1, 6, 11}, {7, 9, 2}};
		System.out.println(new MagicSquaresInGrid().numMagicSquaresInside(matrix));
	}
}

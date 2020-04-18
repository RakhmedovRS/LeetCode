import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18-Feb-20
 */
@LeetCode(id = 64, name = "Minimum Path Sum", url = "https://leetcode.com/problems/minimum-path-sum/")
public class MinimumPathSum
{
	public int minPathSum(int[][] grid)
	{
		if (grid == null || grid.length == 0)
		{
			return 0;
		}

		int rows = grid.length;
		int columns = grid[0].length;

		for (int column = 1; column < columns; column++)
		{
			grid[0][column] += grid[0][column - 1];
		}

		for (int row = 1; row < rows; row++)
		{
			grid[row][0] += grid[row - 1][0];
		}

		for (int row = 1; row < rows; row++)
		{
			for (int column = 1; column < columns; column++)
			{
				grid[row][column] += Math.min(grid[row - 1][column], grid[row][column - 1]);
			}
		}

		return grid[rows - 1][columns - 1];
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumPathSum().minPathSum(new int[][]
			{
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
			}));
	}
}

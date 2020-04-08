import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Apr-20
 */
@LeetCode(id = 62, name = "Unique Paths", url = "https://leetcode.com/problems/unique-paths/")
public class UniquePaths
{
	public int uniquePaths(int m, int n)
	{
		int[][] grid = new int[n][m];
		for (int row = 0; row < n; row++)
		{
			for (int column = 0; column < m; column++)
			{
				if (row == 0)
				{
					grid[row][column] = 1;
				}
				else if (column == 0)
				{
					grid[row][column] = 1;
				}
				else
				{
					grid[row][column] = grid[row - 1][column] + grid[row][column - 1];
				}
			}
		}

		return grid[n - 1][m - 1];
	}
}

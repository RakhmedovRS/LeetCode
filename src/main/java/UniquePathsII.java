import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
@LeetCode(id = 63, name = "Unique Paths II", url = "https://leetcode.com/problems/unique-paths-ii/")
public class UniquePathsII
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		if (obstacleGrid[0][0] == 1)
		{
			return 0;
		}

		int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
		grid[0][0] = 1;
		for (int column = 1; column < obstacleGrid[0].length; column++)
		{
			grid[0][column] = obstacleGrid[0][column] == 1 ? 0 : grid[0][column - 1];
		}

		for (int row = 1; row < obstacleGrid.length; row++)
		{
			grid[row][0] = obstacleGrid[row][0] == 1 ? 0 : grid[row - 1][0];
		}

		for (int row = 1; row < obstacleGrid.length; row++)
		{
			for (int column = 1; column < obstacleGrid[0].length; column++)
			{
				grid[row][column] = obstacleGrid[row][column] == 1 ? 0 : grid[row - 1][column] + grid[row][column - 1];
			}
		}

		return grid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	public static void main(String[] args)
	{
		System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
			{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}}));
	}
}

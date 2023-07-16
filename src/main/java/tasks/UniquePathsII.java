package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
@LeetCode(
		id = 63,
		name = "Unique Paths II",
		url = "https://leetcode.com/problems/unique-paths-ii/",
		difficulty = Difficulty.MEDIUM
)
public class UniquePathsII
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		int rows = obstacleGrid.length;
		if (rows == 0)
		{
			return 0;
		}
		int columns = obstacleGrid[0].length;

		if (obstacleGrid[rows - 1][columns - 1] == 1 || obstacleGrid[0][0] == 1)
		{
			return 0;
		}

		int[][] memo = new int[rows][columns];
		for (int i = 0; i < columns; i++)
		{
			if (obstacleGrid[0][i] == 1)
			{
				break;
			}
			memo[0][i] = 1;
		}

		for (int i = 0; i < rows; i++)
		{
			if (obstacleGrid[i][0] == 1)
			{
				break;
			}

			memo[i][0] = 1;
		}

		for (int row = 1; row < rows; row++)
		{
			for (int column = 1; column < columns; column++)
			{
				if (obstacleGrid[row][column] != 1)
				{
					memo[row][column] += memo[row - 1][column] + memo[row][column - 1];
				}
			}
		}

		return memo[rows - 1][columns - 1];
	}

	public static void main(String[] args)
	{
		System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}}));
	}
}

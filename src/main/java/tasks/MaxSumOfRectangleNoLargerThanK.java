package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/3/2021
 */
@LeetCode(
		id = 363,
		name = "Max Sum of Rectangle No Larger Than K",
		url = "https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/",
		difficulty = Difficulty.HARD
)
public class MaxSumOfRectangleNoLargerThanK
{
	public int maxSumSubmatrix(int[][] matrix, int k)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int maxSum = Integer.MIN_VALUE;

		int[][] memo = new int[rows + 1][columns + 1];

		for (int row = 1; row <= rows; row++)
		{
			for (int column = 1; column <= columns; column++)
			{
				memo[row][column] = memo[row - 1][column] + memo[row][column - 1] - memo[row - 1][column - 1] + matrix[row - 1][column - 1];
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				for (int r = row; r < rows; r++)
				{
					for (int c = column; c < columns; c++)
					{
						int sum = memo[r + 1][c + 1] - memo[r + 1][column] - memo[row][c + 1] + memo[row][column];
						if (sum <= k)
						{
							maxSum = Math.max(maxSum, sum);
						}
					}
				}
			}
		}
		return maxSum;
	}
}

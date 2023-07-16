package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/22/2021
 */
@LeetCode(
		id = 1975,
		name = "Maximum Matrix Sum",
		url = "https://leetcode.com/problems/maximum-matrix-sum/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumMatrixSum
{
	public long maxMatrixSum(int[][] matrix)
	{
		long sum = 0;
		int negativeCount = 0;
		boolean seenZero = false;
		int min = Integer.MAX_VALUE;
		for (int row = 0; row < matrix.length; row++)
		{
			for (int column = 0; column < matrix[row].length; column++)
			{
				sum += Math.abs(matrix[row][column]);
				if (matrix[row][column] < 0)
				{
					negativeCount++;
				}

				if (matrix[row][column] == 0)
				{
					seenZero = true;
				}

				min = Math.min(min, Math.abs(matrix[row][column]));
			}
		}

		if (seenZero)
		{
			return sum;
		}

		if (negativeCount % 2 != 0)
		{
			sum -= min * 2L;
		}

		return sum;
	}
}

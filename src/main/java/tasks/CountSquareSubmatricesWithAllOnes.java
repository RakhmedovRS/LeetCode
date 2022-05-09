package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-May-20
 */
@LeetCode(
	id = 1277,
	name = "Count Square Submatrices with All Ones",
	url = "https://leetcode.com/problems/count-square-submatrices-with-all-ones/",
	difficulty = Difficulty.MEDIUM
)
public class CountSquareSubmatricesWithAllOnes
{
	public int countSquares(int[][] matrix)
	{
		int result = 0;
		for (int row = 0; row < matrix.length; row++)
		{
			for (int column = 0; column < matrix[row].length; column++)
			{
				result += matrix[row][column];
			}
		}

		for (int row = 1; row < matrix.length; row++)
		{
			for (int column = 1; column < matrix[row].length; column++)
			{
				if (matrix[row][column] == 0)
				{
					continue;
				}

				matrix[row][column] += Math.min(matrix[row - 1][column - 1],
					Math.min(matrix[row - 1][column], matrix[row][column - 1]));
				if (matrix[row][column] > 1)
				{
					result += matrix[row][column] - 1;
				}
			}
		}

		return result;
	}
}

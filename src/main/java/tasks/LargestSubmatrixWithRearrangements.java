package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/17/2021
 */
@LeetCode(
	id = 1727,
	name = "Largest Submatrix With Rearrangements",
	url = "https://leetcode.com/problems/largest-submatrix-with-rearrangements/",
	difficulty = Difficulty.MEDIUM
)
public class LargestSubmatrixWithRearrangements
{
	public int largestSubmatrix(int[][] matrix)
	{
		int rows = matrix.length;
		if (rows == 0)
		{
			return 0;
		}
		int columns = matrix[0].length;

		int largest = 0;
		for (int column = 0; column < columns; column++)
		{
			for (int row = 1; row < rows; row++)
			{
				if (matrix[row][column] == 1)
				{
					matrix[row][column] += matrix[row - 1][column];
				}
			}
		}

		for (int[] row : matrix)
		{
			Arrays.sort(row);
			for (int column = 1; column <= columns; column++)
			{
				largest = Math.max(largest, column * row[columns - column]);
			}
		}

		return largest;
	}
}

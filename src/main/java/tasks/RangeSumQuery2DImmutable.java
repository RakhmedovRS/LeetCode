package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/16/2020
 */
@LeetCode(
	id = 304,
	name = "Range Sum Query 2D - Immutable",
	url = "https://leetcode.com/problems/range-sum-query-2d-immutable/",
	difficulty = Difficulty.MEDIUM
)
public class RangeSumQuery2DImmutable
{
	class NumMatrix
	{

		int[][] matrix;

		public NumMatrix(int[][] matrix)
		{
			this.matrix = matrix;
			for (int[] row : matrix)
			{
				for (int i = 1; i < row.length; i++)
				{
					row[i] += row[i - 1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2)
		{
			int sum = 0;
			while (row1 <= row2)
			{
				sum += matrix[row1][col2] - (col1 == 0 ? 0 : matrix[row1][col1 - 1]);

				row1++;
			}

			return sum;
		}
	}
}

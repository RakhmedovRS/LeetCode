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
			int rows = matrix.length;
			int columns = rows == 0 ? 0 : matrix[0].length;
			this.matrix = matrix;
			for (int row = 0; row < rows; row++)
			{
				for (int column = 1; column < columns; column++)
				{
					matrix[row][column] += matrix[row][column - 1];
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

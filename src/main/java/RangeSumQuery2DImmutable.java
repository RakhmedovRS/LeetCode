import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/16/2020
 */
@LeetCode(id = 304, name = "Range Sum Query 2D - Immutable", url = "https://leetcode.com/problems/range-sum-query-2d-immutable/")
public class RangeSumQuery2DImmutable
{
	class NumMatrix
	{
		int[][] matrix;

		public NumMatrix(int[][] matrix)
		{
			if (matrix.length == 0)
			{
				return;
			}

			this.matrix = matrix;
			int rows = matrix.length;
			int columns = matrix[0].length;
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
			if (matrix == null)
			{
				return 0;
			}

			int sum = 0;
			for (int i = row1; i <= row2; i++)
			{
				sum += matrix[i][col2] - (col1 - 1 >= 0 ? matrix[i][col1 - 1] : 0);
			}

			return sum;
		}
	}
}

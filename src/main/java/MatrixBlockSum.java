import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-May-20
 */
@LeetCode(id = 1314, name = "Matrix Block Sum", url = "https://leetcode.com/problems/matrix-block-sum/")
public class MatrixBlockSum
{
	public int[][] matrixBlockSum(int[][] matrix, int K)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] sum = new int[rows + 1][columns + 1];
		for (int row = 1; row <= rows; row++)
		{
			for (int column = 1; column <= columns; column++)
			{
				sum[row][column] = matrix[row - 1][column - 1]
					+ sum[row - 1][column]
					+ sum[row][column - 1]
					- sum[row - 1][column - 1];
			}
		}

		int[][] answer = new int[rows][columns];
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				int row1 = Math.max(0, row - K);
				int column1 = Math.max(0, column - K);
				int row2 = Math.min(rows - 1, row + K);
				int column2 = Math.min(columns - 1, column + K);
				row1++;
				column1++;
				row2++;
				column2++;
				answer[row][column] = sum[row2][column2]
					- sum[row2][column1 - 1]
					- sum[row1 - 1][column2]
					+ sum[row1 - 1][column1 - 1];
			}
		}
		return answer;
	}
}

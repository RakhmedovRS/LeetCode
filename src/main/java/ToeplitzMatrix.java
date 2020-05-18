import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18-May-20
 */
@LeetCode(id = 766, name = "Toeplitz Matrix", url = "https://leetcode.com/problems/toeplitz-matrix/")
public class ToeplitzMatrix
{
	public boolean isToeplitzMatrix(int[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;

		for (int row = 0; row < rows; row++)
		{
			int r = row;
			int c = 0;
			int value = matrix[r][c];
			while (r < rows && c < columns)
			{
				if (matrix[r++][c++] != value)
				{
					return false;
				}
			}
		}

		for (int column = 1; column < columns; column++)
		{
			int r = 0;
			int c = column;
			int value = matrix[r][c];
			while (r < rows && c < columns)
			{
				if (matrix[r++][c++] != value)
				{
					return false;
				}
			}
		}

		return true;
	}
}

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-Apr-20
 */
@LeetCode(id = 221, name = "Maximal Square", url = "https://leetcode.com/problems/maximal-square/")
public class MaximalSquare
{
	public int maximalSquare(char[][] matrix)
	{
		int result = 0;
		if (matrix == null || matrix.length == 0)
		{
			return result;
		}

		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] memo = new int[rows][columns];
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				memo[row][column] = matrix[row][column] - '0';
			}
		}

		for (int row = 1; row < rows; row++)
		{
			for (int column = 1; column < columns; column++)
			{
				if (memo[row][column] > 0)
				{
					memo[row][column] += Math.min(memo[row - 1][column - 1],
						Math.min(memo[row - 1][column], memo[row][column - 1]));
				}
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (memo[row][column] > result)
				{
					result = memo[row][column];
				}
			}
		}

		return result * result;
	}
}

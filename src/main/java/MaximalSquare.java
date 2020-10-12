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
		if (matrix.length == 0 || matrix[0].length == 0)
		{
			return 0;
		}

		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] memo = new int[rows][columns];
		int max = 0;
		for (int row = rows - 1; row >= 0; row--)
		{
			for (int column = columns - 1; column >= 0; column--)
			{
				if (matrix[row][column] == '1')
				{
					memo[row][column]++;
					if (row <= rows - 2 && column <= columns - 2)
					{
						memo[row][column] += Math.min(memo[row + 1][column + 1], Math.min(memo[row + 1][column], memo[row][column + 1]));
					}

					max = Math.max(max, memo[row][column]);
				}
			}
		}

		return (int) Math.pow(max, 2);
	}
}

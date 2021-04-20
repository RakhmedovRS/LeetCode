package tasks;

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
		int rows = matrix.length;
		if(rows == 0)
		{
			return 0;
		}
		int columns = matrix[0].length;

		int max = 0;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (matrix[row][column] == '1')
				{
					if (row > 0 && column > 0)
					{
						matrix[row][column] = (char) ('1' + Math.min(matrix[row - 1][column - 1] - '0',
							Math.min(matrix[row - 1][column] - '0',
								matrix[row][column - 1] - '0')));
					}

					max = Math.max(max, matrix[row][column] - '0');
				}
			}
		}

		return max * max;
	}
}

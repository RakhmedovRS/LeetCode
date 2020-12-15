import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12/15/2020
 */
@LeetCode(
	id = 562,
	name = "Longest Line of Consecutive One in Matrix",
	url = "https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class LongestLineOfConsecutiveOneInMatrix
{
	public int longestLine(int[][] M)
	{
		int max = 0;
		int rows = M.length;
		if (rows == 0)
		{
			return max;
		}
		int columns = M[0].length;

		int[][] left = createCopy(M, rows, columns);
		int[][] leftCorner = createCopy(M, rows, columns);
		int[][] up = createCopy(M, rows, columns);
		int[][] rightCorner = createCopy(M, rows, columns);

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (M[row][column] == 1)
				{
					max = Math.max(max, 1);

					//left
					if (column - 1 >= 0)
					{
						left[row][column] = Math.max(left[row][column], left[row][column - 1] + 1);
						max = Math.max(max, left[row][column]);
					}

					//left corner
					if (row - 1 >= 0 && column - 1 >= 0)
					{
						leftCorner[row][column] = Math.max(leftCorner[row][column], leftCorner[row - 1][column - 1] + 1);
						max = Math.max(max, leftCorner[row][column]);
					}

					//up
					if (row - 1 >= 0)
					{
						up[row][column] = Math.max(up[row][column], up[row - 1][column] + 1);
						max = Math.max(max, up[row][column]);
					}

					//right corner
					if (row - 1 >= 0 && column + 1 < columns)
					{
						rightCorner[row][column] = Math.max(rightCorner[row][column], rightCorner[row - 1][column + 1] + 1);
						max = Math.max(max, rightCorner[row][column]);
					}
				}
			}
		}

		return max;
	}

	private int[][] createCopy(int[][] matrix, int rows, int columns)
	{
		int[][] copy = new int[rows][];
		for (int j = 0; j < matrix.length; j++)
		{
			copy[j] = Arrays.copyOf(matrix[j], columns);
		}

		return copy;
	}
}

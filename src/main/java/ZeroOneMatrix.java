import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 21-May-20
 */
@LeetCode(id = 542, name = "01 Matrix", url = "https://leetcode.com/problems/01-matrix/")
public class ZeroOneMatrix
{
	public int[][] updateMatrix(int[][] matrix)
	{
		int[][] answer = new int[matrix.length][matrix[0].length];
		for (int[] row : answer)
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}

		for (int row = 0; row < matrix.length; row++)
		{
			for (int column = 0; column < matrix[row].length; column++)
			{
				if (matrix[row][column] == 0)
				{
					answer[row][column] = 0;
					updateMatrix(answer, row - 1, column, 1, matrix);
					updateMatrix(answer, row + 1, column, 1, matrix);
					updateMatrix(answer, row, column - 1, 1, matrix);
					updateMatrix(answer, row, column + 1, 1, matrix);
				}
			}
		}

		return answer;
	}

	private void updateMatrix(int[][] answer, int row, int column, int steps, int[][] matrix)
	{
		if (row < 0
			|| row == answer.length
			|| column < 0
			|| column == answer[row].length
			|| answer[row][column] <= steps
			|| matrix[row][column] == 0)
		{
			return;
		}

		answer[row][column] = steps++;
		updateMatrix(answer, row - 1, column, steps, matrix);
		updateMatrix(answer, row + 1, column, steps, matrix);
		updateMatrix(answer, row, column - 1, steps, matrix);
		updateMatrix(answer, row, column + 1, steps, matrix);
	}
}

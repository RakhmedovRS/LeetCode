package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 17-Jun-20
 */
@LeetCode(id = 1380, name = "Lucky Numbers in a Matrix", url = "https://leetcode.com/problems/lucky-numbers-in-a-matrix/")
public class LuckyNumbersInMatrix
{
	public List<Integer> luckyNumbers(int[][] matrix)
	{
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
		{
			return result;
		}

		int rows = matrix.length;
		int columns = matrix[0].length;
		int[] rowMin = new int[rows];
		int[] columnMax = new int[columns];

		for (int row = 0; row < rows; row++)
		{
			rowMin[row] = findRowMin(matrix[row]);
		}

		for (int column = 0; column < columns; column++)
		{
			columnMax[column] = findMaxInColumn(matrix, column, rows);
		}

		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < columns; c++)
			{
				if (rowMin[r] == columnMax[c])
				{
					result.add(rowMin[r]);
				}
			}
		}
		return result;
	}

	private int findRowMin(int[] row)
	{
		int min = Integer.MAX_VALUE;
		for (int num : row)
		{
			min = Math.min(min, num);
		}
		return min;
	}

	private int findMaxInColumn(int[][] matrix, int column, int rows)
	{
		int max = Integer.MIN_VALUE;
		for (int row = 0; row < rows; row++)
		{
			max = Math.max(max, matrix[row][column]);
		}

		return max;
	}
}

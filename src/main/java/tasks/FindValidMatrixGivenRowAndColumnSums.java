package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/5/2020
 */
@LeetCode(id = 1605, name = "Find Valid Matrix Given Row and Column Sums", url = "https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/")
public class FindValidMatrixGivenRowAndColumnSums
{
	public int[][] restoreMatrix(int[] rowSum, int[] colSum)
	{
		int[][] matrix = new int[rowSum.length][colSum.length];
		int rValue;
		int cValue;
		int maxPossible;

		for (int row = 0; row < rowSum.length; row++)
		{
			for (int column = 0; column < colSum.length; column++)
			{
				rValue = Math.max(0, rowSum[row]);
				cValue = Math.max(0, colSum[column]);
				maxPossible = Math.min(rValue, cValue);

				matrix[row][column] = maxPossible;

				rowSum[row] -= maxPossible;
				colSum[column] -= maxPossible;
			}
		}

		return matrix;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/17/2021
 */
@LeetCode(
	id = 311,
	name = "Sparse Matrix Multiplication",
	url = "https://leetcode.com/problems/sparse-matrix-multiplication/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class SparseMatrixMultiplication
{
	public int[][] multiply(int[][] A, int[][] B)
	{
		int rowsA = A.length;
		int columnsA = A[0].length;
		int rowsB = B.length;
		int columnsB = B[0].length;

		int[][] answer = new int[rowsA][columnsB];
		int sum;
		for (int row = 0; row < rowsA; row++)
		{
			for (int column = 0; column < columnsB; column++)
			{
				sum = 0;
				for (int j = 0; j < columnsA; j++)
				{
					sum += A[row][j] * B[j][column];
				}
				answer[row][column] = sum;
			}
		}

		return answer;
	}
}

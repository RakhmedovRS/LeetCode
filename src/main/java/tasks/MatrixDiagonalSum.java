package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Sep-20
 */
@LeetCode(id = 1572, name = "Matrix Diagonal Sum", url = "https://leetcode.com/problems/matrix-diagonal-sum/")
public class MatrixDiagonalSum
{
	public int diagonalSum(int[][] mat)
	{
		int rows = mat.length;
		int columns = mat[0].length;
		int sum = 0;
		int row = 0;
		int column = 0;
		while (row < rows && column < columns)
		{
			sum += mat[row++][column++];
		}

		row = 0;
		column = columns - 1;
		while (row < rows && column >= 0)
		{
			sum += mat[row++][column--];
		}

		if (rows == columns && rows % 2 != 0)
		{
			sum -= mat[rows / 2][columns / 2];
		}

		return sum;
	}

	public static void main(String[] args)
	{
		System.out.println(new MatrixDiagonalSum().diagonalSum(new int[][]
				{
						{1, 1, 1, 1},
						{1, 1, 1, 1},
						{1, 1, 1, 1},
						{1, 1, 1, 1}
				}));

		System.out.println(new MatrixDiagonalSum().diagonalSum(new int[][]
				{
						{1, 2, 3},
						{4, 5, 6},
						{7, 8, 9}
				}));

		System.out.println(new MatrixDiagonalSum().diagonalSum(new int[][]
				{
						{5}
				}));
	}
}

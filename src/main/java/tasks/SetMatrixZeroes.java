package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 01-Apr-20
 */
@LeetCode(id = 73, name = "Set Matrix Zeroes", url = "https://leetcode.com/problems/set-matrix-zeroes/")
public class SetMatrixZeroes
{
	public void setZeroes(int[][] matrix)
	{
		boolean firstRowZero = false;
		boolean firstColZero = false;

		int rows = matrix.length;
		int columns = matrix[0].length;

		for (int row = 0; row < rows; row++)
		{
			if (matrix[row][0] == 0)
			{
				firstColZero = true;
				break;
			}
		}

		for (int column = 0; column < columns; column++)
		{
			if (matrix[0][column] == 0)
			{
				firstRowZero = true;
				break;
			}
		}

		for (int row = 1; row < rows; row++)
		{
			for (int column = 1; column < columns; column++)
			{
				if (matrix[row][column] == 0)
				{
					matrix[row][0] = 0;
					matrix[0][column] = 0;
				}
			}
		}

		for (int row = 1; row < rows; row++)
		{
			if (matrix[row][0] == 0)
			{
				for (int column = 1; column < columns; column++)
				{
					matrix[row][column] = 0;
				}
			}
		}

		for (int column = 1; column < columns; column++)
		{
			if (matrix[0][column] == 0)
			{
				for (int j = 1; j < rows; j++)
				{
					matrix[j][column] = 0;
				}
			}
		}

		if (firstRowZero)
		{
			for (int column = 0; column < columns; column++)
			{
				matrix[0][column] = 0;
			}
		}

		if (firstColZero)
		{
			for (int row = 0; row < rows; row++)
			{
				matrix[row][0] = 0;
			}
		}
	}

	public static void main(String[] args)
	{
		int[][] matrix = new int[][]{
			{0, 1, 2, 0},
			{3, 4, 5, 2},
			{1, 3, 1, 5}
		};

		new SetMatrixZeroes().setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));

		matrix = new int[][]{
			{0, 1}
		};

		new SetMatrixZeroes().setZeroes(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}

package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Jun-20
 */
@LeetCode(id = 566, name = "Reshape the Matrix", url = "https://leetcode.com/problems/reshape-the-matrix/")
public class ReshapeTheMatrix
{
	public int[][] matrixReshape(int[][] nums, int r, int c)
	{
		int rows = nums.length;
		int columns = nums[0].length;

		if (rows * columns != r * c)
		{
			return nums;
		}

		int[][] matrix = new int[r][c];
		int matrixRow = 0;
		int matrixColumn = 0;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				matrix[matrixRow][matrixColumn] = nums[row][column];
				matrixColumn++;
				if (matrixColumn == c)
				{
					matrixColumn = 0;
					matrixRow++;
				}
			}
		}

		return matrix;
	}
}

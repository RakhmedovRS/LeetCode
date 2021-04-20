package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 15-Jun-20
 */
@LeetCode(
	id = 1329,
	name = "Sort the Matrix Diagonally",
	url = "https://leetcode.com/problems/sort-the-matrix-diagonally/",
	difficulty = Difficulty.MEDIUM
)
public class SortMatrixDiagonally
{
	public int[][] diagonalSort(int[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int row = 0; row < rows; row++)
		{
			List<Integer> nums = new ArrayList<>();
			for (int r = row, c = 0; r < rows && c < columns; r++,c++)
			{
				nums.add(matrix[r][c]);
			}

			nums.sort(null);

			int pos = 0;
			for (int r = row, c = 0; r < rows && c < columns; r++,c++)
			{
				matrix[r][c] = nums.get(pos++);
			}
		}

		for (int column = 1; column < columns; column++)
		{
			List<Integer> nums = new ArrayList<>();
			for (int r = 0, c = column; r < rows && c < columns; r++,c++)
			{
				nums.add(matrix[r][c]);
			}

			nums.sort(null);

			int pos = 0;
			for (int r = 0, c = column; r < rows && c < columns; r++,c++)
			{
				matrix[r][c] = nums.get(pos++);
			}
		}

		return matrix;
	}
}

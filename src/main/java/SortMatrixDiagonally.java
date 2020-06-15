import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 15-Jun-20
 */
@LeetCode(id = 1329, name = "Sort the Matrix Diagonally", url = "https://leetcode.com/problems/sort-the-matrix-diagonally/")
public class SortMatrixDiagonally
{
	public int[][] diagonalSort(int[][] mat)
	{
		List<Integer> values = new ArrayList<>();
		int rows = mat.length;
		int columns = mat[0].length;

		for (int row = 0; row < rows; row++)
		{
			sortDiagonal(mat, row, 0, rows, columns);
		}

		for (int column = 1; column < columns; column++)
		{
			sortDiagonal(mat, 0, column, rows, columns);
		}

		return mat;
	}

	private void sortDiagonal(int[][] mat, int row, int column, int rows, int columns)
	{
		List<Integer> values = new ArrayList<>();
		int r = row;
		int c = column;
		while (r < rows && c < columns)
		{
			values.add(mat[r++][c++]);
		}

		values.sort(Comparator.naturalOrder());

		r = row;
		c = column;
		int i = 0;
		while (r < rows && c < columns)
		{
			mat[r++][c++] = values.get(i++);
		}
	}
}

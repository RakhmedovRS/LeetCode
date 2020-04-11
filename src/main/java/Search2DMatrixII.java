import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(id = 240, name = "Search a 2D Matrix II", url = "https://leetcode.com/problems/search-a-2d-matrix-ii/")
public class Search2DMatrixII
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		if (matrix == null || matrix.length == 0)
		{
			return false;
		}

		int row = matrix.length - 1;
		int column = 0;
		while (row >= 0 && column <= matrix[row].length - 1)
		{
			if (matrix[row][column] == target)
			{
				return true;
			}
			else if (matrix[row][column] > target)
			{
				row--;
			}
			else
			{
				column++;
			}
		}

		return false;
	}
}

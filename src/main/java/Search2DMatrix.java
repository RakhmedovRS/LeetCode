import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(id = 74, name = "Search a 2D Matrix", url = "https://leetcode.com/problems/search-a-2d-matrix/")
public class Search2DMatrix
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		if (matrix == null || matrix.length == 0)
		{
			return false;
		}

		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		int left = 0;
		int right = rowCount * columnCount - 1;

		int row;
		int column;
		int middle;
		while (left <= right)
		{
			middle = left + (right - left) / 2;
			row = middle / columnCount;
			column = middle % columnCount;
			if (matrix[row][column] == target)
			{
				return true;
			}
			else if (matrix[row][column] < target)
			{
				left = middle + 1;
			}
			else
			{
				right = middle - 1;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		int[][] matrix = new int[][]
			{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
			};

		System.out.println(new Search2DMatrix().searchMatrix(matrix, 3));
	}
}

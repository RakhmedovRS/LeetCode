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

		int rows = matrix.length;
		int columns = matrix[0].length;
		int row;
		int column;
		int left = 0;
		int mid;
		int right = rows * columns - 1;
		while (left <= right)
		{
			mid = left + (right - left) / 2;
			row = mid / columns;
			column = mid % columns;
			if (matrix[row][column] == target)
			{
				return true;
			}
			else if (matrix[row][column] > target)
			{
				right = mid - 1;
			}
			else
			{
				left = mid + 1;
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

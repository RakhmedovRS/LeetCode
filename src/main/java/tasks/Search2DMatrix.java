package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(
	id = 74,
	name = "Search a 2D Matrix",
	url = "https://leetcode.com/problems/search-a-2d-matrix/",
	difficulty = Difficulty.MEDIUM
)
public class Search2DMatrix
{

	public boolean searchMatrix(int[][] matrix, int target)
	{
		int row = 0;
		int column = matrix[row].length - 1;
		while (row >= 0 && row < matrix.length && column >= 0 && column < matrix[row].length)
		{
			if (matrix[row][column] == target)
			{
				return true;
			}
			else if (matrix[row][column] > target)
			{
				column--;
			}
			else
			{
				row++;
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

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/11/2021
 */
@LeetCode(
	id = 1198,
	name = "Find Smallest Common Element in All Rows",
	url = "https://leetcode.com/problems/find-smallest-common-element-in-all-rows/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class FindSmallestCommonElementInAllRows
{
	public int smallestCommonElement(int[][] matrix)
	{
		int rows = matrix.length;
		if (rows == 0)
		{
			return -1;
		}
		int columns = matrix[0].length;

		int[] memo = new int[10_001];
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (column == 0 || matrix[row][column - 1] != matrix[row][column])
				{
					memo[matrix[row][column]]++;
				}
			}
		}

		for (int i = 1; i < memo.length; i++)
		{
			if (memo[i] == rows)
			{
				return i;
			}
		}
		return -1;
	}
}

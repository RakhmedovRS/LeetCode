package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
@LeetCode(id = 1351, name = "Count Negative Numbers in a Sorted Matrix", url = "https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/")
public class CountNegativeNumbersInSortedMatrix
{
	public int countNegatives(int[][] grid)
	{
		int count = 0;
		for (int i = grid.length - 1; i >= 0; i--)
		{
			int[] row = grid[i];

			int right = row.length - 1;
			if (row[right] >= 0)
			{
				break;
			}

			while (right >= 0 && row[right] < 0)
			{
				count++;
				right--;
			}
		}
		return count;
	}
}

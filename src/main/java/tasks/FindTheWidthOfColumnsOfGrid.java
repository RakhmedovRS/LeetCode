package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 4/15/2023
 */
@LeetCode(
		id = 2639,
		name = "Find the Width of Columns of a Grid",
		url = "https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/",
		difficulty = Difficulty.EASY
)
public class FindTheWidthOfColumnsOfGrid
{
	public int[] findColumnWidth(int[][] grid)
	{
		int[] ans = new int[grid[0].length];
		for (int column = 0; column < grid[0].length; column++)
		{
			int max = 0;
			for (int[] row : grid)
			{
				max = Math.max(max, String.valueOf(row[column]).length());
			}
			ans[column] = max;
		}

		return ans;
	}
}

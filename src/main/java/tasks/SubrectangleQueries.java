package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18.06.2020
 */
@LeetCode(id = 1476, name = "Subrectangle Queries", url = "https://leetcode.com/problems/subrectangle-queries/")
public class SubrectangleQueries
{
	int[][] rectangle;

	public SubrectangleQueries(int[][] rectangle)
	{
		this.rectangle = rectangle;
	}

	public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
	{
		for (int row = row1; row <= row2; row++)
		{
			for (int column = col1; column <= col2; column++)
			{
				rectangle[row][column] = newValue;
			}
		}
	}

	public int getValue(int row, int col)
	{
		return rectangle[row][col];
	}
}

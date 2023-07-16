package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/2/2021
 */
@LeetCode(
		id = 2022,
		name = "Convert 1D Array Into 2D Array",
		url = "https://leetcode.com/problems/convert-1d-array-into-2d-array/",
		difficulty = Difficulty.EASY
)
public class Convert1DArrayInto2DArray
{
	public int[][] construct2DArray(int[] original, int m, int n)
	{
		if (m * n != original.length)
		{
			return new int[0][];
		}

		int pos = 0;
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				arr[i][j] = original[pos++];
			}
		}

		return arr;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 4/30/2023
 */
@LeetCode(
		id = 2661,
		name = "First Completely Painted Row or Column",
		url = "https://leetcode.com/problems/first-completely-painted-row-or-column/description/",
		difficulty = Difficulty.MEDIUM
)
public class FirstCompletelyPaintedRowOrColumn
{
	public int firstCompleteIndex(int[] arr, int[][] mat)
	{
		int rows = mat.length;
		int columns = mat[0].length;

		int[] rs = new int[rows];
		int[] cs = new int[columns];

		Map<Integer, int[]> map = new HashMap<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				map.put(mat[row][column], new int[]{row, column});
			}
		}

		for (int i = 0; i < arr.length; i++)
		{
			int[] pos = map.get(arr[i]);

			rs[pos[0]]++;
			cs[pos[1]]++;

			if (rs[pos[0]] == columns || cs[pos[1]] == rows)
			{
				return i;
			}
		}

		return -1;
	}
}

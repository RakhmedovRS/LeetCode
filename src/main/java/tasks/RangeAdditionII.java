package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/18/2020
 */
@LeetCode(
		id = 598,
		name = "Range Addition II",
		url = "https://leetcode.com/problems/range-addition-ii/",
		difficulty = Difficulty.EASY
)
public class RangeAdditionII
{
	public int maxCount(int rows, int columns, int[][] ops)
	{
		int xMin = rows;
		int yMin = columns;

		for (int[] op : ops)
		{
			xMin = Math.min(xMin, op[0]);
			yMin = Math.min(yMin, op[1]);
		}

		return xMin * yMin;
	}
}

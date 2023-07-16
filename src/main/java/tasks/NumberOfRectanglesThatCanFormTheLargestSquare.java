package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/17/2021
 */
@LeetCode(
		id = 1725,
		name = "Number Of Rectangles That Can Form The Largest Square",
		url = "https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/",
		difficulty = Difficulty.EASY
)
public class NumberOfRectanglesThatCanFormTheLargestSquare
{
	public int countGoodRectangles(int[][] rectangles)
	{
		int max = 0;
		int count = 0;
		int side;
		for (int[] rec : rectangles)
		{
			side = Math.min(rec[0], rec[1]);
			if (side > max)
			{
				max = side;
				count = 1;
			}
			else if (side == max)
			{
				count++;
			}
		}

		return count;
	}
}

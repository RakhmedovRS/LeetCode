package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/21/2021
 */
@LeetCode(
	id = 2078,
	name = "Two Furthest Houses With Different Colors",
	url = "https://leetcode.com/problems/two-furthest-houses-with-different-colors/",
	difficulty = Difficulty.EASY
)
public class TwoFurthestHousesWithDifferentColors
{
	public int maxDistance(int[] colors)
	{
		int max = 0;
		for (int i = 0; i < colors.length; i++)
		{
			for (int j = 0; j < colors.length; j++)
			{
				if (colors[i] != colors[j])
				{
					max = Math.max(max, Math.abs(i - j));
				}
			}
		}

		return max;
	}
}

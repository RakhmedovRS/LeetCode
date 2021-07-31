package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
@LeetCode(
	id = 42,
	name = "Trapping Rain Water",
	url = "https://leetcode.com/problems/trapping-rain-water/",
	difficulty = Difficulty.HARD
)
public class TrappingRainWater
{
	public int trap(int[] height)
	{
		int water = 0;
		if (height == null || height.length == 0)
		{
			return water;
		}

		int[] maxFromLeft = new int[height.length];
		int[] maxFromRight = new int[height.length];

		int max = height[0];
		maxFromLeft[0] = max;
		for (int i = 1; i < height.length; i++)
		{
			if (height[i] > max)
			{
				max = height[i];
			}

			maxFromLeft[i] = max;
		}

		max = height[height.length - 1];
		maxFromRight[height.length - 1] = max;
		for (int i = height.length - 2; i >= 0; i--)
		{
			if (height[i] > max)
			{
				max = height[i];
			}

			maxFromRight[i] = max;
		}

		for (int i = 0; i < height.length; i++)
		{
			water += Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
		}

		return water;
	}
}

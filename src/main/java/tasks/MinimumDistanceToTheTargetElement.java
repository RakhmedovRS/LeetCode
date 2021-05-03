package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/2/2021
 */
@LeetCode(
	id = 1848,
	name = "Minimum Distance to the Target Element",
	url = "https://leetcode.com/problems/minimum-distance-to-the-target-element/",
	difficulty = Difficulty.EASY
)
public class MinimumDistanceToTheTargetElement
{
	public int getMinDistance(int[] nums, int target, int start)
	{
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == target)
			{
				min = Math.min(min, Math.abs(i - start));
			}
		}

		return min;
	}
}

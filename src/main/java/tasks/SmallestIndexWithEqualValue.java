package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/7/2021
 */
@LeetCode(
		id = 2057,
		name = "Smallest Index With Equal Value",
		url = "https://leetcode.com/problems/smallest-index-with-equal-value/",
		difficulty = Difficulty.EASY
)
public class SmallestIndexWithEqualValue
{
	public int smallestEqual(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			if ((i % 10) == nums[i])
			{
				return i;
			}
		}

		return -1;
	}
}

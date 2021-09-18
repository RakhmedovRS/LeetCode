package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/18/2021
 */
@LeetCode(
	id = 2006,
	name = "Count Number of Pairs With Absolute Difference K",
	url = "https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/",
	difficulty = Difficulty.EASY
)
public class CountNumberOfPairsWithAbsoluteDifferenceK
{
	public int countKDifference(int[] nums, int k)
	{
		int count = 0;
		for (int j = 1; j < nums.length; j++)
		{
			for (int i = 0; i < j; i++)
			{
				if (Math.abs(nums[i] - nums[j]) == k)
				{
					count++;
				}
			}
		}

		return count;
	}
}

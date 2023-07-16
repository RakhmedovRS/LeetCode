package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Jun-20
 */
@LeetCode(
		id = 1480,
		name = "Running Sum of 1d Array",
		url = "https://leetcode.com/problems/running-sum-of-1d-array/",
		difficulty = Difficulty.EASY
)
public class RunningSumOf1dArray
{
	public int[] runningSum(int[] nums)
	{
		for (int i = 1; i < nums.length; i++)
		{
			nums[i] += nums[i - 1];
		}

		return nums;
	}
}

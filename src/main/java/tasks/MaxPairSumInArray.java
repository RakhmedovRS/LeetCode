package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 8/12/2023
 */
@LeetCode(
		id = 2815,
		name = "Max Pair Sum in an Array",
		url = "https://leetcode.com/problems/max-pair-sum-in-an-array/",
		difficulty = Difficulty.EASY
)
public class MaxPairSumInArray
{
	public int maxSum(int[] nums)
	{
		int max = -1;
		for (int i = 0; i < nums.length; i++)
		{
			int m = maxD(nums[i]);
			for (int j = i + 1; j < nums.length; j++)
			{
				if (m == maxD(nums[j]))
				{
					max = Math.max(max, nums[i] + nums[j]);
				}
			}
		}

		return max;
	}

	private int maxD(int val)
	{
		int max = 0;
		for (char ch : String.valueOf(val).toCharArray())
		{
			max = Math.max(max, (ch - '0'));
		}

		return max;
	}
}

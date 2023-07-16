package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/14/2022
 */
@LeetCode(
		id = 2270,
		name = "Number of Ways to Split Array",
		url = "https://leetcode.com/problems/number-of-ways-to-split-array/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfWaysToSplitArray
{
	public int waysToSplitArray(int[] nums)
	{
		int res = 0;
		long totalSum = 0;
		for (int num : nums)
		{
			totalSum += num;
		}

		long currentSum = 0;
		for (int i = 0; i < nums.length - 1; i++)
		{
			currentSum += nums[i];
			totalSum -= nums[i];
			if (currentSum >= totalSum)
			{
				res++;
			}
		}

		return res;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 7/9/2023
 */
@LeetCode(
		id = 2770,
		name = "Maximum Number of Jumps to Reach the Last Index",
		url = "https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfJumpsToReachTheLastIndex
{
	public int maximumJumps(int[] nums, int target)
	{
		int[] memo = new int[nums.length];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (memo[i] == -1)
			{
				continue;
			}

			for (int j = i + 1; j < nums.length; j++)
			{
				int diff = nums[j] - nums[i];
				if (-target <= diff && diff <= target)
				{
					memo[j] = Math.max(memo[j], memo[i] + 1);
				}
			}
		}

		return memo[nums.length - 1];
	}
}

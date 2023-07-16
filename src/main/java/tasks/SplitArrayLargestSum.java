package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/6/2020
 */
@LeetCode(
		id = 410,
		name = "Split Array Largest Sum",
		url = "https://leetcode.com/problems/split-array-largest-sum/",
		difficulty = Difficulty.HARD
)
public class SplitArrayLargestSum
{
	public int splitArray(int[] nums, int m)
	{
		return dfs(0, nums, m, new Integer[nums.length][m + 1]);
	}

	private int dfs(int pos, int[] nums, int m, Integer[][] memo)
	{
		if (pos == nums.length)
		{
			return 0;
		}

		if (memo[pos][m] != null)
		{
			return memo[pos][m];
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = pos; i < nums.length; i++)
		{
			sum += nums[i];
			if (m > 1)
			{
				min = Math.min(min, Math.max(sum, dfs(i + 1, nums, m - 1, memo)));
			}
			else
			{
				min = sum;
			}
		}

		memo[pos][m] = min;
		return min;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/24/2021
 */
@LeetCode(
		id = 1335,
		name = "Minimum Difficulty of a Job Schedule",
		url = "https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/",
		difficulty = Difficulty.HARD
)
public class MinimumDifficultyOfJobSchedule
{
	public int minDifficulty(int[] jobDifficulty, int d)
	{
		if (jobDifficulty.length < d)
		{
			return -1;
		}
		Integer[][] memo = new Integer[jobDifficulty.length][d + 1];
		return dfs(0, d, jobDifficulty, memo);
	}

	private int dfs(int pos, int d, int[] jobDifficulty, Integer[][] memo)
	{
		if (pos == jobDifficulty.length)
		{
			return 0;
		}

		if (d == 1)
		{
			int max = 0;
			for (int i = pos; i < jobDifficulty.length; i++)
			{
				max = Math.max(max, jobDifficulty[i]);
			}

			memo[pos][d] = max;
			return max;
		}

		if (memo[pos][d] != null)
		{
			return memo[pos][d];
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = pos; i <= jobDifficulty.length - d; i++)
		{
			max = Math.max(max, jobDifficulty[i]);
			min = Math.min(min, max + dfs(i + 1, d - 1, jobDifficulty, memo));
		}

		memo[pos][d] = min;

		return memo[pos][d];
	}
}

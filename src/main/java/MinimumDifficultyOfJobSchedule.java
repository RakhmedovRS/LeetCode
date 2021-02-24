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

		return dfs(0, jobDifficulty, d, new Integer[jobDifficulty.length][d + 1]);
	}

	private int dfs(int pos, int[] jobDifficulty, int d, Integer[][] memo)
	{
		if (d == 1)
		{
			int max = -1;
			for (int i = pos; i < jobDifficulty.length; i++)
			{
				max = Math.max(max, jobDifficulty[i]);
			}
			return max;
		}

		if (memo[pos][d] != null)
		{
			return memo[pos][d];
		}

		int min = Integer.MAX_VALUE;
		int max = -1;
		for (int i = pos; i <= jobDifficulty.length - d; i++)
		{
			max = Math.max(max, jobDifficulty[i]);
			min = Math.min(min, max + dfs(i + 1, jobDifficulty, d - 1, memo));
		}

		memo[pos][d] = min;

		return min;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 8/29/2021
 */
@LeetCode(
	id = 1987,
	name = "Minimum Number of Work Sessions to Finish the Tasks",
	url = "https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfWorkSessionsToFinishTheTasks
{
	public int minSessions(int[] tasks, int sessionTime)
	{
		Arrays.sort(tasks);
		return 1 + dfs(tasks, sessionTime, sessionTime, 0, new Integer[sessionTime + 1][100_000]);
	}

	private int dfs(int[] tasks, int currentTime, int sessionTime, int state, Integer[][] memo)
	{
		if (state == (int) Math.pow(2, tasks.length) - 1)
		{
			return 0;
		}

		if (memo[currentTime][state] != null)
		{
			return memo[currentTime][state];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < tasks.length; i++)
		{
			if ((state & (1 << i)) == 0)
			{
				if (currentTime - tasks[i] >= 0)
				{
					state = (state ^ (1 << i));
					min = Math.min(min, dfs(tasks, currentTime - tasks[i], sessionTime, state, memo));
					state = (state ^ (1 << i));
				}
				else
				{
					state = (state ^ (1 << i));
					min = Math.min(min, 1 + dfs(tasks, sessionTime - tasks[i], sessionTime, state, memo));
					state = (state ^ (1 << i));
				}
			}
		}

		memo[currentTime][state] = min;
		return min;
	}
}

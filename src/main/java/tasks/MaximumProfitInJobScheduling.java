package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/24/2020
 */
@LeetCode(
		id = 1235,
		name = "Maximum Profit in Job Scheduling",
		url = "https://leetcode.com/problems/maximum-profit-in-job-scheduling/",
		difficulty = Difficulty.HARD
)
public class MaximumProfitInJobScheduling
{
	class Job
	{
		int startTime;
		int endTime;
		int profit;

		public Job(int startTime, int endTime, int profit)
		{
			this.startTime = startTime;
			this.endTime = endTime;
			this.profit = profit;
		}
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit)
	{
		List<Job> jobList = new ArrayList<>();
		for (int i = 0; i < startTime.length; i++)
		{
			jobList.add(new Job(startTime[i], endTime[i], profit[i]));
		}

		jobList.sort(Comparator.comparingInt(job -> job.startTime));

		return dfs(0, jobList, new Integer[jobList.size()]);
	}

	private int dfs(int pos, List<Job> jobList, Integer[] memo)
	{
		if (pos == jobList.size() || pos == -1)
		{
			return 0;
		}

		if (memo[pos] != null)
		{
			return memo[pos];
		}

		int nextIndex = binarySearch(jobList, pos, jobList.size() - 1, jobList.get(pos).endTime);
		memo[pos] = Math.max(jobList.get(pos).profit + dfs(nextIndex, jobList, memo), dfs(pos + 1, jobList, memo));

		return memo[pos];
	}

	private int binarySearch(List<Job> jobList, int left, int right, int end)
	{
		int pos = -1;
		int middle;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (jobList.get(middle).startTime >= end)
			{
				pos = middle;
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}

		return pos;
	}
}

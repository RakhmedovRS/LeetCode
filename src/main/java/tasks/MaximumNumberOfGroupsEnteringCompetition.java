package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 8/1/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2358,
		name = "Maximum Number of Groups Entering a Competition",
		url = "https://leetcode.com/problems/maximum-number-of-groups-entering-a-competition/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfGroupsEnteringCompetition
{
	public int maximumGroups(int[] grades)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : grades)
		{
			pq.add(num);
		}

		int right = grades.length - 1;
		int left = 0;
		int prev = 0;
		int prevCount = 0;
		int totalCount = 0;
		while (!pq.isEmpty())
		{
			int sum = 0;
			int currentCount = 0;
			while (!pq.isEmpty() && (sum <= prev || currentCount <= prevCount))
			{
				sum += pq.remove();
				currentCount++;
			}

			if (sum > prev && currentCount > prevCount)
			{
				totalCount++;
				prev = sum;
				prevCount = currentCount;
			}
		}

		return totalCount;
	}
}

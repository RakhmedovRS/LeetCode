package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 9/18/2021
 */
@LeetCode(
	id = 2008,
	name = "Maximum Earnings From Taxi",
	url = "https://leetcode.com/problems/maximum-earnings-from-taxi/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumEarningsFromTaxi
{
	public long maxTaxiEarnings(int n, int[][] rides)
	{
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int[] ride : rides)
		{
			map.putIfAbsent(ride[0], new ArrayList<>());
			map.get(ride[0]).add(ride);
		}

		long[] memo = new long[n + 1];
		for (int i = 1; i < memo.length; i++)
		{
			memo[i] = Math.max(memo[i], memo[i - 1]);
			for (int[] ride : map.getOrDefault(i, Collections.emptyList()))
			{
				int start = ride[0];
				int end = ride[1];
				int tip = ride[2];
				long profit = (end - start) + tip;

				memo[end] = Math.max(memo[end], memo[start] + profit);
			}
		}

		return memo[n];
	}
}

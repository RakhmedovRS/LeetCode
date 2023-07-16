package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 6/12/2022
 */
@LeetCode(
		id = 2285,
		name = "Maximum Total Importance of Roads",
		url = "https://leetcode.com/problems/maximum-total-importance-of-roads/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumTotalImportanceOfRoads
{
	public long maximumImportance(int n, int[][] roads)
	{
		Map<Integer, Long> map = new HashMap<>();
		for (int[] road : roads)
		{
			int a = road[0];
			int b = road[1];

			map.put(a, map.getOrDefault(a, 0L) + 1);
			map.put(b, map.getOrDefault(b, 0L) + 1);
		}

		long result = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (int) (map.getOrDefault(b, 0L) - map.getOrDefault(a, 0L)));
		for (int i = 0; i < n; i++)
		{
			pq.add(i);
		}

		Map<Integer, Integer> values = new HashMap<>();
		while (!pq.isEmpty())
		{
			values.put(pq.remove(), n--);
		}

		for (int[] road : roads)
		{
			int a = road[0];
			int b = road[1];

			result += values.getOrDefault(a, 0) + values.getOrDefault(b, 0);
		}

		return result;
	}
}

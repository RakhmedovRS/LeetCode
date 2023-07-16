package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 14-Jun-20
 */
@LeetCode(id = 787, name = "Cheapest Flights Within K Stops", url = "https://leetcode.com/problems/cheapest-flights-within-k-stops/")
public class CheapestFlightsWithinKStops
{
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
	{
		int[] minCost = new int[]{Integer.MAX_VALUE};
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] node : flights)
		{
			List<int[]> adjacent = graph.getOrDefault(node[0], new ArrayList<>());
			adjacent.add(node);
			graph.put(node[0], adjacent);
		}

		List<int[]> p = graph.getOrDefault(src, Collections.emptyList());
		for (int[] start : p)
		{
			traverse(graph, minCost, start[2], dst, K, start[1]);
		}

		return minCost[0] == Integer.MAX_VALUE ? -1 : minCost[0];
	}

	private void traverse(Map<Integer, List<int[]>> graph, int[] minCost,
						  int currentCost, int dst, int K, int next)
	{
		if (next == dst)
		{
			minCost[0] = Math.min(minCost[0], currentCost);
			return;
		}

		if (K <= 0)
		{
			return;
		}

		List<int[]> p = graph.getOrDefault(next, Collections.emptyList());
		for (int[] dest : p)
		{
			if (dest[2] + currentCost > minCost[0])
			{
				continue;
			}
			traverse(graph, minCost, currentCost + dest[2], dst, K - 1, dest[1]);
		}
	}
}

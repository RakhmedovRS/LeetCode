package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/17/2020
 */
@LeetCode(
		id = 1059,
		name = "All Paths from Source Lead to Destination",
		url = "https://leetcode.com/problems/all-paths-from-source-lead-to-destination/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class AllPathsFromSourceLeadToDestination
{
	public boolean leadsToDestination(int n, int[][] edges, int source, int destination)
	{
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges)
		{
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
			if (edge[0] == destination)
			{
				return false;
			}
		}

		Queue<Map.Entry<Integer, Set<Integer>>> queue = new LinkedList<>();
		queue.add(new java.util.AbstractMap.SimpleEntry<>(source, new HashSet<>()));

		Map.Entry<Integer, Set<Integer>> current;
		while (!queue.isEmpty())
		{
			current = queue.remove();
			if (!graph.containsKey(current.getKey()))
			{
				if (current.getKey() != destination)
				{
					return false;
				}

				continue;
			}

			for (Integer next : graph.get(current.getKey()))
			{
				if (current.getValue().contains(next))
				{
					return false;
				}

				Set<Integer> set = new HashSet<>(current.getValue());
				set.add(next);
				queue.add(new java.util.AbstractMap.SimpleEntry<>(next, set));
			}
		}

		return true;
	}
}

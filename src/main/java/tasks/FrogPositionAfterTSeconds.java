package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 05-Aug-20
 */
@LeetCode(id = 1377, name = "Frog Position After T Seconds", url = "https://leetcode.com/problems/frog-position-after-t-seconds/")
public class FrogPositionAfterTSeconds
{
	public double frogPosition(int n, int[][] edges, int t, int target)
	{
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges)
		{
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.putIfAbsent(edge[1], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		return dfs(graph, 1, target, t, 1D, new HashSet<>());
	}

	private double dfs(Map<Integer, List<Integer>> graph, int current, int target, int time, double probability, Set<Integer> visited)
	{
		if (time < 0)
		{
			return 0D;
		}

		List<Integer> children = graph.getOrDefault(current, Collections.emptyList());
		if (current == target && (time == 0 || visited.containsAll(children)))
		{
			return probability;
		}

		if (!visited.add(current))
		{
			return 0D;
		}

		double res;
		double nextProbability = probability / children.stream().filter(val -> !visited.contains(val)).count();
		for (int next : children)
		{
			if (!visited.contains(next))
			{
				res = dfs(graph, next, target, time - 1, nextProbability, visited);
				if (res != 0D)
				{
					return res;
				}
			}
		}

		return 0D;
	}
}

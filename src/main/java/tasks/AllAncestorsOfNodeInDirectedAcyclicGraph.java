package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 3/5/2022
 */
@LeetCode(
		id = 2192,
		name = "All Ancestors of a Node in a Directed Acyclic Graph",
		url = "https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/",
		difficulty = Difficulty.MEDIUM
)
public class AllAncestorsOfNodeInDirectedAcyclicGraph
{
	public List<List<Integer>> getAncestors(int n, int[][] edges)
	{
		List<List<Integer>> answer = new ArrayList<>();
		int[] inDegree = new int[n];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges)
		{
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(edge[1]);
			inDegree[edge[1]]++;
		}

		Map<Integer, Set<Integer>> visited = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++)
		{
			if (inDegree[i] == 0)
			{
				queue.add(i);
			}
		}

		while (!queue.isEmpty())
		{
			int node = queue.remove();
			for (int next : graph.getOrDefault(node, Collections.emptyList()))
			{
				visited.putIfAbsent(next, new TreeSet<>());
				visited.get(next).add(node);
				visited.get(next).addAll(visited.getOrDefault(node, Collections.emptySet()));
				inDegree[next]--;
				if (inDegree[next] == 0)
				{
					queue.add(next);
				}
			}
		}

		for (int i = 0; i < n; i++)
		{
			answer.add(new ArrayList<>(visited.getOrDefault(i, Collections.emptySet())));
		}

		return answer;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 9/30/2021
 */
@LeetCode(
	id = 1971,
	name = "Find if Path Exists in Graph",
	url = "https://leetcode.com/problems/find-if-path-exists-in-graph/",
	difficulty = Difficulty.EASY
)
public class FindIfPathExistsInGraph
{
	public boolean validPath(int n, int[][] edges, int start, int end)
	{
		if (start == end)
		{
			return true;
		}

		boolean[] visited = new boolean[n + 1];
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int[] edge : edges)
		{
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.putIfAbsent(edge[1], new ArrayList<>());

			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		int size;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				int current = queue.remove();
				if (visited[current])
				{
					continue;
				}

				visited[current] = true;

				for (Integer nextVertex : graph.getOrDefault(current, Collections.emptyList()))
				{
					if (nextVertex == end)
					{
						return true;
					}

					if (!visited[nextVertex])
					{
						queue.add(nextVertex);
					}
				}
			}
		}

		return false;
	}
}

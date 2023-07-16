package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 5/13/2023
 */
@LeetCode(
		id = 2685,
		name = "Count the Number of Complete Components",
		url = "https://leetcode.com/problems/count-the-number-of-complete-components/",
		difficulty = Difficulty.MEDIUM
)
public class CountTheNumberOfCompleteComponents
{
	class UnionFind
	{
		int[] parents;

		public UnionFind(int n)
		{
			parents = new int[n + 1];
			for (int i = 1; i <= n; i++)
			{
				parents[i] = i;
			}
		}

		public int getParent(int node)
		{
			int parent = node;
			while (parents[parent] != parent)
			{
				parent = parents[parent];
			}

			int temp;
			while (parents[node] != parent)
			{
				temp = parents[node];
				parents[node] = parent;
				node = temp;
			}

			return parent;
		}

		public void connect(int nodeA, int nodeB)
		{
			int parentA = getParent(nodeA);
			int parentB = getParent(nodeB);
			parents[parentB] = parentA;
		}
	}

	public int countCompleteComponents(int n, int[][] edges)
	{
		Map<Integer, Set<Integer>> graph = buildUndirectedGraph(edges);
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges)
		{
			uf.connect(edge[0], edge[1]);
		}

		Map<Integer, Set<Integer>> parent = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			int p1 = uf.getParent(i);

			parent.putIfAbsent(p1, new HashSet<>());

			parent.get(p1).add(i);
		}

		int full = 0;
		outer:
		for (Map.Entry<Integer, Set<Integer>> entry : parent.entrySet())
		{
			for (int v1 : entry.getValue())
			{
				for (int v2 : entry.getValue())
				{
					if (v1 != v2)
					{
						if (!graph.getOrDefault(v1, Collections.emptySet()).contains(v2))
						{
							continue outer;
						}
					}
				}
			}

			full++;
		}

		return full;
	}

	public Map<Integer, Set<Integer>> buildUndirectedGraph(int[][] edges)
	{
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int[] edge : edges)
		{
			graph.putIfAbsent(edge[0], new HashSet<>());
			graph.putIfAbsent(edge[1], new HashSet<>());

			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		return graph;
	}
}

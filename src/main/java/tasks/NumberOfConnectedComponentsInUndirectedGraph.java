package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 1/12/2021
 */
@LeetCode(
		id = 323,
		name = "Number of Connected Components in an Undirected Graph",
		url = "https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class NumberOfConnectedComponentsInUndirectedGraph
{
	class UnionFind
	{
		int[] parents;

		public UnionFind(int n)
		{
			parents = new int[n];
			for (int i = 0; i < n; i++)
			{
				parents[i] = i;
			}
		}

		public int findParent(int node)
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
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);

			if (parentA != parentB)
			{
				parents[parentB] = parentA;
			}
		}

		public int numberOfComponents()
		{
			Set<Integer> set = new HashSet<>();

			for (int i = 0; i < parents.length; i++)
			{
				findParent(i);
			}

			for (int p : parents)
			{
				set.add(p);
			}

			return set.size();
		}
	}


	public int countComponents(int n, int[][] edges)
	{
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges)
		{
			uf.connect(edge[0], edge[1]);
		}

		return uf.numberOfComponents();
	}
}

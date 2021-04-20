package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/2/2020
 */
@LeetCode(id = 684, name = "Redundant Connection", url = "https://leetcode.com/problems/redundant-connection/")
public class RedundantConnection
{
	class UnionFind
	{
		int[] parent;
		int[] rank;

		public UnionFind(int size)
		{
			parent = new int[size];
			rank = new int[size];

			for (int i = 0; i < size; i++)
			{
				parent[i] = i;
				rank[i] = 1;
			}
		}

		public int findParent(int node)
		{
			int parentNode = node;
			while (parent[parentNode] != parentNode)
			{
				parentNode = parent[parentNode];
			}

			int temp;
			while (parent[node] != node)
			{
				temp = parent[node];
				parent[node] = parentNode;
				node = temp;
			}

			return parentNode;
		}

		public void union(int nodeA, int nodeB)
		{
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);

			if (parentA != parentB)
			{
				if (rank[parentA] > rank[parentB])
				{
					rank[parentA] += rank[parentB];
					parent[parentB] = parentA;
				}
				else
				{
					rank[parentB] += rank[parentA];
					parent[parentA] = parentB;
				}
			}
		}
	}

	public int[] findRedundantConnection(int[][] edges)
	{
		UnionFind unionFind = new UnionFind(edges.length + 1);

		for (int[] edge : edges)
		{
			int parentA = unionFind.findParent(edge[0]);
			int parentB = unionFind.findParent(edge[1]);

			if (parentA != parentB)
			{
				unionFind.union(edge[0], edge[1]);
			}
			else
			{
				return edge;
			}
		}

		return new int[0];
	}
}

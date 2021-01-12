import common.Difficulty;
import common.LeetCode;

import java.util.Locale;

/**
 * @author RakhmedovRS
 * @created 1/12/2021
 */
@LeetCode(
	id = 261,
	name = "Graph Valid Tree",
	url  = "https://leetcode.com/problems/graph-valid-tree/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class GraphValidTree
{
	class UnionFind
	{
		int[] rank;
		int[] parents;

		public UnionFind(int n)
		{
			rank = new int[n];
			parents = new int[n];

			for (int i = 0; i < n; i++)
			{
				rank[i] = 1;
				parents[i] = i;
			}
		}

		public int findParent(int node)
		{
			int parent = node;
			while (parent != parents[parent])
			{
				parent = parents[parent];
			}

			int temp;
			while (node != parents[node])
			{
				temp = parents[node];
				parents[node] = parent;
				node = temp;
			}

			return parent;
		}

		public boolean union(int nodeA, int nodeB)
		{
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);

			if (parentA != parentB)
			{
				if (rank[parentA] >= rank[parentB])
				{
					rank[parentA] += rank[parentB];
					parents[parentB] = parentA;
				}
				else
				{
					rank[parentB] += rank[parentA];
					parents[parentA] = parentB;
				}

				return true;
			}

			return false;
		}
	}

	public boolean validTree(int n, int[][] edges)
	{
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges)
		{
			if (!uf.union(edge[0], edge[1]))
			{
				return false;
			}
		}

		int parent = uf.findParent(0);
		for (int i = 1; i < n; i++)
		{
			if (parent != uf.findParent(i))
			{
				return false;
			}
		}

		return true;
	}
}

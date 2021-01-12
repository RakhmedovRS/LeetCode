import common.Difficulty;
import common.LeetCode;

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

		public void union(int nodeA, int nodeB)
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
			}
		}
	}

	public int countComponents(int n, int[][] edges)
	{
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges)
		{
			uf.union(edge[0], edge[1]);
		}

		int diffParts = 0;
		boolean[] parts = new boolean[n];
		int parent;
		for (int i = 0; i < n; i++)
		{
			parent = uf.findParent(i);
			if (!parts[parent])
			{
				diffParts++;
			}

			parts[parent] = true;
		}

		return diffParts;
	}
}

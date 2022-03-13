package common;

/**
 * @author RakhmedovRS
 * @created 3/12/2022
 */
public class UnionFind
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

	public int maxRank()
	{
		int max = 0;
		for (int r : rank)
		{
			max = Math.max(max, r);
		}
		return max;
	}
}

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author RakhmedovRS
 * @created 2/17/2021
 */
@LeetCode(
	id = 1135,
	name = "Connecting Cities With Minimum Cost",
	url = "https://leetcode.com/problems/connecting-cities-with-minimum-cost/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class ConnectingCitiesWithMinimumCost
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

		public void join(int nodeA, int nodeB)
		{
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);
			if (parentA != parentB)
			{
				parents[parentB] = parentA;
			}
		}

		public boolean everythingConnected()
		{
			int parent = findParent(1);
			for (int i = 1; i < parents.length; i++)
			{
				if (parent != findParent(i))
				{
					return false;
				}
			}

			return true;
		}
	}

	public int minimumCost(int N, int[][] connections)
	{
		int cost = 0;
		Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
		UnionFind uf = new UnionFind(N + 1);
		int a;
		int b;
		int c;
		for (int[] connection : connections)
		{
			a = connection[0];
			b = connection[1];
			c = connection[2];

			if (uf.findParent(a) != uf.findParent(b))
			{
				uf.join(a, b);
				cost += c;
			}
		}

		return uf.everythingConnected() ? cost : -1;
	}
}

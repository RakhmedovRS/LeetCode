package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/25/2020
 */
@LeetCode(
	id = 1579,
	name = "Remove Max Number of Edges to Keep Graph Fully Traversable",
	url = "https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/",
	difficulty = Difficulty.HARD
)
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable
{
	class DSU
	{
		int[] parent;
		int[] rank;

		public DSU(int n)
		{
			parent = new int[n];
			rank = new int[n];

			for (int i = 0; i < n; i++)
			{
				parent[i] = i;
				rank[i] = 1;
			}
		}

		public DSU(int[] parent, int[] rank)
		{
			this.parent = parent;
			this.rank = rank;
		}

		private int findParent(int node)
		{
			int parent = this.parent[node];
			while (parent != this.parent[parent])
			{
				parent = this.parent[parent];
			}

			int temp;
			while (node != parent)
			{
				temp = this.parent[node];
				this.parent[node] = parent;
				node = temp;
			}

			return parent;
		}

		private boolean connect(int nodeA, int nodeB)
		{
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);
			if (parentA == parentB)
			{
				return false;
			}

			if (rank[parentA] >= rank[parentB])
			{
				parent[parentB] = parentA;
				rank[parentA] += rank[parentB];
			}
			else
			{
				parent[parentA] = parentB;
				rank[parentB] += rank[parentA];
			}

			return true;
		}

		public DSU clone()
		{
			return new DSU(Arrays.copyOf(parent, parent.length), Arrays.copyOf(rank, rank.length));
		}
	}

	public int maxNumEdgesToRemove(int n, int[][] edges)
	{
		DSU dsu = new DSU(n + 1);

		List<int[]> alice = new ArrayList<>();
		List<int[]> bob = new ArrayList<>();
		int count = 0;
		for (int[] edge : edges)
		{
			if (edge[0] == 1)
			{
				alice.add(edge);
			}
			else if (edge[0] == 2)
			{
				bob.add(edge);
			}
			else
			{
				count += dsu.connect(edge[1], edge[2]) ? 0 : 1;
			}
		}

		DSU aliceDSU = dsu.clone();
		for (int[] edge : alice)
		{
			count += aliceDSU.connect(edge[1], edge[2]) ? 0 : 1;
		}

		DSU bobDSU = dsu.clone();
		for (int[] edge : bob)
		{
			count += bobDSU.connect(edge[1], edge[2]) ? 0 : 1;
		}

		int aliceParent = aliceDSU.findParent(1);
		for (int i = 1; i <= n; i++)
		{
			if (aliceParent != aliceDSU.findParent(i))
			{
				return -1;
			}
		}

		int bobParent = bobDSU.findParent(1);
		for (int i = 1; i <= n; i++)
		{
			if (bobParent != bobDSU.findParent(i))
			{
				return -1;
			}
		}

		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable().maxNumEdgesToRemove(13, new int[][]
			{{1, 1, 2}, {2, 1, 3}, {3, 2, 4}, {3, 2, 5}, {1, 2, 6}, {3, 6, 7}, {3, 7, 8}, {3, 6, 9}, {3, 4, 10}, {2, 3, 11},
				{1, 5, 12}, {3, 3, 13}, {2, 1, 10}, {2, 6, 11}, {3, 5, 13}, {1, 9, 12}, {1, 6, 8}, {3, 6, 13}, {2, 1, 4},
				{1, 1, 13}, {2, 9, 10}, {2, 1, 6}, {2, 10, 13}, {2, 2, 9}, {3, 4, 12}, {2, 4, 7}, {1, 1, 10}, {1, 3, 7},
				{1, 7, 11}, {3, 3, 12}, {2, 4, 8}, {3, 8, 9}, {1, 9, 13}, {2, 4, 10}, {1, 6, 9}, {3, 10, 13}, {1, 7, 10},
				{1, 1, 11}, {2, 4, 9}, {3, 5, 11}, {3, 2, 6}, {2, 1, 5}, {2, 5, 11}, {2, 1, 7}, {2, 3, 8}, {2, 8, 9}, {3, 4, 13},
				{3, 3, 8}, {3, 3, 11}, {2, 9, 11}, {3, 1, 8}, {2, 1, 8}, {3, 8, 13}, {2, 10, 11}, {3, 1, 5}, {1, 10, 11},
				{1, 7, 12}, {2, 3, 5}, {3, 1, 13}, {2, 4, 11}, {2, 3, 9}, {2, 6, 9}, {2, 1, 13}, {3, 1, 12}, {2, 7, 8},
				{2, 5, 6}, {3, 1, 9}, {1, 5, 10}, {3, 2, 13}, {2, 3, 6}, {2, 2, 10}, {3, 4, 11}, {1, 4, 13}, {3, 5, 10},
				{1, 4, 10}, {1, 1, 8}, {3, 3, 4}, {2, 4, 6}, {2, 7, 11}, {2, 7, 10}, {2, 3, 12}, {3, 7, 11}, {3, 9, 10},
				{2, 11, 13}, {1, 1, 12}, {2, 10, 12}, {1, 7, 13}, {1, 4, 11}, {2, 4, 5}, {1, 3, 10}, {2, 12, 13}, {3, 3, 10},
				{1, 6, 12}, {3, 6, 10}, {1, 3, 4}, {2, 7, 9}, {1, 3, 11}, {2, 2, 8}, {1, 2, 8}, {1, 11, 13}, {1, 2, 13},
				{2, 2, 6}, {1, 4, 6}, {1, 6, 11}, {3, 1, 2}, {1, 1, 3}, {2, 11, 12}, {3, 2, 11}, {1, 9, 10}, {2, 6, 12},
				{3, 1, 7}, {1, 4, 9}, {1, 10, 12}, {2, 6, 13}, {2, 2, 12}, {2, 1, 11}, {2, 5, 9}, {1, 3, 8}, {1, 7, 8}, {1, 2, 12},
				{1, 5, 11}, {2, 7, 12}, {3, 1, 11}, {3, 9, 12}, {3, 2, 9}, {3, 10, 11}}));

		System.out.println(new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable().maxNumEdgesToRemove(4, new int[][]
			{
				{3, 2, 3},
				{1, 1, 2},
				{2, 3, 4},
			}));
	}
}

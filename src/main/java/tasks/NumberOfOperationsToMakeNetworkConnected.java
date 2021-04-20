package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/13/2020
 */
@LeetCode(id = 1319, name = "Number of Operations to Make Network Connected", url = "https://leetcode.com/problems/number-of-operations-to-make-network-connected/")
public class NumberOfOperationsToMakeNetworkConnected
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

		public int findParent(int node)
		{
			int head = node;
			while (parent[head] != head)
			{
				head = parent[head];
			}

			int temp;
			while (node != head)
			{
				temp = parent[node];
				parent[node] = head;
				node = temp;
			}

			return head;
		}

		public void join(int nodeA, int nodeB)
		{
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);

			if (parentA == parentB)
			{
				return;
			}

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

		public int countOfCluster()
		{
			int count = 0;
			boolean[] used = new boolean[parent.length];
			for (int i = 0; i < parent.length; i++)
			{
				int p = findParent(i);
				if (!used[p])
				{
					count++;
					used[p] = true;
				}
			}

			return count;
		}
	}

	public int makeConnected(int n, int[][] connections)
	{
		if (connections.length < n - 1)
		{
			return -1;
		}

		DSU dsu = new DSU(n);
		for (int[] connect : connections)
		{
			dsu.join(connect[0], connect[1]);
		}

		return dsu.countOfCluster() - 1;
	}
}

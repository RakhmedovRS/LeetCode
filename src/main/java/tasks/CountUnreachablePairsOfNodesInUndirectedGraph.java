package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 6/26/2022
 */
@LeetCode(
		id = 2316,
		name = "Count Unreachable Pairs of Nodes in an Undirected Graph",
		url = "https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/",
		difficulty = Difficulty.MEDIUM
)
public class CountUnreachablePairsOfNodesInUndirectedGraph
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
					rank[parentB] = 0;
				}
				else
				{
					rank[parentB] += rank[parentA];
					parents[parentA] = parentB;
					rank[parentA] = 0;
				}

				return true;
			}

			return false;
		}

		public List<Integer> getRank()
		{
			List<Integer> list = new ArrayList<>();
			for (int r : rank)
			{
				if (r > 0)
				{
					list.add(r);
				}
			}

			list.sort(Comparator.reverseOrder());

			return list;
		}
	}

	public long countPairs(int n, int[][] edges)
	{
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges)
		{
			uf.union(edge[0], edge[1]);
		}

		long answer = 0;

		List<Integer> rank = uf.getRank();
		int[] suffix = new int[rank.size()];
		for (int i = suffix.length - 1; i >= 0; i--)
		{
			suffix[i] = rank.get(i);
			if (i != suffix.length - 1)
			{
				suffix[i] += suffix[i + 1];
			}
		}

		for (int i = 0; i < rank.size(); i++)
		{
			answer += (long) rank.get(i) * (suffix[i] - rank.get(i));
		}

		return answer;
	}
}

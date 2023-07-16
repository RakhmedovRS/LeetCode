package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 12/11/2022
 */
@LeetCode(
		id = 2492,
		name = "Minimum Score of a Path Between Two Cities",
		url = "https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumScoreOfPathBetweenTwoCities
{
	class UnionFind
	{
		int[] parents;
		int[] mins;

		public UnionFind(int n)
		{
			parents = new int[n + 1];
			for (int i = 0; i < n; i++)
			{
				parents[i] = i;
			}

			mins = new int[n + 1];
			Arrays.fill(mins, Integer.MAX_VALUE);
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

		public void join(int nodeA, int nodeB, int val)
		{
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);
			if (parentA != parentB)
			{
				parents[parentB] = parentA;
			}

			mins[nodeA] = Math.min(mins[nodeA], val);
			mins[nodeB] = Math.min(mins[nodeB], val);
		}
	}

	public int minScore(int n, int[][] roads)
	{
		UnionFind uf = new UnionFind(n);
		for (int[] road : roads)
		{
			uf.join(road[0], road[1], road[2]);
		}

		int min = uf.mins[1];
		for (int i = 2; i <= n; i++)
		{
			if (uf.findParent(1) == uf.findParent(i))
			{
				min = Math.min(min, uf.mins[i]);
			}
		}

		return min;
	}
}

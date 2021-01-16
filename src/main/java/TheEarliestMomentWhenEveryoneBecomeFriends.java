import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author RakhmedovRS
 * @created 1/16/2021
 */
@LeetCode(
	id = 1101,
	name = "The Earliest Moment When Everyone Become Friends",
	url = "https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class TheEarliestMomentWhenEveryoneBecomeFriends
{
	class UnionFind
	{
		int[] parents;
		int differentParents;

		public UnionFind(int n)
		{
			parents = new int[n];
			differentParents = n;
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
				differentParents--;
				parents[parentB] = parentA;
			}
		}

		public boolean everyBodyConnected()
		{
			return differentParents == 1;
		}
	}

	public int earliestAcq(int[][] logs, int N)
	{
		Arrays.sort(logs, Comparator.comparingInt(arr -> arr[0]));

		UnionFind uf = new UnionFind(N);
		for (int[] log : logs)
		{
			uf.join(log[1], log[2]);

			if (uf.everyBodyConnected())
			{
				return log[0];
			}
		}

		return -1;
	}
}

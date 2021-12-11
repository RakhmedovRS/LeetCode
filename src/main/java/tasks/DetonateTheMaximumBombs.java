package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/11/2021
 */
@LeetCode(
	id = 2101,
	name = "Detonate the Maximum Bombs",
	url = "https://leetcode.com/problems/detonate-the-maximum-bombs/",
	difficulty = Difficulty.MEDIUM
)
public class DetonateTheMaximumBombs
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

	public int maximumDetonation(int[][] bombs)
	{
		int max = 0;
		for (int i = 0; i < bombs.length; i++)
		{
			UnionFind uf = new UnionFind(bombs.length);
			boolean[] detonated = new boolean[bombs.length];
			LinkedList<Integer> list = new LinkedList<>();
			for (int j = 0; j < bombs.length; j++)
			{
				if (i != j)
				{
					if (isInside(bombs[i][0], bombs[i][1], bombs[i][2], bombs[j][0], bombs[j][1]))
					{
						uf.union(i, j);
						detonated[j] = true;
						list.add(j);
					}
				}
			}

			while (!list.isEmpty())
			{
				int pos = list.removeFirst();

				for (int j = 0; j < bombs.length; j++)
				{
					if (pos != j)
					{
						if (!detonated[j] && isInside(bombs[pos][0], bombs[pos][1], bombs[pos][2], bombs[j][0], bombs[j][1]))
						{
							uf.union(pos, j);
							detonated[j] = true;
							list.add(j);
						}
					}
				}
			}

			max = Math.max(max, uf.maxRank());
		}

		return max;
	}

	private boolean isInside(int circle_x, int circle_y,
	                         long radius, int x, int y)
	{
		if ((long) (x - circle_x) * (x - circle_x) +
			(long) (y - circle_y) * (y - circle_y) <= radius * radius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

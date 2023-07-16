package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/2/2020
 */
@LeetCode(
		id = 1443,
		name = "Minimum Time to Collect All Apples in a Tree",
		url = "https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumTimeToCollectAllApplesInTree
{
	public int minTime(int n, int[][] edges, List<Boolean> hasApple)
	{
		Map<Integer, Integer> parents = new HashMap<>();
		LinkedList<Integer> queue = new LinkedList<>();
		for (int[] edge : edges)
		{
			if (parents.containsKey(edge[1]))
			{
				parents.put(edge[0], edge[1]);
			}
			else
			{
				parents.put(edge[1], edge[0]);
			}
		}

		for (int i = 0; i < n; i++)
		{
			if (hasApple.get(i))
			{
				queue.add(i);
			}
		}

		int node;
		int parent;
		Set<String> edgesSet = new HashSet<>();
		while (!queue.isEmpty())
		{
			node = queue.remove();
			if (node == 0)
			{
				continue;
			}

			parent = parents.get(node);

			edgesSet.add(node + "->" + parent);

			queue.add(parent);
		}

		return edgesSet.size() * 2;
	}
}

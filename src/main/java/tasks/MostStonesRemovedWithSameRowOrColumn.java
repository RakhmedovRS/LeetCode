package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 9/28/2020
 */
@LeetCode(
		id = 947,
		name = "Most Stones Removed with Same Row or Column",
		url = "https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/",
		difficulty = Difficulty.MEDIUM
)
public class MostStonesRemovedWithSameRowOrColumn
{
	public int removeStones(int[][] stones)
	{
		Map<Integer, Integer> dsu = new HashMap<>();
		int[] islands = {0};
		for (int[] stone : stones)
		{
			union(dsu, stone[0], ~stone[1], islands);
		}

		return stones.length - islands[0];
	}

	private int findParent(Map<Integer, Integer> dsu, int x, int[] islands)
	{
		if (!dsu.containsKey(x))
		{
			dsu.put(x, x);
			islands[0]++;
		}

		if (x != dsu.get(x))
		{
			dsu.put(x, findParent(dsu, dsu.get(x), islands));
		}

		return dsu.get(x);
	}

	private void union(Map<Integer, Integer> dsu, int x, int y, int[] islands)
	{
		int xParent = findParent(dsu, x, islands);
		int yParent = findParent(dsu, y, islands);
		if (xParent != yParent)
		{
			islands[0]--;
			dsu.put(xParent, yParent);
		}
	}
}

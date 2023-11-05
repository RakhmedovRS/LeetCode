package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 11/4/2023
 */
@LeetCode(
		id = 2924,
		name = "Find Champion II",
		url = "https://leetcode.com/problems/find-champion-ii/",
		difficulty = Difficulty.MEDIUM
)
public class FindChampionII
{
	public int findChampion(int n, int[][] grid)
	{
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge: grid) {
			map.putIfAbsent(edge[0], new ArrayList<>());
			map.get(edge[0]).add(edge[1]);
		}

		boolean[] winner = new boolean[n];
		Arrays.fill(winner, true);
		for (List<Integer> weak : map.values())
		{
			for (int w : weak)
			{
				winner[w] = false;
			}
		}

		int candidate = -1;
		for (int i = 0; i < winner.length; i++)
		{
			if (winner[i])
			{
				if (candidate != - 1)
				{
					return -1;
				}
				else
				{
					candidate = i;
				}
			}
		}

		return candidate;
	}
}

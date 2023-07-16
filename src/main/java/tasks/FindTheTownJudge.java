package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10-May-20
 */
@LeetCode(
		id = 997,
		name = "Find the Town Judge",
		url = "https://leetcode.com/problems/find-the-town-judge/",
		difficulty = Difficulty.EASY
)
public class FindTheTownJudge
{
	public int findJudge(int N, int[][] trust)
	{
		if (trust == null || trust.length == 0)
		{
			return 1;
		}

		Map<Integer, List<Integer>> graph = new HashMap<>();
		Map<Integer, List<Integer>> ancestors = new HashMap<>();
		for (int[] node : trust)
		{
			List<Integer> list = graph.getOrDefault(node[0], new ArrayList<>());
			list.add(node[1]);
			graph.put(node[0], list);
			if (!graph.containsKey(node[1]))
			{
				graph.put(node[1], new ArrayList<>());
			}

			list = ancestors.getOrDefault(node[1], new ArrayList<>());
			list.add(node[0]);
			ancestors.put(node[1], list);
		}

		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet())
		{
			if (entry.getValue().isEmpty() && ancestors.get(entry.getKey()).size() == N - 1)
			{
				return entry.getKey();
			}
		}

		return -1;
	}
}

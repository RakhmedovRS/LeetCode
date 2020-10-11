import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/11/2020
 */
@LeetCode(id = 1615, name = "Maximal Network Rank", url = "https://leetcode.com/problems/maximal-network-rank/")
public class MaximalNetworkRank
{
	public int maximalNetworkRank(int n, int[][] roads)
	{
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int[] edge : roads)
		{
			graph.putIfAbsent(edge[0], new HashSet<>());
			graph.putIfAbsent(edge[1], new HashSet<>());

			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		if (graph.isEmpty())
		{
			return 0;
		}

		int max = 0;
		int temp;
		for (Map.Entry<Integer, Set<Integer>> entry1 : graph.entrySet())
		{
			for (Map.Entry<Integer, Set<Integer>> entry2 : graph.entrySet())
			{
				if (entry1.getKey().equals(entry2.getKey()))
				{
					continue;
				}

				temp = entry1.getValue().size() + entry2.getValue().size();
				if (entry1.getValue().contains(entry2.getKey()) || entry2.getValue().contains(entry1.getKey()))
				{
					temp--;
				}

				max = Math.max(max, temp);
			}
		}

		return max;
	}
}

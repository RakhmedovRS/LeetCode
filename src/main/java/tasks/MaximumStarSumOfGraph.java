package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Ruslan Rakhmedov
 * @created 12/15/2022
 */
@LeetCode(
		id = 2497,
		name = "Maximum Star Sum of a Graph",
		url = "https://leetcode.com/problems/maximum-star-sum-of-a-graph/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumStarSumOfGraph
{
	public int maxStarSum(int[] vals, int[][] edges, int k)
	{
		Map<Integer, PriorityQueue<Integer>> pqs = new HashMap<>();
		for (int[] edge : edges)
		{
			pqs.putIfAbsent(edge[0], new PriorityQueue<>(Comparator.reverseOrder()));
			pqs.putIfAbsent(edge[1], new PriorityQueue<>(Comparator.reverseOrder()));

			pqs.get(edge[0]).add(vals[edge[1]]);
			pqs.get(edge[1]).add(vals[edge[0]]);
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < vals.length; i++)
		{
			max = Math.max(max, vals[i]);

			Integer sum = vals[i];
			int r = k;

			while (r-- > 0 && pqs.containsKey(i) && !pqs.get(i).isEmpty() && pqs.get(i).peek() > 0)
			{
				sum += pqs.get(i).remove();
			}

			max = Math.max(max, sum);
		}

		return max;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 11/13/2021
 */
@LeetCode(
		id = 2070,
		name = "Most Beautiful Item for Each Query",
		url = "https://leetcode.com/problems/most-beautiful-item-for-each-query/",
		difficulty = Difficulty.MEDIUM
)
public class MostBeautifulItemForEachQuery
{
	public int[] maximumBeauty(int[][] items, int[] queries)
	{
		Arrays.sort(items, (a, b) ->
		{
			if (a[0] == b[0])
			{
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});

		TreeMap<Integer, Integer> map = new TreeMap<>();
		int max = 0;
		for (int[] item : items)
		{
			max = Math.max(max, item[1]);
			max = Math.max(max, map.getOrDefault(item[0], 0));
			map.put(item[0], max);
		}

		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++)
		{
			Map.Entry<Integer, Integer> c = map.floorEntry(queries[i]);
			if (c != null)
			{
				answer[i] = c.getValue();
			}
		}

		return answer;
	}
}

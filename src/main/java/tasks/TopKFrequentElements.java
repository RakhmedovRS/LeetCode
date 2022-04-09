package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 08-Mar-20
 */
@LeetCode(
	id = 347,
	name = "Top K Frequent Elements",
	url = "https://leetcode.com/problems/top-k-frequent-elements/",
	difficulty = Difficulty.MEDIUM
)
public class TopKFrequentElements
{
	public List<Integer> topKFrequent(int[] values, int k)
	{
		if (values == null || values.length == 0 || k == 0)
		{
			return new ArrayList<>();
		}

		Map<Integer, Integer> cache = new HashMap<>();
		for (int value : values)
		{
			cache.put(value, cache.getOrDefault(value, 0) + 1);
		}

		PriorityQueue<Integer> sortedValues = new PriorityQueue<>((val1, val2) -> cache.get(val2).compareTo(cache.get(val1)));
		sortedValues.addAll(cache.keySet());

		List<Integer> result = new ArrayList<>(k);
		for (int i = 0; i < k; i++)
		{
			result.add(sortedValues.poll());
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new TopKFrequentElements().topKFrequent(new int[]{1, 2}, 2));
	}
}

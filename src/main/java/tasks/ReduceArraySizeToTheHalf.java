package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 22-Jun-20
 */
@LeetCode(
		id = 1338,
		name = "Reduce Array Size to The Half",
		url = "https://leetcode.com/problems/reduce-array-size-to-the-half/",
		difficulty = Difficulty.MEDIUM
)
public class ReduceArraySizeToTheHalf
{
	public int minSetSize(int[] arr)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			pq.add(entry.getKey());
		}

		int half = arr.length / 2;
		int removes = 0;
		while (half > 0)
		{
			half -= map.get(pq.remove());
			removes++;
		}

		return removes;
	}
}

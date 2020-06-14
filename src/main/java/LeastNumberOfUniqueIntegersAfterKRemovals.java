import common.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 14-Jun-20
 */
@LeetCode(id = 5454, name = "Least Number of Unique Integers after K Removals", url = "https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/")
public class LeastNumberOfUniqueIntegersAfterKRemovals
{
	public int findLeastNumOfUniqueInts(int[] arr, int k)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(arr2 -> arr2[1]));
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
		}

		while (!priorityQueue.isEmpty() && k > 0)
		{
			k -= priorityQueue.remove()[1];
		}

		return k < 0 ? priorityQueue.size() + 1 : priorityQueue.size();
	}
}

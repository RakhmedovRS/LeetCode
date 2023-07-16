package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 30-Apr-20
 */
@LeetCode(id = 1296, name = "Divide Array in Sets of K Consecutive Numbers", url = "https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/")
public class DivideArrayInSetsOfKConsecutiveNumbers
{
	public boolean isPossibleDivide(int[] nums, int k)
	{
		if (nums == null || nums.length == 0 || k == 0)
		{
			return false;
		}

		Map<Integer, Integer> values = new HashMap<>();
		for (int num : nums)
		{
			Integer count = values.getOrDefault(num, 0);
			values.put(num, count + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
		priorityQueue.addAll(values.entrySet());
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>();
		while (!priorityQueue.isEmpty())
		{
			if (entryList.isEmpty() ||
					entryList.get(entryList.size() - 1).getKey() == priorityQueue.peek().getKey() - 1)
			{
				entryList.add(priorityQueue.remove());
			}
			else
			{
				return false;
			}

			if (entryList.size() == k)
			{
				for (Map.Entry<Integer, Integer> entry : entryList)
				{
					entry.setValue(entry.getValue() - 1);
					if (entry.getValue() > 0)
					{
						priorityQueue.add(entry);
					}
				}
				entryList.clear();
			}
		}

		return entryList.isEmpty();
	}
}

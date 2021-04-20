package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 28-May-20
 */
@LeetCode(id = 599, name = "Minimum Index Sum of Two Lists", url = "https://leetcode.com/problems/minimum-index-sum-of-two-lists/")
public class MinimumIndexSumOfTwoLists
{
	public String[] findRestaurant(String[] list1, String[] list2)
	{
		if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0)
		{
			return new String[0];
		}

		Map<String, Integer> stringToIndex = new HashMap<>();
		for (int i = 0; i < list2.length; i++)
		{
			stringToIndex.put(list2[i], i);
		}

		Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();
		for (int i = 0; i < list1.length; i++)
		{
			Integer index = stringToIndex.get(list1[i]);
			if (index != null)
			{
				int sum = index + i;
				while (!queue.isEmpty() && queue.peek().getValue() > sum)
				{
					queue.poll();
				}
				if (queue.isEmpty() || queue.peek().getValue() == sum)
				{
					queue.add(new java.util.AbstractMap.SimpleEntry<>(list1[i], sum));
				}
			}
		}

		String[] answer = new String[queue.size()];
		int idx = 0;
		while (!queue.isEmpty())
		{
			answer[idx++] = queue.poll().getKey();
		}

		return answer;
	}
}

package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/31/2020
 */
@LeetCode(id = 1636, name = "Sort Array by Increasing Frequency", url = "https://leetcode.com/problems/sort-array-by-increasing-frequency/")
public class SortArrayByIncreasingFrequency
{
	public int[] frequencySort(int[] nums)
	{
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int num : nums)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
			list.add(num);
		}

		list.sort((a, b) ->
		{
			if (map.get(a).equals(map.get(b)))
			{
				return b - a;
			}

			return map.get(a) - map.get(b);
		});

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			answer[i] = list.get(i);
		}

		return answer;
	}
}

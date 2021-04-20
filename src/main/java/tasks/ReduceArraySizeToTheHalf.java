package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 22-Jun-20
 */
@LeetCode(id = 1338, name = "Reduce Array Size to The Half", url = "https://leetcode.com/problems/reduce-array-size-to-the-half/")
public class ReduceArraySizeToTheHalf
{
	public int minSetSize(int[] arr)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer> sortedKeys = new ArrayList<>(map.keySet());
		sortedKeys.sort((v1, v2) -> map.get(v2) - map.get(v1));

		int count = 0;
		int amount = 0;
		for (int key : sortedKeys)
		{
			if (amount >= arr.length / 2)
			{
				break;
			}

			amount += map.get(key);
			count++;
		}

		return count;
	}
}

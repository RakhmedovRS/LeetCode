package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/30/2021
 */
@LeetCode(
		id = 2053,
		name = "Kth Distinct String in an Array",
		url = "https://leetcode.com/problems/kth-distinct-string-in-an-array/",
		difficulty = Difficulty.EASY
)
public class KthDistinctStringInArray
{
	public String kthDistinct(String[] arr, int k)
	{
		Map<String, Integer> map = new HashMap<>();
		for (String s : arr)
		{
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		for (String s : arr)
		{
			if (map.get(s) == 1)
			{
				k--;
				if (k == 0)
				{
					return s;
				}
			}
		}

		return "";
	}
}

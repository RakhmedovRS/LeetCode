import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12-Apr-20
 */
@LeetCode(id = 1394, name = "Find Lucky Integer in an Array", url = "https://leetcode.com/problems/find-lucky-integer-in-an-array/")
public class FindLuckyIntegerInArray
{
	public int findLucky(int[] arr)
	{
		if (arr == null || arr.length == 0)
		{
			return -1;
		}

		Map<Integer, Integer> cache = new HashMap<>();
		for (int value : arr)
		{
			cache.put(value, cache.getOrDefault(value, 0) + 1);
		}

		int max = Integer.MIN_VALUE;
		for (Map.Entry<Integer, Integer> entry : cache.entrySet())
		{
			if (entry.getKey().equals(entry.getValue()) && entry.getKey() > max)
			{
				max = entry.getKey();
			}
		}

		return max == Integer.MIN_VALUE ? -1 : max;
	}
}

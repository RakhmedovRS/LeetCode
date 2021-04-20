package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/6/2020
 */
@LeetCode(id = 1124, name = "Longest Well-Performing Interval", url = "https://leetcode.com/problems/longest-well-performing-interval/")
public class LongestWellPerformingInterval
{
	public int longestWPI(int[] hours)
	{
		int max = 0;
		int sum = 0;
		Map<Integer, Integer> memo = new HashMap<>();
		for (int i = 0; i < hours.length; i++)
		{
			sum += hours[i] > 8 ? 1 : -1;
			if (!memo.containsKey(sum))
			{
				memo.put(sum, i);
			}

			if (sum > 0)
			{
				max = i + 1;
			}
			else if (memo.containsKey(sum - 1))
			{
				max = Math.max(max, i - memo.get(sum - 1));
			}
		}

		return max;
	}
}

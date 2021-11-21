package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/21/2021
 */
@LeetCode(
	id = 2080,
	name = "Range Frequency Queries",
	url = "https://leetcode.com/problems/range-frequency-queries/",
	difficulty = Difficulty.MEDIUM
)
public class RangeFrequencyQueries
{
	class RangeFreqQuery
	{

		Map<Integer, List<Integer>> map;

		public RangeFreqQuery(int[] arr)
		{
			map = new HashMap<>();
			for (int i = 0; i < arr.length; i++)
			{
				map.putIfAbsent(arr[i], new ArrayList<>());
				map.get(arr[i]).add(i);
			}
		}

		public int query(int left, int right, int value)
		{
			List<Integer> set = map.getOrDefault(value, Collections.emptyList());
			if (set.isEmpty())
			{
				return 0;
			}

			Integer start = null;
			Integer end = null;

			int l = 0;
			int r = set.size() - 1;
			int m;
			while (l <= r)
			{
				m = (l + r) / 2;
				if (set.get(m) >= left)
				{
					start = m;
					r = m - 1;
				}
				else
				{
					l = m + 1;
				}
			}

			l = 0;
			r = set.size() - 1;
			while (l <= r)
			{
				m = (l + r) / 2;
				if (set.get(m) <= right)
				{
					end = m;
					l = m + 1;
				}
				else
				{
					r = m - 1;
				}
			}

			if (start == null && end == null)
			{
				return 0;
			}
			else if (start != null && end != null)
			{
				return 1 + end - start;
			}

			return 0;
		}
	}
}

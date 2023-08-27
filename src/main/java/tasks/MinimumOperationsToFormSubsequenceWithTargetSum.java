package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ruslan Rakhmedov
 * @created 8/26/2023
 */
@LeetCode(
		id = 2835,
		name = "Minimum Operations to Form Subsequence With Target Sum",
		url = "https://leetcode.com/problems/minimum-operations-to-form-subsequence-with-target-sum/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToFormSubsequenceWithTargetSum
{
	public int minOperations(List<Integer> nums, int target)
	{
		long sum = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
		for (int num : nums)
		{
			sum += num;
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		if (sum < target)
		{
			return -1;
		}
		if (sum == 0)
		{
			return 0;
		}

		int ops = 0;
		while (true)
		{
			sum = 0;
			int lastSkipped = map.lastKey();
			for (Map.Entry<Integer, Integer> entry : map.entrySet())
			{
				for (int i = 0; i < entry.getValue(); i++)
				{
					if (sum + entry.getKey() > target)
					{
						lastSkipped = entry.getKey();
						continue;
					}
					sum += entry.getKey();
				}
			}

			if (sum == target)
			{
				return ops;
			}
			else
			{
				int c = map.remove(lastSkipped);
				if (c > 1)
				{
					map.put(lastSkipped, c - 1);
				}
				map.put(lastSkipped / 2, map.getOrDefault(lastSkipped / 2, 0) + 2);
			}
			ops++;
		}
	}
}

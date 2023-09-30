package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 9/30/2023
 */
@LeetCode(
		id = 2870,
		name = "Minimum Number of Operations to Make Array Empty",
		url = "https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfOperationsToMakeArrayEmpty
{
	public int minOperations(int[] nums)
	{
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int count = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			int c = entry.getValue();
			if (c == 1)
			{
				return -1;
			}
			else if (c % 3 == 0)
			{
				count += c / 3;
				continue;
			}

			int start = c / 3;
			while (start >= 0)
			{
				if ((c - (start * 3)) % 2 == 0)
				{
					count += start;
					count += (c - (start * 3)) / 2;
					break;
				}
				start--;
			}
		}


		return count;
	}
}

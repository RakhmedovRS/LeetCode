package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2/6/2023
 */
@LeetCode(
		id = 2554,
		name = "Maximum Number of Integers to Choose From a Range I",
		url = "https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumNumberOfIntegersToChooseFromRangeI
{
	public int maxCount(int[] banned, int n, int maxSum)
	{
		Set<Integer> b = new HashSet<>();
		for (int ban : banned)
		{
			b.add(ban);
		}

		int sum = 0;
		int count = 0;

		for (int i = 1; i <= n; i++)
		{
			if (b.contains(i))
			{
				continue;
			}

			if (sum + i <= maxSum)
			{
				sum += i;
				count++;
			}
		}
		return count;
	}
}

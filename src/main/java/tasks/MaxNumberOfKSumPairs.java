package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/6/2020
 */
@LeetCode(
		id = 1679,
		name = "Max Number of K-Sum Pairs",
		url = "https://leetcode.com/problems/max-number-of-k-sum-pairs/",
		difficulty = Difficulty.MEDIUM
)
public class MaxNumberOfKSumPairs
{
	public int maxOperations(int[] nums, int k)
	{
		Map<Integer, Integer> memo = new HashMap<>();
		for (int num : nums)
		{
			memo.put(num, memo.getOrDefault(num, 0) + 1);
		}

		int operations = 0;
		int searchValue;
		int count;
		for (int num : nums)
		{
			searchValue = k - num;
			if (memo.containsKey(num) && memo.containsKey(searchValue) && (num != searchValue || (memo.get(searchValue) > 1)))
			{
				operations++;

				count = memo.remove(num) - 1;
				if (count > 0)
				{
					memo.put(num, count);
				}

				count = memo.remove(searchValue) - 1;
				if (count > 0)
				{
					memo.put(searchValue, count);
				}
			}
		}

		return operations;
	}
}

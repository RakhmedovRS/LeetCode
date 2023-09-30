package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 9/30/2023
 */
@LeetCode(
		id = 2869,
		name = "Minimum Operations to Collect Elements",
		url = "https://leetcode.com/problems/minimum-operations-to-collect-elements/description/",
		difficulty = Difficulty.EASY
)
public class MinimumOperationsToCollectElements
{
	public int minOperations(List<Integer> nums, int k)
	{
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= k; i++)
		{
			set.add(i);
		}

		int count = 0;
		for (int i = nums.size() - 1; i >= 0; i--)
		{
			count++;
			set.remove(nums.get(i));
			if (set.isEmpty())
			{
				return count;
			}
		}

		return nums.size();
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 10/28/2023
 */
@LeetCode(
		id = 2913,
		name = "Subarrays Distinct Element Sum of Squares I",
		url = "https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/",
		difficulty = Difficulty.EASY
)
public class SubarraysDistinctElementSumOfSquaresI
{
	public int sumCounts(List<Integer> nums)
	{
		int res = 0;
		for (int i = 0; i < nums.size(); i++)
		{
			Set<Integer> set = new HashSet<>();
			for (int j = i; j < nums.size(); j++)
			{
				set.add(nums.get(j));
				res += set.size() * set.size();
			}
		}

		return res;
	}
}

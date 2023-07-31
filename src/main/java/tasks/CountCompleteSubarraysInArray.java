package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 7/30/2023
 */
@LeetCode(
		id = 2799,
		name = "Count Complete Subarrays in an Array",
		url = "https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/",
		difficulty = Difficulty.MEDIUM
)
public class CountCompleteSubarraysInArray
{
	public int countCompleteSubarrays(int[] nums)
	{
		Set<Integer> set = new HashSet<>();
		for (int num: nums)
		{
			set.add(num);
		}

		int count = 0;
		for (int i = 0; i < nums.length; i++)
		{
			Set<Integer> s = new HashSet<>();
			for (int j = i; j < nums.length; j++)
			{
				s.add(nums[j]);
				if (s.size() == set.size())
				{
					count++;
				}
			}
		}

		return count;
	}
}

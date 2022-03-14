package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 11-Mar-20
 */
@LeetCode(
	id = 217,
	name = "Contains Duplicate",
	url = "https://leetcode.com/problems/contains-duplicate/",
	difficulty = Difficulty.EASY
)
public class ContainsDuplicate
{
	public boolean containsDuplicate(int[] nums)
	{
		Set<Integer> cache = new HashSet<>();
		for (int num : nums)
		{
			if (!cache.add(num))
			{
				return true;
			}
		}

		return false;
	}

	public boolean containsDuplicate1(int[] nums)
	{
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i-1] == nums[i])
			{
				return true;
			}
		}

		return false;
	}
}

package tasks;

import common.LeetCode;

import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 07-Jul-20
 */
@LeetCode(id = 456, name = "132 Pattern", url = "https://leetcode.com/problems/132-pattern/")
public class OneTwoThreePattern
{
	public boolean find132pattern(int[] nums)
	{
		int[] minimums = new int[nums.length];
		int prev = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++)
		{
			prev = Math.min(prev, nums[i]);
			minimums[i] = prev;
		}

		TreeMap<Integer, Integer> right = new TreeMap<>();
		for (int i = 1; i < nums.length; i++)
		{
			right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
		}

		int count;
		Integer floor;
		for (int i = 1; i < nums.length; i++)
		{
			if (minimums[i - 1] < nums[i])
			{
				floor = right.floorKey(nums[i] - 1);
				if (floor != null && minimums[i - 1] < floor)
				{
					return true;
				}
				else
				{
					count = right.remove(nums[i]) - 1;
					if (count > 0)
					{
						right.put(nums[i], count);
					}
				}
			}
			else
			{
				count = right.remove(nums[i]) - 1;
				if (count > 0)
				{
					right.put(nums[i], count);
				}
			}
		}

		return false;
	}
}

package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Apr-20
 */
@LeetCode(id = 747, name = "Largest Number At Least Twice of Others", url = "https://leetcode.com/problems/largest-number-at-least-twice-of-others/")
public class LargestNumberAtLeastTwiceOfOthers
{
	public int dominantIndex(int[] nums)
	{
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] > max)
			{
				max = nums[i];
				idx = i;
			}
		}

		for (int i = 0; i < nums.length; i++)
		{
			if (i != idx && max / 2 < nums[i])
			{
				return -1;
			}
		}

		return idx;
	}
}

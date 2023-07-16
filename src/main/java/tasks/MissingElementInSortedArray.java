package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/8/2020
 */
@LeetCode(
		id = 1060,
		name = "Missing Element in Sorted Array",
		url = "https://leetcode.com/problems/missing-element-in-sorted-array/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class MissingElementInSortedArray
{
	public int missingElement(int[] nums, int k)
	{
		int prev = nums[0];
		int diff;
		for (int i = 1; i < nums.length; i++)
		{
			diff = nums[i] - prev - 1;
			if (diff > 0)
			{
				if (k > diff)
				{
					k -= diff;
				}
				else
				{
					return prev + k;
				}
			}

			prev = nums[i];
		}

		return prev + k;
	}
}

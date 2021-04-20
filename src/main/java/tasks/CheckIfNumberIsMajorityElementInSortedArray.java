package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/9/2020
 */
@LeetCode(
	id = 1150,
	name = "Check If a Number Is Majority Element in a Sorted Array",
	url = "https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class CheckIfNumberIsMajorityElementInSortedArray
{
	public boolean isMajorityElement(int[] nums, int target)
	{
		int firstPos = binarySearch(nums, target, true);
		if (firstPos == -1)
		{
			return false;
		}
		int lastPos = binarySearch(nums, target, false);

		return (1 + lastPos - firstPos) > nums.length / 2;
	}

	private int binarySearch(int[] nums, int target, boolean first)
	{
		int left = 0;
		int right = nums.length - 1;
		int middle;
		int candidate = -1;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (nums[middle] == target)
			{
				candidate = middle;
				if (first)
				{
					right = middle - 1;
				}
				else
				{
					left = middle + 1;
				}
			}
			else if (nums[middle] > target)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}

		return candidate;
	}
}

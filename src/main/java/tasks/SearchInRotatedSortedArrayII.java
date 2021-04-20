package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Jul-20
 */
@LeetCode(
	id = 81,
	name = "Search in Rotated Sorted Array II",
	url = "https://leetcode.com/problems/search-in-rotated-sorted-array-ii/",
	difficulty = Difficulty.MEDIUM
)
public class SearchInRotatedSortedArrayII
{
	public boolean search(int[] nums, int target)
	{
		if (nums.length == 0)
		{
			return false;
		}

		int left = 0;
		int right = nums.length - 1;
		int middle;
		while (left <= right)
		{
			middle = left + (right - left) / 2;
			if (nums[middle] == target)
			{
				return true;
			}

			if (nums[middle] == nums[left])
			{
				left++;
				continue;
			}

			if (nums[left] < nums[middle])
			{
				if (nums[left] <= target && target < nums[middle])
				{
					right = middle - 1;
				}
				else
				{
					left = middle + 1;
				}
			}
			else
			{
				if (nums[middle] < target && target <= nums[right])
				{
					left = middle + 1;
				}
				else
				{
					right = middle - 1;
				}
			}
		}

		return false;
	}
}

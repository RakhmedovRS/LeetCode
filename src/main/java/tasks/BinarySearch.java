package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
@LeetCode(
	id = 704,
	name = "Binary Search",
	url = "https://leetcode.com/problems/binary-search/",
	difficulty = Difficulty.EASY
)
public class BinarySearch
{
	public int search(int[] nums, int target)
	{
		int left = 0;
		int mid;
		int right = nums.length - 1;
		while (left <= right)
		{
			mid = left + (right - left) / 2;
			if (nums[mid] == target)
			{
				return mid;
			}
			else if (nums[mid] > target)
			{
				right = mid - 1;
			}
			else
			{
				left = mid + 1;
			}
		}

		return -1;
	}
}

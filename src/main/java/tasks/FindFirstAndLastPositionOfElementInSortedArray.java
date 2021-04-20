package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Apr-20
 */
@LeetCode(id = 34, name = "Find First and Last Position of Element in Sorted Array", url = "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/")
public class FindFirstAndLastPositionOfElementInSortedArray
{
	public int[] searchRange(int[] nums, int target)
	{
		int[] result = new int[]{-1, -1};
		if (nums == null || nums.length == 0)
		{
			return result;
		}

		int middle = binarySearch(nums, 0, nums.length - 1, target);
		if (middle != -1)
		{
			result[0] = middle;
			result[1] = middle;

			while ((middle = binarySearch(nums, 0, result[0] - 1, target)) != -1)
			{
				result[0] = middle;
			}

			while ((middle = binarySearch(nums, result[1] + 1, nums.length - 1, target)) != -1)
			{
				result[1] = middle;
			}

		}

		return result;
	}

	private int binarySearch(int[] nums, int left, int right, int target)
	{
		if (left > right)
		{
			return -1;
		}
		int middle = left + (right - left) / 2;

		if (nums[middle] == target)
		{
			return middle;
		}
		else if (nums[middle] > target)
		{
			return binarySearch(nums, left, middle - 1, target);
		}
		else
		{
			return binarySearch(nums, middle + 1, right, target);
		}
	}
}

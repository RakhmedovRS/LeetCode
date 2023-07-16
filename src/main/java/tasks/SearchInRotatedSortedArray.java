package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Apr-20
 */
@LeetCode(
		id = 33,
		name = "Search in Rotated Sorted Array",
		url = "https://leetcode.com/problems/search-in-rotated-sorted-array/",
		difficulty = Difficulty.MEDIUM
)
public class SearchInRotatedSortedArray
{
	public int search(int[] nums, int target)
	{
		int left = 0;
		int right = nums.length - 1;
		int middle;
		while (left <= right)
		{
			middle = (left + right) / 2;

			if (nums[middle] == target)
			{
				return middle;
			}
			else if (nums[left] <= nums[middle])
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

		return -1;
	}

	public static void main(String[] args)
	{
		System.out.println(new SearchInRotatedSortedArray().search(new int[]{5, 1, 3}, 1));
		System.out.println(new SearchInRotatedSortedArray().search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0));
		System.out.println(new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
		System.out.println(new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
	}
}

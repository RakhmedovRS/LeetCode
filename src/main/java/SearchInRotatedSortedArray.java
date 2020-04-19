import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Apr-20
 */
@LeetCode(id = 33, name = "Search in Rotated Sorted Array", url = "https://leetcode.com/problems/search-in-rotated-sorted-array/")
public class SearchInRotatedSortedArray
{
	public int search(int[] nums, int target)
	{
		if (nums == null || nums.length == 0)
		{
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		int middle;
		while (left < right)
		{
			middle = left + (right - left) / 2;
			if (nums[middle] > nums[right])
			{
				left = middle + 1;
			}
			else
			{
				right = middle;
			}
		}

		if (target >= nums[left] && target <= nums[nums.length - 1])
		{
			right = nums.length - 1;
		}
		else
		{
			right = left - 1;
			left = 0;
		}

		while (left <= right)
		{
			middle = left + (right - left) / 2;
			if (nums[middle] == target)
			{
				return middle;
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

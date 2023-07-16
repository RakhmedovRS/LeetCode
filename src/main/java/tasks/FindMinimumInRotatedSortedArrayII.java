package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Jul-20
 */
@LeetCode(
		id = 154,
		name = "Find Minimum in Rotated Sorted Array II",
		url = "https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/",
		difficulty = Difficulty.HARD
)
public class FindMinimumInRotatedSortedArrayII
{
	public int findMin(int[] nums)
	{
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while (left < right)
		{
			mid = left + (right - left) / 2;
			if (nums[mid] > nums[right])
			{
				left = mid + 1;
			}
			else if (nums[left] < nums[mid])
			{
				right = mid - 1;
			}
			else
			{
				right--;
			}
		}

		return nums[left];
	}

	public static void main(String[] args)
	{
		System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{3, 3, 1, 3}));
		System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{2, 2, 2, 0, 1}));
		System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(new int[]{1, 2, 3}));
	}
}

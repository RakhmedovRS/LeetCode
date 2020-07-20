import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Jul-20
 */
@LeetCode(id = 81, name = "Search in Rotated Sorted Array II", url = "https://leetcode.com/problems/search-in-rotated-sorted-array-ii/")
public class SearchInRotatedSortedArrayII
{
	public boolean search(int[] nums, int target)
	{
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while (left <= right)
		{
			mid = left + (right - left) / 2;
			if (nums[mid] == target)
			{
				return true;
			}

			if (nums[mid] < nums[right] || nums[left] > nums[mid])
			{
				if (target > nums[mid] && target <= nums[right])
				{
					left = mid + 1;
				}
				else
				{
					right = mid - 1;
				}
			}
			else if (nums[mid] > nums[left] || nums[mid] > nums[right])
			{
				if (target < nums[mid] && target >= nums[left])
				{
					right = mid - 1;
				}
				else
				{
					left = mid + 1;
				}
			}
			else
			{
				right--;
			}
		}

		return false;
	}
}

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-May-20
 */
@LeetCode(id = 704, name = "Binary Search", url = "https://leetcode.com/problems/binary-search/")
public class BinarySearch
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
}

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(id = 162, name = "Find Peak Element", url = "https://leetcode.com/problems/find-peak-element/")
public class FindPeakElement
{

	public int findPeakElement(int[] nums)
	{
		return search(nums, 0, nums.length - 1);
	}

	public int search(int[] nums, int l, int r)
	{
		if (l == r)
		{
			return l;
		}
		int mid = (l + r) / 2;
		if (nums[mid] > nums[mid + 1])
		{
			return search(nums, l, mid);
		}
		return search(nums, mid + 1, r);
	}

	public int findPeakElement1(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
		{
			if ((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1]))
			{
				return i;
			}
		}
		return 0;
	}
}

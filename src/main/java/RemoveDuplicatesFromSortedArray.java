import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Mar-20
 */
@LeetCode(id = 26, name = "Remove Duplicates from Sorted Array", url = "https://leetcode.com/problems/remove-duplicates-from-sorted-array/")
public class RemoveDuplicatesFromSortedArray
{
	public int removeDuplicates(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int endSubArray = 0;
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[endSubArray] != nums[i])
			{
				nums[++endSubArray] = nums[i];
			}
		}

		return endSubArray + 1;
	}
}

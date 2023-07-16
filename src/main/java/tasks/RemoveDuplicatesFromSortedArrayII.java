package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/11/2020
 */
@LeetCode(
		id = 80,
		name = "Remove Duplicates from Sorted Array II",
		url = "https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveDuplicatesFromSortedArrayII
{
	public int removeDuplicates(int[] nums)
	{
		markBadPositions(nums);
		int i = 0;
		while (i < nums.length && nums[i] != Integer.MIN_VALUE)
		{
			i++;
		}

		for (int j = i + 1; j < nums.length; j++)
		{
			if (nums[j] != Integer.MIN_VALUE)
			{
				nums[i++] = nums[j];
			}
		}

		return i;
	}

	private void markBadPositions(int[] nums)
	{
		int prev = Integer.MIN_VALUE;
		int prevCount = 0;
		int pos = 0;
		while (pos < nums.length)
		{
			if (nums[pos] != prev)
			{
				prev = nums[pos];
				prevCount = 1;
			}
			else
			{
				prevCount++;
			}

			if (prevCount > 2)
			{
				nums[pos] = Integer.MIN_VALUE;
			}

			pos++;
		}
	}
}

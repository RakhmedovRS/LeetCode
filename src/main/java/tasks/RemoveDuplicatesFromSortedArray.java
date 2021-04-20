package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11-Mar-20
 */
@LeetCode(id = 26, name = "Remove Duplicates from Sorted Array", url = "https://leetcode.com/problems/remove-duplicates-from-sorted-array/")
public class RemoveDuplicatesFromSortedArray
{
	public int removeDuplicates(int[] nums)
	{
		int pos = 1;
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] != nums[i - 1])
			{
				nums[pos++] = nums[i];
			}
		}

		return pos;
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		int pos = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
		System.out.println(Arrays.toString(Arrays.copyOf(arr, pos)));
	}
}

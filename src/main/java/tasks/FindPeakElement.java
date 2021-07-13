package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(
	id = 162,
	name = "Find Peak Element",
	url = "https://leetcode.com/problems/find-peak-element/",
	difficulty = Difficulty.MEDIUM
)
public class FindPeakElement
{
	public int findPeakElement(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		int middle;
		while (left < right)
		{
			middle = left + (right - left) / 2;

			if (nums[middle] < nums[middle + 1])
			{
				left = middle + 1;
			}
			else
			{
				right = middle;
			}
		}
		return left;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindPeakElement().findPeakElement(new int[]{1, 2}));
		System.out.println(new FindPeakElement().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
		System.out.println(new FindPeakElement().findPeakElement(new int[]{1, 2, 3, 1}));
	}
}

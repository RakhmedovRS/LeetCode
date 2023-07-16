package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Apr-20
 */
@LeetCode(
		id = 34,
		name = "Find First and Last Position of Element in Sorted Array",
		url = "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/",
		difficulty = Difficulty.MEDIUM
)
public class FindFirstAndLastPositionOfElementInSortedArray
{
	public int[] searchRange(int[] nums, int target)
	{
		int[] answer = new int[]{-1, -1};
		answer[0] = binarySearch(nums, target, true);
		if (answer[0] != -1)
		{
			answer[1] = binarySearch(nums, target, false);
		}

		return answer;
	}

	private int binarySearch(int[] nums, int target, boolean lookingForTheFirstPos)
	{
		int index = -1;
		int left = 0;
		int middle;
		int right = nums.length - 1;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (nums[middle] == target)
			{
				index = middle;
				if (lookingForTheFirstPos)
				{
					right = middle - 1;
				}
				else
				{
					left = middle + 1;
				}
			}
			else if (nums[middle] < target)
			{
				left = middle + 1;
			}
			else
			{
				right = middle - 1;
			}
		}

		return index;
	}
}

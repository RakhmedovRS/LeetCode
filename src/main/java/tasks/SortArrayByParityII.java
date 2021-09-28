package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
@LeetCode(
	id = 922,
	name = "Sort Array By Parity II",
	url = "https://leetcode.com/problems/sort-array-by-parity-ii/",
	difficulty = Difficulty.EASY
)
public class SortArrayByParityII
{
	public int[] sortArrayByParityII(int[] nums)
	{
		int j = 1;
		for (int i = 0; i < nums.length; i += 2)
		{
			if (nums[i] % 2 != 0)
			{
				while (j < nums.length && nums[j] % 2 != 0)
				{
					j+=2;
				}

				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}

		return nums;
	}

	private void swap(int[] nums, int left, int right)
	{
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}

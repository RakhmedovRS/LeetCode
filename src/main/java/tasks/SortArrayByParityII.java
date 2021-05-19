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
		int odd = 0;
		int even = 0;

		for (int i = 0; i < nums.length; i++)
		{
			if (i % 2 == 0)
			{
				while (nums[even] % 2 != 0)
				{
					even++;
				}

				swap(nums, i, even++);
			}
			else
			{
				while (nums[odd] % 2 == 0)
				{
					odd++;
				}

				swap(nums, i, odd++);
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

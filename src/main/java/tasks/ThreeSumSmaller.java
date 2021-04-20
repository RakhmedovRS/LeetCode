package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 3/5/2021
 */
@LeetCode(
	id = 259,
	name = "3Sum Smaller",
	url = "https://leetcode.com/problems/3sum-smaller/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class ThreeSumSmaller
{
	public int threeSumSmaller(int[] nums, int target)
	{
		Arrays.sort(nums);
		int count = 0;
		int sum;
		for (int a = 0; a < nums.length; a++)
		{
			for (int b = a + 1; b < nums.length; b++)
			{
				sum = nums[a] + nums[b];

				int pos = binarySearch(nums, b + 1, target - sum);

				if (pos != -1)
				{
					count += (pos - b);
				}
			}
		}
		return count;
	}

	private int binarySearch(int[] nums, int left, int target)
	{
		int pos = -1;
		int middle;
		int right = nums.length - 1;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (target > nums[middle])
			{
				pos = middle;
				left = middle + 1;
			}
			else
			{
				right = middle - 1;
			}
		}

		return pos;
	}
}

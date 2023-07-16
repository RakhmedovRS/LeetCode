package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/2/2023
 */
@LeetCode(
		id = 2760,
		name = "Longest Even Odd Subarray With Threshold",
		url = "https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/",
		difficulty = Difficulty.EASY
)
public class LongestEvenOddSubarrayWithThreshold
{
	public int longestAlternatingSubarray(int[] nums, int threshold)
	{
		int max = 0;
		for (int num : nums)
		{
			if (num <= threshold && num % 2 == 0)
			{
				max = 1;
				break;
			}
		}


		outer:
		for (int l = 0; l < nums.length; l++)
		{
			if (nums[l] % 2 != 0 || nums[l] > threshold)
			{
				continue;
			}

			for (int r = l + 1; r < nums.length; r++)
			{
				if (nums[r] > threshold || nums[r - 1] > threshold || nums[r - 1] % 2 == nums[r] % 2)
				{
					continue outer;
				}

				max = Math.max(max, 1 + r - l);
			}
		}

		return max;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/12/2021
 */
@LeetCode(
		id = 2104,
		name = "Sum of Subarray Ranges",
		url = "https://leetcode.com/problems/sum-of-subarray-ranges/",
		difficulty = Difficulty.MEDIUM
)
public class SumOfSubarrayRanges
{
	public long subArrayRanges(int[] nums)
	{
		long sum = 0;
		for (int i = 0; i < nums.length; i++)
		{
			int min = nums[i];
			int max = nums[i];
			for (int j = i; j < nums.length; j++)
			{
				min = Math.min(min, nums[j]);
				max = Math.max(max, nums[j]);

				sum += (max - min);
			}
		}

		return sum;
	}
}

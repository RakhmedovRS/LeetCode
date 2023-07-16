package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/1/2020
 */
@LeetCode(
		id = 644,
		name = "Maximum Average Subarray II",
		url = "https://leetcode.com/problems/maximum-average-subarray-ii/",
		difficulty = Difficulty.HARD,
		premium = true
)
public class MaximumAverageSubarrayII
{
	public double findMaxAverage(int[] nums, int k)
	{
		double min = nums[0];
		double max = nums[0];
		for (int num : nums)
		{
			min = Math.min(min, num);
			max = Math.max(max, num);
		}

		double middle;
		while (max - min > 0.00001)
		{
			middle = (min + max) / 2;
			if (check(nums, k, middle))
			{
				min = middle;
			}
			else
			{
				max = middle;
			}
		}

		return max;
	}

	private boolean check(int[] nums, int k, double middle)
	{
		double sum = 0;
		double minSum = 0;
		double prev = 0;
		for (int i = 0; i < k; i++)
		{
			sum += nums[i] - middle;
		}

		if (sum >= 0)
		{
			return true;
		}

		for (int i = k; i < nums.length; i++)
		{
			sum += nums[i] - middle;
			prev += nums[i - k] - middle;
			minSum = Math.min(prev, minSum);
			if (sum >= minSum)
			{
				return true;
			}
		}

		return false;
	}
}

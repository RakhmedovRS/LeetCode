package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/19/2021
 */
@LeetCode(
		id = 2012,
		name = "Sum of Beauty in the Array",
		url = "https://leetcode.com/problems/sum-of-beauty-in-the-array/",
		difficulty = Difficulty.MEDIUM
)
public class SumOfBeautyInTheArray
{
	public int sumOfBeauties(int[] nums)
	{
		int n = nums.length;
		int sum = 0;
		int[] maxFromLeft = new int[n];
		int[] minFromRight = new int[n];

		maxFromLeft[0] = nums[0];
		minFromRight[n - 1] = nums[n - 1];

		for (int i = 1; i < n; i++)
		{
			maxFromLeft[i] = Math.max(maxFromLeft[i - 1], nums[i]);
		}

		for (int i = n - 2; i >= 0; i--)
		{
			minFromRight[i] = Math.min(minFromRight[i + 1], nums[i]);
		}

		for (int i = 1; i < n - 1; i++)
		{
			if (maxFromLeft[i - 1] < nums[i] && nums[i] < minFromRight[i + 1])
			{
				sum += 2;
			}
			else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1])
			{
				sum += 1;
			}
		}

		return sum;
	}
}

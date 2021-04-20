package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/21/2021
 */
@LeetCode(
	id = 1800,
	name = "Maximum Ascending Subarray Sum",
	url = "https://leetcode.com/problems/maximum-ascending-subarray-sum/",
	difficulty = Difficulty.EASY
)
public class MaximumAscendingSubarraySum
{
	public int maxAscendingSum(int[] nums)
	{
		int max = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (i > 0 && nums[i] <= nums[i - 1])
			{
				sum = 0;
			}

			sum += nums[i];

			max = Math.max(max, sum);
		}

		return max;
	}

	public static void main(String[] args)
	{
		MaximumAscendingSubarraySum clazz = new MaximumAscendingSubarraySum();

		System.out.println(clazz.maxAscendingSum(new int[]{3, 6, 10, 1, 8, 9, 9, 8, 9}));
		System.out.println(clazz.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
		System.out.println(clazz.maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
		System.out.println(clazz.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
		System.out.println(clazz.maxAscendingSum(new int[]{1, 2, 3}));
	}
}

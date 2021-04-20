package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/22/2020
 */
@LeetCode(
	id = 1664,
	name = "Ways to Make a Fair Array",
	url = "https://leetcode.com/problems/ways-to-make-a-fair-array/",
	difficulty = Difficulty.MEDIUM
)
public class WaysToMakeFairArray
{
	public int waysToMakeFair(int[] nums)
	{
		int totalEvenSum = 0;
		int totalOddSum = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (i % 2 == 0)
			{
				totalEvenSum += nums[i];
			}
			else
			{
				totalOddSum += nums[i];
			}
		}

		int ways = 0;
		int currentEvenSum = 0;
		int currentOddSum = 0;
		int even;
		int odd;
		for (int i = 0; i < nums.length; i++)
		{
			if (i % 2 == 0)
			{
				currentEvenSum += nums[i];
				even = currentEvenSum - nums[i] + totalOddSum - currentOddSum;
				odd = currentOddSum + totalEvenSum - currentEvenSum;
			}
			else
			{
				currentOddSum += nums[i];
				even = currentEvenSum + totalOddSum - currentOddSum;
				odd = currentOddSum - nums[i] + totalEvenSum - currentEvenSum;
			}

			if (even == odd)
			{
				ways++;
			}
		}

		return ways;
	}

	public static void main(String[] args)
	{
		System.out.println(new WaysToMakeFairArray().waysToMakeFair(new int[]{1, 1, 1}));
		System.out.println(new WaysToMakeFairArray().waysToMakeFair(new int[]{1, 2, 3}));
		System.out.println(new WaysToMakeFairArray().waysToMakeFair(new int[]{2, 1, 6, 4}));
	}
}

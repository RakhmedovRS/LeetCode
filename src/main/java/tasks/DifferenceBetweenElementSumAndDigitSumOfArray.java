package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/15/2023
 */
@LeetCode(
		id = 2535,
		name = "Difference Between Element Sum and Digit Sum of an Array",
		url = "https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/",
		difficulty = Difficulty.EASY
)
public class DifferenceBetweenElementSumAndDigitSumOfArray
{
	public int differenceOfSum(int[] nums)
	{
		int eSum = 0;
		int dSum = 0;
		for (int num : nums)
		{
			eSum += num;
			while (num > 0)
			{
				dSum += num % 10;
				num /= 10;
			}
		}

		return Math.abs(eSum - dSum);
	}
}

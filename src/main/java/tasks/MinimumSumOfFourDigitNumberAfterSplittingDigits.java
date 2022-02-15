package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/15/2022
 */
@LeetCode(
	id = 2160,
	name = "Minimum Sum of Four Digit Number After Splitting Digits",
	url = "https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/",
	difficulty = Difficulty.EASY
)
public class MinimumSumOfFourDigitNumberAfterSplittingDigits
{
	public int minimumSum(int num)
	{
		int[] memo = new int[10];
		for (int i = 0; i < 4; i++)
		{
			memo[num % 10]++;
			num /= 10;
		}

		int result = 0;
		int seen = 0;
		while (seen < 2)
		{
			for (int i = 0; i < memo.length; i++)
			{
				if (memo[i] > 0)
				{
					result += i * 10;
					seen++;
					memo[i]--;
					break;
				}
			}
		}

		for (int i = 0; i < memo.length; i++)
		{
			result += i * memo[i];
		}
		return result;
	}
}

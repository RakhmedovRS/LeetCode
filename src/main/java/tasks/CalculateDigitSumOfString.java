package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/17/2022
 */
@LeetCode(
	id = 2243,
	name = "Calculate Digit Sum of a String",
	url = "https://leetcode.com/problems/calculate-digit-sum-of-a-string/",
	difficulty = Difficulty.EASY
)
public class CalculateDigitSumOfString
{
	public String digitSum(String s, int k)
	{
		if (s.length() <= k)
		{
			return s;
		}

		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i+= k)
		{
			for (int j = i; j < Math.min(s.length(), i + k); j++)
			{
				sum += s.charAt(j) - '0';
			}

			sb.append(sum);
			sum = 0;
		}

		return digitSum(sb.toString(), k);
	}
}

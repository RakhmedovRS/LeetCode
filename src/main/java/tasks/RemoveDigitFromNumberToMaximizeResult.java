package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/1/2022
 */
@LeetCode(
		id = 2259,
		name = "Remove Digit From Number to Maximize Result",
		url = "https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/",
		difficulty = Difficulty.EASY
)
public class RemoveDigitFromNumberToMaximizeResult
{
	public String removeDigit(String number, char digit)
	{
		java.math.BigInteger max = java.math.BigInteger.ZERO;
		String res = number;
		for (int i = 0; i < number.length(); i++)
		{
			if (number.charAt(i) == digit)
			{
				java.math.BigInteger num = new java.math.BigInteger(number.substring(0, i) + number.substring(i + 1));
				if (num.compareTo(max) > 0)
				{
					res = number.substring(0, i) + number.substring(i + 1);
					max = num;
				}
			}
		}

		return res;
	}
}

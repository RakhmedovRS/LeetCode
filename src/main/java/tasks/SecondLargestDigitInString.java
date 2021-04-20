package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/20/2021
 */
@LeetCode(
	id = 1796,
	name = "Second Largest Digit in a String",
	url = "https://leetcode.com/problems/second-largest-digit-in-a-string/",
	difficulty = Difficulty.EASY
)
public class SecondLargestDigitInString
{
	public int secondHighest(String s)
	{
		boolean[] digits = new boolean[10];
		for (char ch : s.toCharArray())
		{
			if (Character.isDigit(ch))
			{
				digits[ch - '0'] = true;
			}
		}

		boolean seenNumber = false;
		for (int i = 9; i >=0; i--)
		{
			if (digits[i])
			{
				if (seenNumber)
				{
					return i;
				}

				seenNumber = true;
			}
		}

		return -1;
	}
}

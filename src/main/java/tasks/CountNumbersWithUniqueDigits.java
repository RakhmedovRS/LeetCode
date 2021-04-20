package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Jun-20
 */
@LeetCode(id = 357, name = "Count Numbers with Unique Digits", url = "https://leetcode.com/problems/count-numbers-with-unique-digits/")
public class CountNumbersWithUniqueDigits
{
	public int countNumbersWithUniqueDigits(int n)
	{
		if (n == 0)
		{
			return 1;
		}

		int result = 10;
		if (n > 1)
		{
			int unique = 9;
			for (int i = 1; i < n; i++)
			{
				unique *= (10 - i);
				result += unique;
			}
		}

		return result;
	}
}

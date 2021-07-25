package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/25/2021
 */
@LeetCode(
	id = 1945,
	name = "Sum of Digits of String After Convert",
	url = "https://leetcode.com/problems/sum-of-digits-of-string-after-convert/",
	difficulty = Difficulty.EASY
)
public class SumOfDigitsOfStringAfterConvert
{
	public int getLucky(String s, int k)
	{
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray())
		{
			sb.append(1 + ch - 'a');
		}

		String num = sb.toString();
		for (int i = 0; i < k; i++)
		{
			num = modify(num);
		}

		return Integer.parseInt(num);
	}

	private String modify(String num)
	{
		int numTemp = 0;
		for (char ch : num.toCharArray())
		{
			numTemp += ch - '0';
		}

		return String.valueOf(numTemp);
	}
}

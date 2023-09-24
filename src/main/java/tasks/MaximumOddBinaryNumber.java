package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/23/2023
 */
@LeetCode(
		id = 2864,
		name = "Maximum Odd Binary Number",
		url = "https://leetcode.com/problems/maximum-odd-binary-number/",
		difficulty = Difficulty.EASY
)
public class MaximumOddBinaryNumber
{
	public String maximumOddBinaryNumber(String s)
	{
		int count = 0;
		for (char ch : s.toCharArray())
		{
			if ('1' == ch)
			{
				count++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append('1');
		count--;
		for (int i = 1; i < s.length() - count; i++)
		{
			sb.append('0');
		}

		while (count-- > 0)
		{
			sb.append('1');
		}

		return sb.reverse().toString();
	}
}

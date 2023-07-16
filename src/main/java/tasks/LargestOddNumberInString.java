package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/20/2021
 */
@LeetCode(
		id = 1903,
		name = "Largest Odd Number in String",
		url = "https://leetcode.com/problems/largest-odd-number-in-string/",
		difficulty = Difficulty.EASY
)
public class LargestOddNumberInString
{
	public String largestOddNumber(String num)
	{
		for (int i = num.length() - 1; i >= 0; i--)
		{
			if ((num.charAt(i) - '0') % 2 != 0)
			{
				return num.substring(0, i + 1);
			}
		}

		return "";
	}
}

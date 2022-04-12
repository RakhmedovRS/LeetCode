package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Jul-20
 */
@LeetCode(
	id = 504,
	name = "Base 7",
	url = "https://leetcode.com/problems/base-7/",
	difficulty = Difficulty.EASY
)
public class Base7
{
	public String convertToBase7(int num)
	{
		if (num == 0)
		{
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		String sign = num < 0 ? "-" : "";

		while (num != 0)
		{
			sb.append(Math.abs(num % 7));
			num /= 7;
		}

		return sign + sb.reverse().toString();
	}
}

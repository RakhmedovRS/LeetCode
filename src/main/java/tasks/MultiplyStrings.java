package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/7/2021
 */
@LeetCode(
		id = 43,
		name = "Multiply Strings",
		url = "https://leetcode.com/problems/multiply-strings/",
		difficulty = Difficulty.MEDIUM
)
public class MultiplyStrings
{
	public String multiply(String num1, String num2)
	{
		int[] result = new int[num1.length() + num2.length()];
		int res;
		int pos = 0;
		for (int a = num1.length() - 1; a >= 0; a--)
		{
			int innerPos = pos;
			for (int b = num2.length() - 1; b >= 0; b--)
			{
				res = (num1.charAt(a) - '0') * (num2.charAt(b) - '0');
				result[innerPos] += res % 10;
				result[innerPos + 1] += res / 10;
				innerPos++;
			}
			pos++;
		}

		for (int i = 0; i < result.length - 1; i++)
		{
			if (result[i] > 9)
			{
				result[i + 1] += result[i] / 10;
				result[i] %= 10;
			}
		}

		int i = result.length - 1;
		while (i > 0 && result[i] == 0)
		{
			i--;
		}

		StringBuilder stringBuilder = new StringBuilder(result.length - i);
		for (; i >= 0; i--)
		{
			stringBuilder.append(result[i]);
		}
		return stringBuilder.toString();
	}
}

package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 22-Aug-20
 */
@LeetCode(id = 1556, name = "Thousand Separator", url = "https://leetcode.com/problems/thousand-separator/")
public class ThousandSeparator
{
	public String thousandSeparator(int n)
	{
		if (n == 0)
		{
			return "0";
		}

		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (n > 0)
		{
			if (count == 3)
			{
				count = 0;
				sb.append('.');
			}

			sb.append(n % 10);
			n /= 10;
			count++;
		}

		return sb.reverse().toString();
	}
}

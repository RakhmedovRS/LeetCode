package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/30/2021
 */
@LeetCode(
		id = 1881,
		name = "Maximum Value after Insertion",
		url = "https://leetcode.com/problems/maximum-value-after-insertion/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumValueAfterInsertion
{
	public String maxValue(String n, int x)
	{
		if (n.length() == 1 && n.charAt(0) == '-')
		{
			return "-" + x;
		}

		StringBuilder sb = new StringBuilder();
		boolean xUsed = false;
		if (n.charAt(0) == '-')
		{
			sb.append('-');
			for (int i = 1; i < n.length(); i++)
			{
				if (!xUsed && x < n.charAt(i) - '0')
				{
					sb.append(x);
					xUsed = true;
				}

				sb.append(n.charAt(i));
			}
		}
		else
		{
			for (char ch : n.toCharArray())
			{
				if (!xUsed && x > ch - '0')
				{
					sb.append(x);
					xUsed = true;
				}
				sb.append(ch);
			}
		}

		if (!xUsed)
		{
			sb.append(x);
		}

		return sb.toString();
	}
}

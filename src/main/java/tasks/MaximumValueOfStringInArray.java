package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/13/2022
 */
@LeetCode(
		id = 2496,
		name = "Maximum Value of a String in an Array",
		url = "https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/description/",
		difficulty = Difficulty.EASY
)
public class MaximumValueOfStringInArray
{
	public int maximumValue(String[] strs)
	{
		int max = 0;
		for (String str : strs)
		{
			boolean seenChar = false;
			for (char ch : str.toCharArray())
			{
				if (!Character.isDigit(ch))
				{
					seenChar = true;
				}
			}

			if (seenChar)
			{
				max = Math.max(max, str.length());
			}
			else
			{
				max = Math.max(max, Integer.parseInt(str));
			}
		}

		return max;
	}
}

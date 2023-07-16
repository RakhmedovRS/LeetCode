package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/2/2021
 */
@LeetCode(
		id = 1849,
		name = "Splitting a String Into Descending Consecutive Values",
		url = "https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/",
		difficulty = Difficulty.MEDIUM
)
public class SplittingStringIntoDescendingConsecutiveValues
{
	public boolean splitString(String s)
	{
		return dfs(null, 0, 0, s.toCharArray());
	}

	private boolean dfs(Long prev, int pos, int found, char[] chars)
	{
		if (pos >= chars.length)
		{
			return found > 1;
		}

		long val = 0;
		for (int i = pos; i < chars.length; i++)
		{
			val *= 10;
			val += chars[i] - '0';
			if (prev == null)
			{
				if (dfs(val, i + 1, found + 1, chars))
				{
					return true;
				}
			}
			else if (prev - val == 1 && dfs(val, i + 1, found + 1, chars))
			{
				return true;
			}
		}

		return false;
	}
}

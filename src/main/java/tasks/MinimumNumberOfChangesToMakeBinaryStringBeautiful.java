package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/28/2023
 */
@LeetCode(
		id = 2914,
		name = "Minimum Number of Changes to Make Binary String Beautiful",
		url = "https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfChangesToMakeBinaryStringBeautiful
{
	public int minChanges(String s)
	{
		int diff = 0;
		for (int i = 1; i < s.length(); i += 2)
		{
			if (s.charAt(i -1) != s.charAt(i))
			{
				diff++;
			}
		}
		return diff;
	}
}

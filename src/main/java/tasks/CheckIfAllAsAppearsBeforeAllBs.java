package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/2/2022
 */
@LeetCode(
		id = 2124,
		name = "Check if All A's Appears Before All B's",
		url = "https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/",
		difficulty = Difficulty.EASY
)
public class CheckIfAllAsAppearsBeforeAllBs
{
	public boolean checkString(String s)
	{
		boolean seenB = false;
		for (char ch : s.toCharArray())
		{
			if (ch == 'a')
			{
				if (seenB)
				{
					return false;
				}
			}
			else
			{
				seenB = true;
			}
		}

		return true;
	}
}

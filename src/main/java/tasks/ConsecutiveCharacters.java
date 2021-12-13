package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(
	id = 1446,
	name = "Consecutive Characters",
	url = "https://leetcode.com/problems/consecutive-characters/",
	difficulty = Difficulty.EASY
)
public class ConsecutiveCharacters
{
	public int maxPower(String s)
	{
		int max = 0;
		int currentCount = 0;
		char ch = ' ';
		for (char c : s.toCharArray())
		{
			if (c == ch)
			{
				currentCount++;
			}
			else
			{
				ch = c;
				currentCount = 1;
			}

			max = Math.max(max, currentCount);
		}

		return max;
	}
}

package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/17/2021
 */
@LeetCode(
	id = 2042,
	name = "Check if Numbers Are Ascending in a Sentence",
	url = "https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/",
	difficulty = Difficulty.EASY
)
public class CheckIfNumbersAreAscendingInSentence
{
	public boolean areNumbersAscending(String s)
	{
		String[] strings = s.split(" ");
		Integer prev = null;
		for (String string : strings)
		{
			if (Character.isDigit(string.charAt(0)))
			{
				if (prev == null)
				{
					prev = Integer.parseInt(string);
				}
				else
				{
					int curr = Integer.parseInt(string);
					if (prev >= curr)
					{
						return false;
					}

					prev = curr;
				}
			}
		}

		return true;
	}
}

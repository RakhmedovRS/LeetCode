package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 8/15/2021
 */
@LeetCode(
		id = 1967,
		name = "Number of Strings That Appear as Substrings in Word",
		url = "https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/",
		difficulty = Difficulty.EASY
)
public class NumberOfStringsThatAppearAsSubstringsInWord
{
	public int numOfStrings(String[] patterns, String word)
	{
		int count = 0;
		for (String pattern : patterns)
		{
			if (word.contains(pattern))
			{
				count++;
			}
		}

		return count;
	}
}

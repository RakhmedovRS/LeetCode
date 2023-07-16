package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/22/2022
 */
@LeetCode(
		id = 2278,
		name = "Percentage of Letter in String",
		url = "https://leetcode.com/problems/percentage-of-letter-in-string/",
		difficulty = Difficulty.EASY
)
public class PercentageOfLetterInString
{
	public int percentageLetter(String s, char letter)
	{
		double count = 0;
		for (char ch : s.toCharArray())
		{
			if (ch == letter)
			{
				count++;
			}
		}

		return (int) ((count / s.length()) * 100);
	}
}

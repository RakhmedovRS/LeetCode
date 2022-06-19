package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/19/2022
 */
@LeetCode(
	id = 2309,
	name = "Greatest English Letter in Upper and Lower Case",
	url = "https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/",
	difficulty = Difficulty.EASY
)
public class GreatestEnglishLetterInUpperAndLowerCase
{
	public String greatestLetter(String s)
	{
		boolean[] lower = new boolean[26];
		boolean[] upper = new boolean[26];

		for (char ch : s.toCharArray())
		{
			if (Character.isUpperCase(ch))
			{
				upper[ch - 'A'] = true;
			}
			else
			{
				lower[ch - 'a'] = true;
			}
		}

		for (int i = 25; i >= 0; i--)
		{
			if (lower[i] && upper[i])
			{
				return "" + (char) (i + 'A');
			}
		}

		return "";
	}
}

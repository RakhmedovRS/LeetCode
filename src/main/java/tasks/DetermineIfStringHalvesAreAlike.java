package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/27/2020
 */
@LeetCode(
	id = 1704,
	name = "Determine if String Halves Are Alike",
	url = "https://leetcode.com/problems/determine-if-string-halves-are-alike/",
	difficulty = Difficulty.EASY
)
public class DetermineIfStringHalvesAreAlike
{
	public boolean halvesAreAlike(String s)
	{
		int balance = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (isVowel(s.charAt(i)))
			{
				balance += i < (s.length() / 2) ? 1 : -1;
			}
		}

		return balance == 0;
	}

	private boolean isVowel(char ch)
	{
		ch = Character.toLowerCase(ch);

		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}

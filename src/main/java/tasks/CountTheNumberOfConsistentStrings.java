package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/12/2020
 */
@LeetCode(
		id = 1684,
		name = "Count the Number of Consistent Strings",
		url = "https://leetcode.com/problems/count-the-number-of-consistent-strings/",
		difficulty = Difficulty.EASY
)
public class CountTheNumberOfConsistentStrings
{
	public int countConsistentStrings(String allowed, String[] words)
	{
		char[] table = new char[26];
		for (char ch : allowed.toCharArray())
		{
			table[ch - 'a']++;
		}

		int count = 0;
		outer:
		for (String word : words)
		{
			for (char ch : word.toCharArray())
			{
				if (table[ch - 'a'] == 0)
				{
					continue outer;
				}
			}
			count++;
		}

		return count;
	}
}

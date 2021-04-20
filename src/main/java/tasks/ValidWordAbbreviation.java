package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/29/2020
 */
@LeetCode(
	id = 408,
	name = "Valid Word Abbreviation",
	url = "https://leetcode.com/problems/valid-word-abbreviation/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class ValidWordAbbreviation
{
	public boolean validWordAbbreviation(String word, String abbr)
	{
		int i = 0;
		int j = 0;
		while (i < word.length() && j < abbr.length())
		{
			if (Character.isLetter(abbr.charAt(j)))
			{
				if (word.charAt(i++) != abbr.charAt(j++))
				{
					return false;
				}
			}
			else
			{
				int count = 0;
				while (j < abbr.length() && Character.isDigit(abbr.charAt(j)))
				{
					if (abbr.charAt(j) - '0' == 0 && count == 0)
					{
						return false;
					}
					count *= 10;
					count += abbr.charAt(j++) - '0';
				}

				i += count;

				if (i > word.length())
				{
					return false;
				}
			}
		}

		return i == word.length() && j == abbr.length();
	}
}

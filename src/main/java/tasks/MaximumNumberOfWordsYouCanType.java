package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/18/2021
 */
@LeetCode(
	id = 1935,
	name = "Maximum Number of Words You Can Type",
	url = "https://leetcode.com/problems/maximum-number-of-words-you-can-type/",
	difficulty = Difficulty.EASY
)
public class MaximumNumberOfWordsYouCanType
{
	public int canBeTypedWords(String text, String brokenLetters)
	{
		boolean[] broken = new boolean[26];
		for (char ch : brokenLetters.toCharArray())
		{
			broken[ch - 'a'] = true;
		}

		int count = 0;
		String[] words = text.split(" ");
		outer:
		for (String word : words)
		{
			for (char ch : word.toCharArray())
			{
				if (broken[ch - 'a'])
				{
					continue outer;
				}
			}
			count++;
		}

		return count;
	}
}

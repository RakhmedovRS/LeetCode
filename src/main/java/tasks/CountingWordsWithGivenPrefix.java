package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/27/2022
 */
@LeetCode(
	id = 2185,
	name = "Counting Words With a Given Prefix",
	url = "https://leetcode.com/problems/counting-words-with-a-given-prefix/",
	difficulty = Difficulty.EASY
)
public class CountingWordsWithGivenPrefix
{
	public int prefixCount(String[] words, String pref)
	{
		int count = 0;
		for (String word : words)
		{
			if (word.startsWith(pref))
			{
				count++;
			}
		}

		return count;
	}
}

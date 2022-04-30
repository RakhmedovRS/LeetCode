package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/30/2022
 */
@LeetCode(
	id = 2255,
	name = "Count Prefixes of a Given String",
	url = "https://leetcode.com/problems/count-prefixes-of-a-given-string/",
	difficulty = Difficulty.EASY
)
public class CountPrefixesOfGivenString
{
	public int countPrefixes(String[] words, String s)
	{
		int count = 0;
		for (String word : words)
		{
			if (s.startsWith(word))
			{
				count++;
			}
		}

		return count;
	}
}

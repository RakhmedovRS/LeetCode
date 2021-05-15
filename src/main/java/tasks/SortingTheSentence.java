package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/15/2021
 */
@LeetCode(
	id = 1859,
	name = "Sorting the Sentence",
	url = "https://leetcode.com/problems/sorting-the-sentence/",
	difficulty = Difficulty.EASY
)
public class SortingTheSentence
{
	public String sortSentence(String s)
	{
		String[] words = new String[10];
		String[] strings = s.split(" ");
		for (String string : strings)
		{
			words[string.charAt(string.length() - 1) - '0'] = string.substring(0, string.length() - 1);
		}

		StringBuilder sb = new StringBuilder();
		for (String w : words)
		{
			if (w == null)
			{
				continue;
			}

			if (sb.length() != 0)
			{
				sb.append(" ");
			}

			sb.append(w);
		}

		return sb.toString();
	}
}

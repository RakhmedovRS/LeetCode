package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 02-Jul-20
 */
@LeetCode(
	id = 1048,
	name = "Longest String Chain",
	url = "https://leetcode.com/problems/longest-string-chain/",
	difficulty = Difficulty.MEDIUM
)
public class LongestStringChain
{
	public int longestStrChain(String[] words)
	{
		Arrays.sort(words, (a, b) ->
		{
			if (a.length() == b.length())
			{
				return a.compareTo(b);
			}

			return a.length() - b.length();
		});

		int count;
		int maxCount = 0;
		String tempWord;
		Map<String, Integer> wordToCount = new HashMap<>();

		for (String word : words)
		{
			count = 0;
			for (int i = 0; i < word.length(); i++)
			{
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < word.length(); j++)
				{
					if (i != j)
					{
						sb.append(word.charAt(j));
					}
				}

				tempWord = sb.toString();
				count = Math.max(count, wordToCount.getOrDefault(tempWord, 0) + 1);
			}

			wordToCount.put(word, count);
			maxCount = Math.max(maxCount, count);
		}

		return maxCount;
	}
}
